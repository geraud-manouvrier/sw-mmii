window.appPubGlobVar = window.appPubGlobVar || {};

function postByRangeProcessDate(idRangeCalendar, idForm, formatoHtml='YYYYMMDD') {
    const dataCal             = $('#' + idRangeCalendar).data('daterangepicker');
    const startProcessDate    = dataCal.startDate.format(formatoHtml);
    const endProcessDate      = dataCal.endDate.format(formatoHtml);

    $("#fecha_desde").val( startProcessDate );
    $("#fecha_hasta").val( endProcessDate );
    const myForm  = document.getElementById(idForm);
    myForm.submit();
}

function formatProcessDate(processDate, formato='YYYYMMDD', separador='-') {
    switch (formato) {
        case 'YYYYMMDD':
            return processDate.substr(0,4) + separador + processDate.substr(4,2) + separador + processDate.substr(6,2);
        case 'DDMMYYYY':
            return processDate.substr(6,2) + separador + processDate.substr(4,2) + separador + processDate.substr(0,4);
        case 'MMDDYYYY':
            return processDate.substr(4,2) + separador + processDate.substr(6,2) + separador + processDate.substr(0,4);
        default:
            return processDate;
    }

}