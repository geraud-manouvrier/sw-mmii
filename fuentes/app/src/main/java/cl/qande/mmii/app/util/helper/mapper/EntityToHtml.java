package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.db.core.entity.ControlDiario;
import cl.qande.mmii.app.models.db.core.entity.ControlDiarioReporte;
import cl.qande.mmii.app.models.db.core.entity.VwCuentasNoMapeadasPershingProjection;

import java.util.List;

public interface EntityToHtml {

    public static final String ABRE_TD = "<td>";
    public static final String CIERRA_TD = "</td>";
    String TH_PROCESS_DATE = "<th>Process Date</th>";
    String CIERRA_TR = "</tr>";
    String MSG_NO_REGISTROS = "<p>No hay registros</p>";
    String ABRE_TABLE = "<table><thead>";
    String CIERRA_TABLE = "</tbody></table>";
    String THEAD_TBODY = "</thead><tbody>";
    String ABRE_TR = "<tr>";

    public static String resultadoCuentaNoMapeadasToHtml(List<VwCuentasNoMapeadasPershingProjection> listaRegistros) {
        if (listaRegistros==null) {
            return "";
        }
        StringBuilder bld = new StringBuilder();
        if (listaRegistros.isEmpty()) {
            bld.append(MSG_NO_REGISTROS);
        } else {
            bld.append(ABRE_TABLE +resultadoCuentaNoMapeadasEncabezadoToHtml()+ THEAD_TBODY);
            for (var registro : listaRegistros) {
                bld.append(ABRE_TR);
                bld.append(ABRE_TD+registro.getProcessDate()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getAccountNo()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getClientName()+CIERRA_TD);
                bld.append(CIERRA_TR);
            }
            bld.append(CIERRA_TABLE);
        }
        return bld.toString();
    }

    public static String resultadoControlDiarioToHtml(List<ControlDiario> listaRegistros) {
        StringBuilder bld = new StringBuilder();
        if (listaRegistros.isEmpty()) {
            bld.append(MSG_NO_REGISTROS);
        } else {
            bld.append(ABRE_TABLE +resultadoControlDiarioEncabezadoToHtml()+ THEAD_TBODY);
            for (var registro : listaRegistros) {
                bld.append(ABRE_TR);
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
                bld.append(CIERRA_TR);
            }
            bld.append(CIERRA_TABLE);
        }
        return bld.toString();
    }


    public static String resultadoControlDiarioSegmentadoToHtml(List<ControlDiarioReporte> listaRegistros) {
        StringBuilder bld = new StringBuilder();
        if (listaRegistros.isEmpty()) {
            bld.append(MSG_NO_REGISTROS);
        } else {
            bld.append(ABRE_TABLE +resultadoControlDiarioSegmentadoEncabezadoToHtml()+ THEAD_TBODY);
            for (var registro : listaRegistros) {
                bld.append(ABRE_TR);
                bld.append(ABRE_TD+registro.getIdReporte()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getProcessDate()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getTimestampControl()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getGlosaControl()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getDescripcionControl()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getIdentificador()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getCantReg()+CIERRA_TD);
                bld.append(ABRE_TD+registro.getVariante()+CIERRA_TD);
                bld.append(CIERRA_TR);
            }
            bld.append(CIERRA_TABLE);
        }
        return bld.toString();
    }
    private static String resultadoControlDiarioSegmentadoEncabezadoToHtml() {
        StringBuilder bld = new StringBuilder();
        bld.append(ABRE_TR);
        bld.append("<th>Id</th>");
        bld.append(TH_PROCESS_DATE);
        bld.append("<th>Timestamp Control</th>");
        bld.append("<th>Glosa Control</th>");
        bld.append("<th>Descripcion Control</th>");
        bld.append("<th>Identificador</th>");
        bld.append("<th>Cant. Reg</th>");
        bld.append("<th>Segmento</th>");
        bld.append(CIERRA_TR);
        return bld.toString();
    }
    private static String resultadoCuentaNoMapeadasEncabezadoToHtml() {
        StringBuilder bld = new StringBuilder();
        bld.append(ABRE_TR);
        bld.append(TH_PROCESS_DATE);
        bld.append("<th>Account Number</th>");
        bld.append("<th>Client Name</th>");
        bld.append(CIERRA_TR);
        return bld.toString();
    }
    private static String resultadoControlDiarioEncabezadoToHtml() {
        StringBuilder bld = new StringBuilder();
        bld.append(ABRE_TR);
        bld.append("<th>Id</th>");
        bld.append("<th>Correlativo Diario</th>");
        bld.append(TH_PROCESS_DATE);
        bld.append("<th>Timestamp Control</th>");
        bld.append("<th>Timestamp Registro</th>");
        bld.append("<th>Id Control</th>");
        bld.append("<th>Glosa Control</th>");
        bld.append("<th>Descripcion Control</th>");
        bld.append("<th>Identificador</th>");
        bld.append("<th>Cant. Reg</th>");
        bld.append("<th>Username</th>");
        bld.append(CIERRA_TR);
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
            bld.append(ABRE_TABLE +resultadoFtpSuraChileEncabezadoToHtml()+ THEAD_TBODY);
            for (var registro : archivosConError) {
                bld.append("<tr><td>"+registro+"</td></tr>");
            }
            bld.append(CIERRA_TABLE);
        }
        return bld.toString();
    }
    private static String resultadoFtpSuraChileEncabezadoToHtml() {
        String htmlTable    = "";
        htmlTable   = htmlTable+ ABRE_TR;
        htmlTable   = htmlTable+"<th>Archivo</th>";
        htmlTable   = htmlTable+ CIERRA_TR;
        return htmlTable;
    }
}
