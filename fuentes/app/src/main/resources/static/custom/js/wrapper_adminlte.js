//@Deprecated
function createCustomCalendarHtml(calendarName, customRanges, multiple=false, minDate=null, maxDate=null) {
    //https://www.daterangepicker.com/#google_vignette
    var idCalendar  = '#'+calendarName;
    var separator   = multiple ? " -> " : " - ";
    var dateOfStart         = moment('2024-04-29', 'YYYY-MM-DD');

    if (minDate == null || moment(minDate).isBefore(dateOfStart)) {
        minDate = dateOfStart;
    }
    if (maxDate==null)
        maxDate=moment().subtract(1, 'days');

    return $(idCalendar).daterangepicker(
        {
            "singleDatePicker": (!multiple),
            "showDropdowns": true,
            "autoApply": true,
            "alwaysShowCalendars" : true,
            "showCustomRangeLabel" : false,
            ranges: customRanges,
            "minDate": minDate,
            "maxDate": maxDate,
            "locale": {
                "format": "YYYY-MM-DD",
                "separator": separator,
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

function createCustomCalendarSingleHtml(calendarName, customRanges, multiple=false, minDate=null, maxDate=null) {
    //https://www.daterangepicker.com/#google_vignette
    var idCalendar  = '#'+calendarName;
    var separator   = multiple ? " -> " : " - ";
    var dateOfStart         = moment('2024-04-29', 'YYYY-MM-DD');
    if (customRanges==null) {
        customRanges = {
            '1 mes': [moment().startOf('month').subtract(1, 'month'), moment().startOf('month').subtract(1, 'month')],
            '3 meses': [moment().startOf('month').subtract(3, 'months'), moment().startOf('month').subtract(3, 'months')],
            '6 meses': [moment().startOf('month').subtract(6, 'months'), moment().startOf('month').subtract(6, 'months')],
            '12 meses': [moment().startOf('month').subtract(12, 'months'), moment().startOf('month').subtract(12, 'months')],
            'YTD': [moment().startOf('year'), moment().startOf('year')]
        };
    }
    return $(idCalendar).daterangepicker(
        {
            "singleDatePicker": true,
            "showDropdowns": true,
            "autoApply": true,
            "alwaysShowCalendars" : true,
            "showCustomRangeLabel" : false,
            "minDate": dateOfStart,
            maxDate: moment().subtract(1, 'days'),
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

function createCustomCalendarRangeHtml(calendarName, customRanges) {
    var idCalendar         = '#'+calendarName;
    var dateOfStart         = moment('2024-04-29', 'YYYY-MM-DD');
    if (customRanges==null) {
        customRanges= getRangesRentabilidades();
    }
    return $(idCalendar).daterangepicker(
        {
            "autoApply": true,
            "alwaysShowCalendars" : true,
            "showCustomRangeLabel" : false,
            "minDate": dateOfStart,
            maxDate: moment().subtract(1, 'days'),
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



function abrirControlSidebar() {
    $('[data-widget="control-sidebar"]').trigger('click');
}

function getRangesMaestros() {
    var ranges= {
        'Ayer': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
        'Últ. 3 días': [moment().subtract(3, 'days'), moment().subtract(1, 'days')],
        'Últ. 3 días': [moment().subtract(3, 'days'), moment().subtract(1, 'days')],
        'Últ. 7 días': [moment().subtract(7, 'days'), moment().subtract(1, 'days')],
        'Últ. 10 días': [moment().subtract(10, 'days'), moment().subtract(1, 'days')],
        'Mes Actual': [moment().startOf('month'), moment().subtract(1, 'days')],
        'Mes Anterior': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
    };
    return ranges;
}

function getSingleRangesMaestros() {
    var ranges= {
        'Ayer': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
        'Atrás 3 días': [moment().subtract(3, 'days'), moment().subtract(3, 'days')],
        'Atrás 7 días': [moment().subtract(7, 'days'), moment().subtract(7, 'days')],
        'Atrás 10 días': [moment().subtract(10, 'days'), moment().subtract(10, 'days')],
        'Cierre Anterior': [moment().subtract(1, 'month').endOf('month'), moment().subtract(1, 'month').endOf('month')]
    };
    return ranges;
}

function getRangesRentabilidades() {
    var ranges= {
        'Inicio Operaciones': [moment('2024-04-29'), moment().subtract(1, 'days')],
        '1 mes': [moment().subtract(1, 'days').subtract(1, 'month'), moment().subtract(1, 'days')],
        '3 meses': [moment().subtract(1, 'days').subtract(3, 'months'), moment().subtract(1, 'days')],
        '12 meses': [moment().subtract(1, 'days').subtract(12, 'months'), moment().subtract(1, 'days')],
        '20 meses': [moment().subtract(1, 'days').subtract(20, 'months'), moment().subtract(1, 'days')],
        'YTD': [moment().subtract(1, 'days').startOf('year'), moment().subtract(1, 'days')]
    };
    return ranges;
}