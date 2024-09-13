
function createDefaultGridWithWrapper(wrapperElementId, dataSource, columnsObject, name, separator) {
    ej.grids.Grid.Inject(
        ej.grids.Resize, ej.grids.Sort, ej.grids.Group,
        ej.grids.Filter, ej.grids.Page, ej.grids.Toolbar,
        ej.grids.ExcelExport, ej.grids.Reorder, ej.grids.ColumnChooser
    );

    var gridElementId       = wrapperElementId+'-grid';
    var toolbarElementId    = wrapperElementId+'-toolbar';
    var wrapperElement      = document.getElementById(wrapperElementId);

    if (!wrapperElement) {
        return;
    }
    wrapperElement.innerHTML = `<div id="${toolbarElementId}"></div><div id="${gridElementId}"></div>`;

    var baseFileName    = (name==null) ? 'Archivo' : name;
    var csvSeparator    = separator==null ? ';' : separator;
    var grid = new ej.grids.Grid({
        dataSource: dataSource,
        gridLines: 'Both',
        allowSorting: true,
        allowGrouping: true,
        allowFiltering: true,
        filterSettings: { type:'CheckBox' },
        allowExcelExport: true,
        allowReordering: true,
        showColumnChooser: true,
        toolbar: [
            { text: 'Collapse', id: toolbarElementId+'-colapseall', align: 'Left', prefixIcon: "e-chevron-up icon"},
            { text: 'Expand', id: toolbarElementId+'-expandall', align: 'Left', prefixIcon: "e-chevron-down icon"},
            { type: 'Separator'},
            { text: baseFileName+'.xlsx', id: toolbarElementId+'-excel'},
            { text: baseFileName+'.csv', id: toolbarElementId+'-csv'},
            { type: 'Separator'},
            { text: 'Search', id: toolbarElementId+'-search', align: 'Right'},
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
            pageSize: 50,
            pageSizes: [10, 20, 50]
        },
        dataBound: function(){
            this.autoFitColumns();
        },
        created: () => {
            document.getElementById(grid.element.id + "_searchbar").addEventListener('keyup', () => {
                grid.search(event.target.value)
            });
        }
    });
    if (columnsObject!=null) {
        grid.columns = columnsObject;
    }

    grid.appendTo(`#${gridElementId}`);

    function clickHandler(args, fileName, csvSeparator) {
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
                console.info("default ["+args.item.id+"]");
                break;
        }
    }
    grid.toolbarClick = function(args) {
        clickHandler(args, baseFileName, csvSeparator);
    };

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


