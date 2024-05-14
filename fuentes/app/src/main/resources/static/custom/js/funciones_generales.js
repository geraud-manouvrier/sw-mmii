
function customNotification(tipoMensaje, titulo, mensaje) {
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "newestOnTop": false,
        "progressBar": true,
        "positionClass": "toast-bottom-right",
        "preventDuplicates": false,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "3500",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };
    switch(tipoMensaje) {
        case "OK":
            toastr.success(mensaje, titulo);
            break;
        case "ERROR":
            toastr.error(mensaje, titulo);
            break;
        case "INFO":
            toastr.info(mensaje, titulo);
            break;
        case "WARNING":
            toastr.warning(mensaje, titulo);
            break;
        default:
            toastr.info(mensaje, titulo);
    }
}