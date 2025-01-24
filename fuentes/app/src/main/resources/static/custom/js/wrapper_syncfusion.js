
function createDefaultGridWithWrapper(wrapperElementId, dataSource, columnsObject = [], name = 'Archivo', separator = ';', pageSize = 40) {
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

    const grid = new ej.grids.Grid({
        dataSource: dataSource,
        columns: columnsObject,
        gridLines: 'Both',
        allowSorting: true,
        allowGrouping: true,
        allowFiltering: true,
        filterSettings: { type: 'CheckBox' },
        allowExcelExport: true,
        allowReordering: true,
        showColumnChooser: true,
        toolbar: [
            { text: 'Collapse', id: `${toolbarElementId}-colapseall`, align: 'Left', prefixIcon: "e-chevron-up icon" },
            { text: 'Expand', id: `${toolbarElementId}-expandall`, align: 'Left', prefixIcon: "e-chevron-down icon" },
            { type: 'Separator' },
            { text: `${name}.xlsx`, id: `${toolbarElementId}-excel` },
            { text: `${name}.csv`, id: `${toolbarElementId}-csv` },
            { type: 'Separator' },
            { text: 'Search', id: `${toolbarElementId}-search`, align: 'Right' },
            'ColumnChooser'
        ],
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


