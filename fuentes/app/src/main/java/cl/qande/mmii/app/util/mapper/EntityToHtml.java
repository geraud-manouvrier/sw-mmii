package cl.qande.mmii.app.util.mapper;

import cl.qande.mmii.app.models.api_clients.mmii_suracorp.AccountFeeValidated;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.FeeControlResponse;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ParSourceCode;
import cl.qande.mmii.app.models.db.core.entity.ControlDiario;
import cl.qande.mmii.app.models.db.core.entity.VwCuentasNoMapeadasPershingProjection;
import cl.qande.mmii.app.models.db.core.entity.VwReporteDiferenciasFee;
import cl.qande.mmii.app.models.db.rep_inv.entity.ResultadoControl;
import cl.qande.mmii.app.util.helper.CustomThymeleafHelper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public static String resultadoJobToHtml(List<VwReporteDiferenciasFee> listaRegistros, String msg) {
        StringBuilder bld = new StringBuilder();
        if (listaRegistros==null || listaRegistros.isEmpty()) {
            bld.append(NO_REG_HTML);
        } else {
            bld.append(TABLE_BEGIN).append(generaEncabezadoHtml("Client Id", "Nombre Cliente", "Cuenta", "Fee Segmento", "Fee Asignado", "Ingreso/Egreso Efectivo")).append(TABLE_BODY_BEGIN);
            int rowIndex = 0;
            for (var registro : listaRegistros) {
                bld.append((rowIndex++ % 2 == 0) ? ABRE_TR_FILA_PAR : ABRE_TR_FILA_IMPAR)
                        .append(ABRE_TD).append(registro.getClientId()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getNombre()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getAccountNo()).append(CIERRA_TD)
                        .append(ABRE_TD).append(CustomThymeleafHelper.formatNumber(registro.getFeeSeg(), 4, null)).append(CIERRA_TD)
                        .append(ABRE_TD).append(CustomThymeleafHelper.formatNumber(registro.getFeeCte(), 4, null)).append(CIERRA_TD)
                        .append(ABRE_TD).append(CustomThymeleafHelper.formatNumber(registro.getIngresoEgresoEfectivo(), 4, null)).append(CIERRA_TD)
                        .append(CIERRA_TR);
            }
            bld.append(TABLE_END);
        }
        if ( ! msg.isEmpty()) {
            bld.append(SALTO_CIERRE_HTML +msg+"</b>");
        }
        return bld.toString();
    }

    public static List<AccountFeeValidated> ordenaResultadoJobToHtml(List<AccountFeeValidated> desordenados) {
        return desordenados.stream()
                .sorted(
                    Comparator
                        .comparing( (AccountFeeValidated r) -> r.getStatus() == null ? "" : r.getStatus() )
                        .thenComparingInt( r -> r.getFeeContract().compareTo(r.getFee()) )
                        .thenComparing(AccountFeeValidated::getFee)
                        .thenComparing(AccountFeeValidated::getFeeContract)
                        .thenComparing(AccountFeeValidated::getAccountNumber)
                )
                .collect(Collectors.toList());
    }

    private static int getGroup(AccountFeeValidated accountFeeValidated) {
        if (accountFeeValidated.getStatus() == null || accountFeeValidated.getStatus().isEmpty()) {
            return 0; // grupo 0: sin estado
        }
        var comparacion = accountFeeValidated.getFeeContract().compareTo(accountFeeValidated.getFee());
        if (comparacion==0)
            return 1; // grupo 1: fees iguales
        if (comparacion<0)
            return 2; // grupo 2: fee contrato < fee
        return 3; // grupo 3: fee contrato > fee
    }

    public static String resultadoJobToHtml(FeeControlResponse listaRegistros, String msg) {
        StringBuilder bld = new StringBuilder();
        int omitidos    = 0;
        if (listaRegistros==null || listaRegistros.getAccountsFeesValidated().isEmpty()) {
            bld.append(NO_REG_HTML);
        } else {
            bld.append(TABLE_BEGIN).append(generaEncabezadoHtml("Account N°", "Nombre Cliente", "Observaciones Control", "Fee (SW)", "Fee Contrato (RIA)", "Saldo Valorizado")).append(TABLE_BODY_BEGIN);
            int rowIndex = 0;
            var ordenados = ordenaResultadoJobToHtml(listaRegistros.getAccountsFeesValidated());

            String[] groupColors = {
                    "#F9F2FC",   //Púrpura
                    "#FFFFFF",  //Gris
                    "#F0FBF9",  //Verde Azulado
                    "#F0F4FB"  //Azul
            };
            String[] groupColorsPar = {
                    "#EEDCF9",   //Púrpura
                    "#F2F2F2",  //Gris
                    "#D9F4EF",  //Verde Azulado
                    "#D9E4F9"  //Azul
            };

            for (var registro : ordenados) {
                int group = getGroup(registro);
                String status = registro.getStatus() == null ? "" : registro.getStatus();
                if (status.isEmpty()) {
                    omitidos++;
                    continue;
                }
                // calculamos el color de fila: blanco para pares, color de grupo para impares
                String rowColor;
                if (rowIndex++ % 2 == 0) {
                    rowColor = groupColorsPar[group];
                } else {
                    rowColor = groupColors[group];
                }
                bld.append("<tr style=\"background-color:").append(rowColor).append(";\">")
                        .append(ABRE_TD).append(registro.getAccountNumber()).append(CIERRA_TD)
                        .append(ABRE_TD).append(registro.getName()!=null ? registro.getName() : "").append(CIERRA_TD)
                        .append(ABRE_TD).append(status).append(CIERRA_TD)
                        .append(ABRE_TD).append(CustomThymeleafHelper.formatNumber(registro.getFee(), 4, null)).append(CIERRA_TD)
                        .append(ABRE_TD).append(CustomThymeleafHelper.formatNumber(registro.getFeeContract(), 4, null)).append(CIERRA_TD)
                        .append(ABRE_TD).append(CustomThymeleafHelper.formatNumber(registro.getSaldoDiario(), 4, null)).append(CIERRA_TD)
                        .append(CIERRA_TR);
            }
            bld.append(TABLE_END);
            if ( omitidos>0) {
                bld.append(SALTO_CIERRE_HTML).append(omitidos).append(" registros omitidos por estar ok.").append("</b>");
            }
        }
        if ( ! msg.isEmpty()) {
            bld.append(SALTO_CIERRE_HTML).append(msg).append("</b>");
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
