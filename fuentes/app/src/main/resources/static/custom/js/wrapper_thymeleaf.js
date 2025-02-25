
function createDefaultColumns(classFields, formatHeader = false) {
    return classFields.map(field => ({
        field: field,
        headerText: formatHeader ? formatHeaderText(field) : field, // Formatea solo si es true
        visible: true
    }));
}


function formatHeaderText(field) {
    // Convierte nombres tipo 'nombreSubSubTipoActivo' en 'Nombre Sub Sub Tipo Activo'
    return field
        .replace(/([a-z])([A-Z])/g, '$1 $2') // Separa palabras en mayúsculas
        .replace(/_/g, ' ') // Reemplaza _ por espacios (si los hay)
        .replace(/\b\w/g, char => char.toUpperCase()); // Primera letra de cada palabra en mayúscula
}