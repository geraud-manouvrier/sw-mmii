
function createCustomCalendarHtml(calendarName, customRanges, multiple=false, minDate=null, maxDate=null) {
    //https://www.daterangepicker.com/#google_vignette
    var idCalendar  = '#'+calendarName;
    var separator   = multiple ? " -> " : " - ";
    var dateOfStart         = moment('2024-04-22', 'YYYY-MM-DD');

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



function abrirControlSidebar() {
    $('[data-widget="control-sidebar"]').trigger('click');
}