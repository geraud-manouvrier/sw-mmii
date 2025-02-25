package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ParSourceCode;
import cl.qande.mmii.app.models.db.core.entity.ControlDiario;
import cl.qande.mmii.app.models.db.core.entity.VwCuentasNoMapeadasPershingProjection;
import cl.qande.mmii.app.models.db.rep_inv.entity.ResultadoControl;

import java.util.List;

public interface EntityToHtml {

    public static final String ABRE_TD = "<td style=\"border: 1px solid #ddd; padding: 8px;\">";
    public static final String CIERRA_TD = "</td>";
    String TH_PROCESS_DATE = "<th>Process Date</th>";
    String CIERRA_TR = "</tr>";
    public static final String NO_REG_HTML = "<p>No hay registros</p>";
    String ABRE_TABLE = "<table><thead>";
    public static final String TABLE_END = "</tbody></table>";
    public static final String TABLE_BODY_BEGIN = "</thead><tbody>";
    String ABRE_TR = "<tr>";


    public static final String TABLE_BEGIN = "<table style=\"border-collapse: collapse; width: 100%; font-family: Arial, sans-serif; font-size: 11px;\"><thead>";

    public static final String ABRE_TR_HEAD = "<tr style=\"background-color: #4a90e2; color: white; font-weight: bold;\">";
    public static final String ABRE_TR_FILA_PAR = "<tr style=\"background-color: #ffffff;\">";
    public static final String ABRE_TR_FILA_IMPAR = "<tr style=\"background-color: #f2f2f2;\">";
    public static final String SALTO_CIERRE_HTML = "<br><br><b>";
    String BR_DETALLE_REGISTROS_BR = "<br>Detalle registros:<br>";

    public static String resultadoParametrosSuracorpToHtml(ParSourceCode[][] listaRegistros, String msg) {
        StringBuilder bld = new StringBuilder();
        if (listaRegistros==null || listaRegistros.length==0 ) {
            bld.append("<p>No hay registros de ningún tipo (ok o error)</p>");
        } else {
            bld.append(resultadoParametrosSuracorpEncabezadoToHtml(listaRegistros[1], "con errores"));
            bld.append(resultadoParametrosSuracorpEncabezadoToHtml(listaRegistros[0], "OK"));
        }
        if ( ! msg.isEmpty()) {
            bld.append(SALTO_CIERRE_HTML).append(msg).append("</b>");
        }
        return bld.toString();
    }

    public static String resultadoParametrosSuracorpEncabezadoToHtml(ParSourceCode[] lista, String msgTipo) {
        StringBuilder bld = new StringBuilder();
        if (lista==null || lista.length==0) {
            bld.append("<p>No hay Registros ").append(msgTipo).append("</p>");
        } else {
            bld.append(BR_DETALLE_REGISTROS_BR + TABLE_BEGIN).append(generaEncabezadoHtml("Source Code Pershing", "Signo Movto.", "Descr. Movto.", "Aplica Flujo Neto", "Obs. Int.")).append(TABLE_BODY_BEGIN);
            int rowIndex = 0;
            for (var registro : lista) {
                bld.append((rowIndex++ % 2 == 0) ? ABRE_TR_FILA_PAR : ABRE_TR_FILA_IMPAR)
                    .append(ABRE_TR)
                    .append(ABRE_TD).append(registro.getSourceCodePershing()).append(CIERRA_TD)
                    .append(ABRE_TD).append(registro.getSignoMovimiento()).append(CIERRA_TD)
                    .append(ABRE_TD).append(registro.getDescripcionMovimiento()).append(CIERRA_TD)
                    .append(ABRE_TD).append(registro.getAplicaFlujoNeto()).append(CIERRA_TD)
                    .append(ABRE_TD).append(registro.getObservacionesInternas()).append(CIERRA_TD)
                    .append(CIERRA_TR);
            }
            bld.append(TABLE_END);
        }
        return bld.toString();
    }

    public static String resultadoCuentaNoMapeadasToHtml(List<VwCuentasNoMapeadasPershingProjection> listaRegistros) {
        StringBuilder bld = new StringBuilder();
        if (listaRegistros==null || listaRegistros.isEmpty()) {
            bld.append(NO_REG_HTML);
        } else {
            bld.append(BR_DETALLE_REGISTROS_BR + TABLE_BEGIN).append(generaEncabezadoHtml("Process Date", "Account Number", "Client Name")).append(TABLE_BODY_BEGIN);
            int rowIndex = 0;
            for (var registro : listaRegistros) {
                bld.append((rowIndex++ % 2 == 0) ? ABRE_TR_FILA_PAR : ABRE_TR_FILA_IMPAR)
                    .append(ABRE_TD).append(registro.getProcessDate()).append(CIERRA_TD)
                    .append(ABRE_TD).append(registro.getAccountNo()).append(CIERRA_TD)
                    .append(ABRE_TD).append(registro.getClientName()).append(CIERRA_TD)
                    .append(CIERRA_TR);
            }
            bld.append(TABLE_END);
        }
        return bld.toString();
    }


    public static String resultadoControlDiarioToHtml(List<ControlDiario> listaRegistros, String msg) {
        StringBuilder bld = new StringBuilder();
        if (listaRegistros==null || listaRegistros.isEmpty()) {
            bld.append(NO_REG_HTML);
        } else {
            bld.append(BR_DETALLE_REGISTROS_BR + TABLE_BEGIN).append(generaEncabezadoHtml("Id Control", "Process Date", "Timestamp Control", "Glosa Control", "Descripcion Control", "Identificador", "Cant. Reg")).append(TABLE_BODY_BEGIN);
            int rowIndex = 0;
            for (var registro : listaRegistros) {
                bld.append((rowIndex++ % 2 == 0) ? ABRE_TR_FILA_PAR : ABRE_TR_FILA_IMPAR)
                        .append(ABRE_TD).append(registro.getIdControl()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getProcessDate()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getTimestampControl()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getGlosaControl()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getDescripcionControl()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getIdentificador()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getCantReg()).append(CIERRA_TD)
                        .append(CIERRA_TR);
            }
            bld.append(TABLE_END);
        }
        if ( ! msg.isEmpty()) {
            bld.append(SALTO_CIERRE_HTML)
                    .append(msg)
                    .append("</b>");
        }
        return bld.toString();
    }

    public static String resultadoControlRepInvToHtml(List<ResultadoControl> listaRegistros, String msg) {
        StringBuilder bld = new StringBuilder();
        if (listaRegistros==null || listaRegistros.isEmpty()) {
            bld.append(NO_REG_HTML);
        } else {
            bld.append(TABLE_BEGIN).append(generaEncabezadoHtml("Id", "Id Control", "Glosa Control", "Descripcion Control", "Process Date", "Identificador", "Cant. Reg")).append(TABLE_BODY_BEGIN);
            int rowIndex = 0;
            for (var registro : listaRegistros) {
                bld.append((rowIndex++ % 2 == 0) ? ABRE_TR_FILA_PAR : ABRE_TR_FILA_IMPAR)
                        .append(ABRE_TD).append(registro.getId()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getIdControl()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getGlosaControl()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getDescripcionControl()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getProcessDate()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getIdentificador()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getCantReg()).append(CIERRA_TD)
                        .append(CIERRA_TR);
            }
            bld.append(TABLE_END);
        }
        if ( ! msg.isEmpty()) {
            bld.append(SALTO_CIERRE_HTML +msg+"</b>");
        }
        return bld.toString();
    }


    private static String generaEncabezadoHtml(String... headers) {
        StringBuilder bld = new StringBuilder();
        bld.append(ABRE_TR_HEAD);
        for (String header : headers) {
            bld.append("<th>").append(header).append("</th>");
        }
        bld.append(CIERRA_TR);
        return bld.toString();
    }


}
