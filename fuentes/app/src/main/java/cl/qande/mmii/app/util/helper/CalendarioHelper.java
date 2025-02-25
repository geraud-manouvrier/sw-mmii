package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.models.exception.QandeMmiiException;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class CalendarioHelper {

    public static final String FORMATO_AAAA_MM_DD       = "yyyy-MM-dd";
    public static final String FORMATO_DD_MM_AAAA       = "dd-MM-yyyy";
    public static final String FORMATO_AAAAMM           = "yyyyMM";

    public static final String FORMATO_HTML             = "dd/MM/yyyy";
    public static final String FORMATO_API_BCOCENTRAL   = "dd-MM-yyyy";
    public static final String FORMATO_BD               = FORMATO_AAAA_MM_DD;
    public static final String FORMATO_PROCESS_DATE     = "yyyyMMdd";

    protected static final String[] MESES_ES = new String[]{
            "Enero", "Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre",
    };
    protected static final String[] MESES_EN = MESES_ES;
    private static final int DESFASE_DIAS = -1;

    public Date generaFechaDesdePeriodoCorte(Integer periodoYyyyMm, boolean inicioMes, Integer desfaseMes) throws ParseException {
        var formatoBd = new SimpleDateFormat(FORMATO_AAAA_MM_DD);
        String fechaDesdeStr    = periodoYyyyMm / 100 +"-"+ periodoYyyyMm % 100 + "-01";
        Date fechaDesde         = formatoBd.parse(fechaDesdeStr);

        var calendario = Calendar.getInstance();
        calendario.setTime(fechaDesde);

        calendario.add(Calendar.MONTH, desfaseMes);
        fechaDesde  = calendario.getTime();
        if ( !inicioMes) {
            //Final de mes: sumamos un mes y luego restamos un día
            calendario.add(Calendar.MONTH, 1);
            calendario.add(Calendar.DATE, -1);
            fechaDesde  = calendario.getTime();
        }
        return fechaDesde;
    }

    public Date inicioMes(Date fecha, int desfaseMeses) {
        var calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE, -calendario.get(Calendar.DATE)+1);
        calendario.add(Calendar.MONTH, -desfaseMeses);
        return calendario.getTime();
    }

    public String generaPeriodo(Date fecha) {
        return new SimpleDateFormat(FORMATO_AAAAMM).format(fecha);
    }

    public String generaPeriodoActual() {
        var calendario = Calendar.getInstance();
        Date fechaActual     = calendario.getTime();
        return this.generaPeriodo(fechaActual);
    }

    public String convierteDateToString(Date fechaDate) {
        DateFormat dateFormat   = new SimpleDateFormat(FORMATO_AAAA_MM_DD);
        return dateFormat.format(fechaDate);
    }

    public String convierteDateToStringWithFormat(Date fechaDate, String format) {
        DateFormat dateFormat   = new SimpleDateFormat(format);
        return dateFormat.format(fechaDate);
    }
    public String convierteTodayToString() {
        var calendario = Calendar.getInstance();
        Date hoy     = calendario.getTime();

        return this.convierteDateToString(hoy);
    }

    public Date fechaConDesfaseDias(Date fecha, int desfaseDias) {
        var calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE, desfaseDias);
        return calendario.getTime();
    }

    public int getDatePart(Date fecha, int field) {
        var calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        if (field==Calendar.MONTH) {
            return calendario.get(field)+1;
        }
        return calendario.get(field);
    }

    public Date hoyConDesfaseDias(int desfaseDias) {
        var calendario = Calendar.getInstance();
        Date hoy     = calendario.getTime();
        return fechaConDesfaseDias(hoy, desfaseDias);
    }

    public Date convierteFechaStrToFormatoBd(String fechaStr) throws ParseException {
        var formatoBd = new SimpleDateFormat(FORMATO_BD);
        return formatoBd.parse(fechaStr);
    }

    public Date convierteFechaStrToDateWithFormat(String fechaStr, String format) throws ParseException {
        var formatoFecha = new SimpleDateFormat(format);
        return formatoFecha.parse(fechaStr);
    }

    public LocalDate convierteFechaStrToLocalDateWithFormat(String fechaStr, String format) throws ParseException {
        var fechaAsDate  = convierteFechaStrToDateWithFormat(fechaStr, format);
        return fechaAsDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String convierteFechaToFormatoHtml(Date fecha) {
        var formatoHtml = new SimpleDateFormat(FORMATO_HTML);
        return formatoHtml.format(fecha);
    }

    public String nombreMes(int numMes, String lang) {
        if (lang.equals("EN")) {
            return CalendarioHelper.MESES_EN[numMes - 1];
        }
        return CalendarioHelper.MESES_ES[numMes - 1];
    }

    public Date makeDateFromParts(int anio, int mes, int dia) {
        var calendario = Calendar.getInstance();
        calendario.set(Calendar.DATE, dia);
        calendario.set(Calendar.MONTH, mes-1);
        calendario.set(Calendar.YEAR, anio);
        return calendario.getTime();
    }

    public String convierteFechaStrToFechaPershing(String fechaYmd) {
        //Fecha viene en formato YYYYMMDD -> MMDDYY
        return fechaYmd.substring(4,6).concat(fechaYmd.substring(6,8)).concat(fechaYmd.substring(2,4));
    }


    public static LocalDate dateFromExcelNumber(Double dateAsNumber) {
        Date javaDate= DateUtil.getJavaDate(dateAsNumber);
        return javaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date dateFromLocalDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


    public String defaultProcessDate() {
        return convierteDateToString(hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
    }
    private boolean isValidValueDate(String dateAsStr, String format) {
        try {
            var dateAsDate  = convierteFechaStrToDateWithFormat(dateAsStr, format);
            return (convierteDateToStringWithFormat(dateAsDate, format).equals(dateAsStr));
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isValidDate(String dateAsStr) {
        return (
                dateAsStr!=null
                        && dateAsStr.matches("^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")
                && isValidValueDate(dateAsStr, FORMATO_AAAA_MM_DD)
        );
    }


    public boolean isValidProcessDate(String dateAsStr) {
        return (
                dateAsStr!=null
                        && dateAsStr.matches("^(19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])$")
                        && isValidValueDate(dateAsStr, FORMATO_PROCESS_DATE)
        );
    }

    public int getDiasEntreFechas(Date fechaInicio, Date fechaFin) {
        int milisecondsByDay = 86400000;
        return (int) ((fechaFin.getTime()-fechaInicio.getTime()) / milisecondsByDay);
    }

    public List<String> processDateRangeToList(String startProcessDate, String endProcessDate) throws QandeMmiiException {
        int maxDiffFechas   = 150;
        if (! isValidProcessDate(startProcessDate) ) {
            throw new QandeMmiiException("Start Process Date no válida");
        }
        if (! isValidProcessDate(endProcessDate) ) {
            throw new QandeMmiiException("End Process Date no válida");
        }
        var salida = new java.util.ArrayList<String>();
        try {
            var startDate   = convierteFechaStrToDateWithFormat(startProcessDate, FORMATO_PROCESS_DATE);
            var endDate     = convierteFechaStrToDateWithFormat(endProcessDate, FORMATO_PROCESS_DATE);
            if (startDate.compareTo(endDate)>0) {
                throw new QandeMmiiException("Start Process Date debe ser menor o igual a End Process Date");
            }
            var diff        = getDiasEntreFechas(startDate, endDate);
            if (diff>maxDiffFechas) {
                throw new QandeMmiiException("Rango de fechas no puede superar los 150 días ["+startProcessDate+" - "+endProcessDate+" - "+diff+"]");
            }
            int desfase = 0;
            while(true) {
                var currentDate = fechaConDesfaseDias(startDate, desfase);
                var currentProcessDate  = convierteDateToStringWithFormat(currentDate, FORMATO_PROCESS_DATE);
                salida.add(currentProcessDate);
                desfase++;
                if (currentProcessDate.equals(endProcessDate)) {
                    break;
                }
                if (desfase>maxDiffFechas) {
                    throw new QandeMmiiException("Error al generar rango de fechas, se superó rango de generación de fechas: Desfase en ["+desfase+"] para ["+currentProcessDate+"]; ["+startProcessDate+" - "+endProcessDate+" - "+diff+"]");
                }
            }
        } catch (ParseException e) {
            throw new QandeMmiiException("Error al convertir process date: "+e.getMessage());
        }
        return salida;
    }

    public static String convierteDateToProcessDate(Date fechaDate) {
        DateFormat dateFormat   = new SimpleDateFormat(CalendarioHelper.FORMATO_PROCESS_DATE);
        return dateFormat.format(fechaDate);
    }

    public static Date convierteProcessDateToDate(String fechaStr) throws ParseException {
        var formatoFecha = new SimpleDateFormat(FORMATO_PROCESS_DATE);
        return formatoFecha.parse(fechaStr);
    }

    public static String processDateConDesfase(String processDate, int desfaseDias) throws ParseException {
        CalendarioHelper calendarioHelper = new CalendarioHelper();
        var newProcessDate  = calendarioHelper.fechaConDesfaseDias(convierteProcessDateToDate(processDate), desfaseDias);
        return convierteDateToProcessDate(newProcessDate);
    }

}
