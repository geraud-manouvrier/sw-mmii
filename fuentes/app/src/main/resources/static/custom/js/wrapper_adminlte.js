
function createCustomSingleCalendarHtml(calendarName, customRanges) {
    var idCalendar         = '#'+calendarName;
    return $(idCalendar).daterangepicker(
        {
            "singleDatePicker": true,
            "showDropdowns": true,
            "autoApply": true,
            "alwaysShowCalendars" : true,
            "showCustomRangeLabel" : false,
            ranges: customRanges,
            "locale": {
                "format": "YYYY-MM-DD",
                "separator": " - ",
                "applyLabel": "Aceptar",
                "cancelLabel": "Cancelar",
                "fromLabel": "From",
                "toLabel": "To",
                "customRangeLabel": "Custom",
                "weekLabel": "W",
                "daysOfWeek": [
                    "Do",
                    "Lu",
                    "Ma",
                    "Mi",
                    "Ju",
                    "Vi",
                    "Sa"
                ],
                "monthNames": [
                    "Enero",
                    "Febrero",
                    "Marzo",
                    "Abril",
                    "Mayo",
                    "Junio",
                    "Julio",
                    "Agosto",
                    "Septiembre",
                    "Octubre",
                    "Noviembre",
                    "Diciembre"
                ],
                "firstDay": 1
            }
        }
    );
}
function createCustomCalendarHtml(calendarName, customRanges) {
    var idCalendar         = '#'+calendarName;
    return $(idCalendar).daterangepicker(
        {
            maxDate: moment().subtract(1, 'days'),
            "autoApply": true,
            "alwaysShowCalendars" : true,
            "showCustomRangeLabel" : false,
            ranges: customRanges,
            "locale": {
                "format": "YYYY-MM-DD",
                "separator": " -> ",
                "applyLabel": "Aceptar",
                "cancelLabel": "Cancelar",
                "fromLabel": "From",
                "toLabel": "To",
                "customRangeLabel": "Custom",
                "weekLabel": "W",
                "daysOfWeek": [
                    "Do",
                    "Lu",
                    "Ma",
                    "Mi",
                    "Ju",
                    "Vi",
                    "Sa"
                ],
                "monthNames": [
                    "Enero",
                    "Febrero",
                    "Marzo",
                    "Abril",
                    "Mayo",
                    "Junio",
                    "Julio",
                    "Agosto",
                    "Septiembre",
                    "Octubre",
                    "Noviembre",
                    "Diciembre"
                ],
                "firstDay": 1
            }
        }
    );
}


function customNotification(tipoMensaje, titulo, mensaje) {
    //https://codeseven.github.io/toastr/demo.html
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "newestOnTop": false,
        "progressBar": true,
        "positionClass": "toast-bottom-right",
        "preventDuplicates": false,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "15000",
        "extendedTimeOut": "5000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };
    switch(tipoMensaje) {
        case "OK":
            toastr.success(mensaje, titulo, {
                onclick: function() {
                    abrirControlSidebar();
                }
            });
            break;
        case "ERROR":
            toastr.error(mensaje, titulo, {
                onclick: function() {
                    abrirControlSidebar();
                }
            });
            break;
        case "INFO":
            toastr.info(mensaje, titulo, {
                onclick: function() {
                    abrirControlSidebar();
                }
            });
            break;
        case "WARNING":
            toastr.warning(mensaje, titulo, {
                onclick: function() {
                    abrirControlSidebar();
                }
            });
            break;
        default:
            toastr.info(mensaje, titulo, {
                onclick: function() {
                    abrirControlSidebar();
                }
            });
    }
}

function abrirControlSidebar() {
    $('[data-widget="control-sidebar"]').trigger('click');
}