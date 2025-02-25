window.appPubGlobVar = window.appPubGlobVar || {};

function postByRangeProcessDate(idRangeCalendar, idForm, formatoHtml='YYYYMMDD') {
    //var formatoHtml = 'YYYYMMDD';
    var dataCal             = $('#' + idRangeCalendar).data('daterangepicker');
    var startProcessDate    = dataCal.startDate.format(formatoHtml);
    var endProcessDate      = dataCal.endDate.format(formatoHtml);

    $("#fecha_desde").val( startProcessDate );
    $("#fecha_hasta").val( endProcessDate );
    var myForm  = document.getElementById(idForm);
    myForm.submit();
}