function createDefaultComboBox(wrapperElementId, dataSource, fieldValue, fieldText, fieldGroup) {

    var ddlObj = new ej.dropdowns.DropDownList({
        //set the local data to dataSource property
        dataSource: dataSource,
        fields: { value: fieldValue, text: fieldText, groupBy: fieldGroup },
        // set the placeholder to DropDownList input element
        placeholder: "Seleccione una opción",
        // enabled the ignoreAccent property for ignore the diacritics
        ignoreAccent: true,
        // set true for enable the filtering support.
        allowFiltering: true,
        filterBarPlaceholder: 'Registros que contengan...',
        //set the filterType to searching operation
        filterType: 'contains',
    });

    ddlObj.getIndexForValue = function(value, defaultValue) {
        var items = this.getItems();
        var index = defaultValue;
        for (var i = 0; i < items.length; i++) {
            if (items[i].dataset.value == value) {
                index = i;
                break;
            }
        }
        return index;
    };

    ddlObj.setIndexForValue = function(value, defaultValue) {
        var index = this.getIndexForValue(value, defaultValue);
        this.index  = index;
        return index;
    };

    ddlObj.getSelectedValue = function() {
        return this.value;
    }

    ddlObj.getSelectedText = function() {
        return this.text;
    }

    ddlObj.appendTo(`#${wrapperElementId}`);

    return ddlObj;
}

function createDefaultGridWithWrapper(wrapperElementId, dataSource, columnsObject = [], name = 'Archivo', separator = ';', pageSize = 40, groupSettings={}) {
    ej.grids.Grid.Inject(
        ej.grids.Resize, ej.grids.Sort, ej.grids.Group,
        ej.grids.Filter, ej.grids.Page, ej.grids.Toolbar,
        ej.grids.ExcelExport, ej.grids.Reorder, ej.grids.ColumnChooser
    );

    const gridElementId = `${wrapperElementId}-grid`;
    const toolbarElementId = `${wrapperElementId}-toolbar`;
    const wrapperElement = document.getElementById(wrapperElementId);

    if (!wrapperElement) {
        console.info(`No se encontró el elemento con ID: ${wrapperElementId}`);
        return;
    }
    wrapperElement.innerHTML = `<div id="${toolbarElementId}"></div><div id="${gridElementId}"></div>`;
    const defaultPageSizes = [10, 20, 50, 100, "All"];
    if (!defaultPageSizes.includes(pageSize) && typeof pageSize === 'number' && pageSize!=0) {
        defaultPageSizes.push(pageSize);
        defaultPageSizes.sort((a, b) => a - b); // Ordena los números en orden ascendente
    }
    if (pageSize==0) {
        pageSize    = dataSource.length;
    }

    let toolbarItems = [
        { text: 'Collapse', id: `${toolbarElementId}-colapseall`, align: 'Left', prefixIcon: "e-chevron-up icon" },
        { text: 'Expand', id: `${toolbarElementId}-expandall`, align: 'Left', prefixIcon: "e-chevron-down icon" },
        { type: 'Separator' }
    ];

    if (name!=null) {
        toolbarItems.push(
            { text: `${name}.xlsx`, id: `${toolbarElementId}-excel` },
            { text: `${name}.csv`, id: `${toolbarElementId}-csv` },
            { type: 'Separator' }
        );
    }

    toolbarItems.push(
        { text: 'Search', id: `${toolbarElementId}-search`, align: 'Right' },
        'ColumnChooser'
    );

    const grid = new ej.grids.Grid({
        dataSource: dataSource,
        columns: columnsObject,
        gridLines: 'Both',
        allowSorting: true,
        allowGrouping: true,
        groupSettings: groupSettings,
        allowFiltering: true,
        filterSettings: { type: 'CheckBox' },
        allowExcelExport: true,
        allowReordering: true,
        showColumnChooser: true,
        toolbar: toolbarItems,
        columnChooserSettings: {
            operator: 'contains',
            ignoreAccent: true
        },
        searchSettings: {
            operator: 'contains',
            ignoreCase: true,
            ignoreAccent: true
        },
        allowPaging: true,
        pageSettings: {
            pageSize: pageSize,
            pageSizes: defaultPageSizes
        },
        dataBound: function () {
            this.autoFitColumns();
        },
        actionComplete: function (args) {
            if (args.requestType === "columnstate") {
                this.autoFitColumns();
            }
        },
        created: () => {
            document.getElementById(grid.element.id + "_searchbar").addEventListener('keyup', () => {
                grid.search(event.target.value)
            });
        },
        toolbarClick: function (args) {
            clickHandler(args, grid, name, separator);
        }
    });

    grid.appendTo(`#${gridElementId}`);

    function clickHandler(args, grid, fileName, csvSeparator) {
        switch (args.item.id) {
            case toolbarElementId + '-colapseall':
                grid.groupModule.collapseAll();
                break;
            case toolbarElementId + '-expandall':
                grid.groupModule.expandAll();
                break;
            case toolbarElementId + '-excel':
                var excelExportProperties = {
                    fileName: fileName+'.xlsx'
                };
                grid.excelExport(excelExportProperties);
                break;
            case toolbarElementId + '-csv':
                var csvExportProperties = {
                    fileName: fileName+'.csv',
                    separator: csvSeparator
                };
                grid.csvExport(csvExportProperties);
                break;
            default:
                console.info(`default [${args.item.id}]; delegando`);
                grid.notify('toolbarClick', args);
                break;
        }
    }

    return grid;
}

function customNotificationSyncFusion(tipoMensaje, titulo, mensaje) {
    ej.base.enableRipple(true);
    var cssNotif = 'e-toast-info';
    switch(tipoMensaje) {
        case "OK":
            cssNotif='e-toast-success';
            break;
        case "ERROR":
            cssNotif= 'e-toast-danger';
            break;
        case "INFO":
            cssNotif= 'e-toast-info';
            break;
        case "WARNING":
            cssNotif= 'e-toast-warning';
            break;
        default:
            cssNotif= 'e-toast-info';
    }
    var toast = new ej.notifications.Toast({
        cssClass: cssNotif,
        title: titulo,
        content: mensaje,
        target: document.body,  //TODO: Revisar
        timeOut: 0,
        showCloseButton: true,
        position: { X: 'Right', Y: 'Bottom' },
        showProgressBar: true,
        timeOut: 15000,
        extendedTimeOut: 5000,
        animation: { show: { effect: "SlideRightIn" }, hide: { effect: "FadeOut" } },
        click: function(e) {
            abrirControlSidebar();
            toast.hide();
        }
    });

    toast.appendTo('#custom-notification');
    toast.show();
}



function booleanTemplateForColumnByValue(value) {
    return value
        ? '<i class="fa fa-check text-success"></i>'
        : '<i class="fa fa-times text-danger"></i>';
}

function generateDataSourcesClienteCuenta(listaClientes, listaCuentas) {
    // Construir DataSource de clientes
    var clientDataSource = [
        {
            ClientFieldValue: "",
            ClientText: "Todos los Clientes",
            ClientFieldGroup: "Todos"
        }
    ];

    listaClientes.forEach(obj => {
        clientDataSource.push({
            ClientFieldValue: obj.id,
            ClientText: obj.value,
            ClientFieldGroup: obj.grouper
        });
    });

    // Construir DataSource de cuentas
    var cuentaDataSource = [];

    listaClientes.forEach(obj => {
        cuentaDataSource.push({
            AccountFieldValue: "",
            AccountFieldText: `Todas (${obj.id})`,
            AccountFieldGroup: obj.id,
            ClientId: obj.id
        });
    });

    listaCuentas.forEach(obj => {
        cuentaDataSource.push({
            AccountFieldValue: obj.id,
            AccountFieldText: obj.value,
            AccountFieldGroup: obj.grouper,
            ClientId: obj.parent
        });
    });

    return { clientDataSource, cuentaDataSource };
}

function createComboBoxClienteCuenta(clientDataSource, cuentaDataSource, clienteDefault, cuentaDefault) {
    var clienteComboBox = createDefaultComboBox('cliente', clientDataSource, 'ClientFieldValue', 'ClientText', 'ClientFieldGroup');
    var cuentaComboBox = createDefaultComboBox('cuenta', cuentaDataSource, 'AccountFieldValue', 'AccountFieldText', 'AccountFieldGroup');

    cuentaComboBox.enabled = false;
    clienteComboBox.setIndexForValue(clienteDefault, 0);
    clienteComboBox.change = clienteComboBoxChange;

    function clienteComboBoxChange() {
        cuentaComboBox.clear();
        cuentaComboBox.query = new ej.data.Query().where('ClientId', 'equal', clienteComboBox.value);
        cuentaComboBox.enabled = true;
        cuentaComboBox.dataBind();
        cuentaComboBox.refresh();
        cuentaComboBox.index = 0;
        cuentaComboBox.setIndexForValue(cuentaDefault, 0);
    }

    // Guardamos referencias globales
    window.appPubGlobVar.clienteComboBox = clienteComboBox;
    window.appPubGlobVar.cuentaComboBox = cuentaComboBox;
    return { clienteComboBox, cuentaComboBox };
}

function createComboWithSourceClienteCuenta(listaClientes, listaCuentas, clienteDefault, cuentaDefault) {
    var dataSources     = generateDataSourcesClienteCuenta(listaClientes, listaCuentas);
    return createComboBoxClienteCuenta(dataSources.clientDataSource, dataSources.cuentaDataSource, clienteDefault, cuentaDefault);
}

function createDataSource(jsonString) {
    try {
        var lista = JSON.parse(jsonString);
        return lista.map(item => {
            var obj = {};
            Object.entries(item).forEach(([key, value]) => {
                obj[key] = value;
            });
            return obj;
        });
    } catch (error) {
        console.error("Error al parsear JSON:", error);
        return [];
    }
}

function updateColumnAttribute(columns, fieldName, attribute, value) {
    if (Array.isArray(fieldName)) {
        // Si es un array, iteramos y aplicamos la función a cada elemento
        fieldName.forEach(field => {
            updateColumnAttribute(columns, field, attribute, value);
        });
    } else {
        // Si es un solo campo, buscamos y actualizamos
        let column = columns.find(col => col.field === fieldName);
        if (column) {
            column[attribute] = value;
        }
    }
}


