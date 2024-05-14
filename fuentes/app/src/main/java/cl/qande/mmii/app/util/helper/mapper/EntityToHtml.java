package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.core.entity.ControlDiario;
import cl.qande.mmii.app.models.db.core.entity.ControlDiarioReporte;

import java.util.List;

public interface EntityToHtml {

    public static final String ABRE_TD = "<td>";
    public static final String CIERRA_TD = "</td>";

    public static String resultadoControlDiarioToHtml(List<ControlDiario> listaRegistros) {
        StringBuilder bld = new StringBuilder();
        if (listaRegistros.isEmpty()) {
            bld.append("<p>No hay registros</p>");
        } else {
            bld.append("<table><thead>"+resultadoControlDiarioEncabezadoToHtml()+"</thead><tbody>");
            for (var registro : listaRegistros) {
                bld.append("<tr>");
                bld.append(ABRE_TD+registro.getId()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getCorrelativoDiario()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getProcessDate()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getTimestampControl()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getTimestampRegistro()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getIdControl()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getGlosaControl()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getDescripcionControl()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getIdentificador()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getCantReg()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getUsername()+CIERRA_TD);
                bld.append("</tr>");
            }
            bld.append("</tbody></table>");
        }
        return bld.toString();
    }


    public static String resultadoControlDiarioSegmentadoToHtml(List<ControlDiarioReporte> listaRegistros) {
        StringBuilder bld = new StringBuilder();
        if (listaRegistros.isEmpty()) {
            bld.append("<p>No hay registros</p>");
        } else {
            bld.append("<table><thead>"+resultadoControlDiarioSegmentadoEncabezadoToHtml()+"</thead><tbody>");
            for (var registro : listaRegistros) {
                bld.append("<tr>");
                bld.append(ABRE_TD+registro.getIdReporte()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getProcessDate()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getTimestampControl()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getGlosaControl()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getDescripcionControl()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getIdentificador()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getCantReg()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getVariante()+CIERRA_TD);
                bld.append("</tr>");
            }
            bld.append("</tbody></table>");
        }
        return bld.toString();
    }
    private static String resultadoControlDiarioSegmentadoEncabezadoToHtml() {
        StringBuilder bld = new StringBuilder();
        bld.append("<tr>");
        bld.append("<th>Id</th>");
        bld.append("<th>Process Date</th>");
        bld.append("<th>Timestamp Control</th>");
        bld.append("<th>Glosa Control</th>");
        bld.append("<th>Descripcion Control</th>");
        bld.append("<th>Identificador</th>");
        bld.append("<th>Cant. Reg</th>");
        bld.append("<th>Segmento</th>");
        bld.append("</tr>");
        return bld.toString();
    }
    private static String resultadoControlDiarioEncabezadoToHtml() {
        StringBuilder bld = new StringBuilder();
        bld.append("<tr>");
        bld.append("<th>Id</th>");
        bld.append("<th>Correlativo Diario</th>");
        bld.append("<th>Process Date</th>");
        bld.append("<th>Timestamp Control</th>");
        bld.append("<th>Timestamp Registro</th>");
        bld.append("<th>Id Control</th>");
        bld.append("<th>Glosa Control</th>");
        bld.append("<th>Descripcion Control</th>");
        bld.append("<th>Identificador</th>");
        bld.append("<th>Cant. Reg</th>");
        bld.append("<th>Username</th>");
        bld.append("</tr>");
        return bld.toString();
    }

    public static String resultadoFtpSuraChileToHtml(List<String> archivosConError) {
        if (archivosConError == null) {
            return "<p>Error en la carga de archivos</p>";
        }
        StringBuilder bld = new StringBuilder();
        if (archivosConError.isEmpty()) {
            bld.append("<p>Sin errores en la carga. Todos los archivos fueron subidos.</p>");
        } else {
            bld.append("<p>Los siguientes archivos no fueron cargados</p>");
            bld.append("<table><thead>"+resultadoFtpSuraChileEncabezadoToHtml()+"</thead><tbody>");
            for (var registro : archivosConError) {
                bld.append("<tr><td>"+registro+"</td></tr>");
            }
            bld.append("</tbody></table>");
        }
        return bld.toString();
    }
    private static String resultadoFtpSuraChileEncabezadoToHtml() {
        String htmlTable    = "";
        htmlTable   = htmlTable+"<tr>";
        htmlTable   = htmlTable+"<th>Archivo</th>";
        htmlTable   = htmlTable+"</tr>";
        return htmlTable;
    }
}
