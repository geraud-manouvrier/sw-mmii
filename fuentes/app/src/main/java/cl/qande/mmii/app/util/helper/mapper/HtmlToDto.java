package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.dto.RectificacionCuentasNoInformadaDto;
import cl.qande.mmii.app.models.dto.RectificacionMovimientosNoInformadoDto;
import cl.qande.mmii.app.models.dto.RectificacionSaldosNoInformadoDto;
import cl.qande.mmii.app.models.exception.MapperException;
import cl.qande.mmii.app.util.helper.CalendarioHelper;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;


public interface HtmlToDto {

    public static final int CANT_COL_CTA    = 44;
    public static final int CANT_COL_SAL    = 34;   //Sin process date
    public static final int CANT_COL_MOV    = 40;   //Sin process date
    public static final int LAST_ROW    = 19;


    public static List<RectificacionCuentasNoInformadaDto> listaRectificacionCuentasNoInformadaDtoFromHtml(ArrayList <LinkedHashMap> hojaExcelHtmlCuentas, int idEstado, String usuarioCreacion, Instant fechaCreacion, String processDate) throws MapperException {
        List<RectificacionCuentasNoInformadaDto> listaRectificacionCuentasNoInformadaDto  = new ArrayList<>();
        if(hojaExcelHtmlCuentas.isEmpty()) {
            return listaRectificacionCuentasNoInformadaDto;
        } else {
            for(int i=1; i<hojaExcelHtmlCuentas.size(); i++) {
                var filaActual  = HtmlToDto.listaStringFromHojaExcelHtml(hojaExcelHtmlCuentas, i, CANT_COL_CTA);
                if ( (i>LAST_ROW) || (filaActual.size()<CANT_COL_CTA) ) {
                    continue;
                }
                RectificacionCuentasNoInformadaDto filaActualAsDto = null;
                try {
                    filaActualAsDto = rectificacionCuentasNoInformadaDtoFromHtml(filaActual);
                    filaActualAsDto.setProcessDate(processDate);
                    filaActualAsDto.setIdEstadoRectificacion(idEstado);
                    filaActualAsDto.setRegistradorUser(usuarioCreacion);
                    filaActualAsDto.setRegistradorTimestamp(fechaCreacion);
                } catch (MapperException e) {
                    throw new MapperException("Error en fila "+(i+1)+". "+e);
                }
                listaRectificacionCuentasNoInformadaDto.add(filaActualAsDto);
            }
        }
        return listaRectificacionCuentasNoInformadaDto;
    }

    public static List<RectificacionSaldosNoInformadoDto> listaRectificacionSaldosNoInformadaDtoFromHtml(ArrayList <LinkedHashMap> hojaExcelHtmlSaldos, int idEstado, String usuarioCreacion, Instant fechaCreacion, String processDate) throws MapperException {
        List<RectificacionSaldosNoInformadoDto> rectificacionSaldosNoInformadoDtos  = new ArrayList<>();
        if(hojaExcelHtmlSaldos.isEmpty()) {
            return rectificacionSaldosNoInformadoDtos;
        } else {
            for(int i=1; i<hojaExcelHtmlSaldos.size(); i++) {
                var filaActual  = HtmlToDto.listaStringFromHojaExcelHtml(hojaExcelHtmlSaldos, i, CANT_COL_SAL);
                if ( (i>LAST_ROW) || (filaActual.size()<CANT_COL_SAL) ) {
                    continue;
                }
                RectificacionSaldosNoInformadoDto filaActualAsDto = null;
                try {
                    filaActualAsDto = rectificacionSaldosNoInformadaDtoFromHtml(filaActual);
                    filaActualAsDto.setProcessDate(processDate);
                    filaActualAsDto.setIdEstadoRectificacion(idEstado);
                    filaActualAsDto.setRegistradorUser(usuarioCreacion);
                    filaActualAsDto.setRegistradorTimestamp(fechaCreacion);
                } catch (MapperException e) {
                    throw new MapperException("Error en fila "+(i+1)+". "+e);
                }
                rectificacionSaldosNoInformadoDtos.add(filaActualAsDto);
            }
        }
        return rectificacionSaldosNoInformadoDtos;
    }


    public static List<RectificacionMovimientosNoInformadoDto> listaRectificacionMovimientosNoInformadaDtoFromHtml(ArrayList <LinkedHashMap> hojaExcelHtmlMovimientos, int idEstado, String usuarioCreacion, Instant fechaCreacion, String processDate) throws MapperException {
        List<RectificacionMovimientosNoInformadoDto> rectificacionMovimientosNoInformadoDtos  = new ArrayList<>();
        if(hojaExcelHtmlMovimientos.isEmpty()) {
            return rectificacionMovimientosNoInformadoDtos;
        } else {
            for(int i=1; i<hojaExcelHtmlMovimientos.size(); i++) {
                var filaActual  = HtmlToDto.listaStringFromHojaExcelHtml(hojaExcelHtmlMovimientos, i, CANT_COL_MOV);
                if ( (i>LAST_ROW) || (filaActual.size()<CANT_COL_MOV) ) {
                    continue;
                }
                RectificacionMovimientosNoInformadoDto filaActualAsDto = null;
                try {
                    filaActualAsDto = rectificacionMovimientosNoInformadaDtoFromHtml(filaActual);
                    filaActualAsDto.setProcessDate(processDate);
                    filaActualAsDto.setIdEstadoRectificacion(idEstado);
                    filaActualAsDto.setRegistradorUser(usuarioCreacion);
                    filaActualAsDto.setRegistradorTimestamp(fechaCreacion);
                } catch (MapperException e) {
                    throw new MapperException("Error en fila "+(i+1)+". "+e);
                }
                rectificacionMovimientosNoInformadoDtos.add(filaActualAsDto);
            }
        }
        return rectificacionMovimientosNoInformadoDtos;
    }

    public static RectificacionCuentasNoInformadaDto rectificacionCuentasNoInformadaDtoFromHtml(List<String> filaCuentas) throws MapperException {
        var rectificacionCuentasNoInformadaDto  = new RectificacionCuentasNoInformadaDto();
        int i=0;
        if(filaCuentas.size()<CANT_COL_CTA) {
            throw new MapperException("No vienen todas las columnas ("+CANT_COL_CTA+")");
        }
        try {

            rectificacionCuentasNoInformadaDto.setCustodian(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setClientId(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setFirmNo(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setSubNo(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setRepNo(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setOfficeId(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setAccountNo(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setName(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setFullName(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setAddress(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setShortName(filaCuentas.get(i)); i++;

            rectificacionCuentasNoInformadaDto.setDateOfBirth(getLocalDateValue(filaCuentas.get(i))); i++;

            rectificacionCuentasNoInformadaDto.setAcctStatusValue(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setEmail(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setCountryCodeValue(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setCountry(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setW8Date(filaCuentas.get(i)); i++;

            rectificacionCuentasNoInformadaDto.setW9Date(getLocalDateValue(filaCuentas.get(i))); i++;

            rectificacionCuentasNoInformadaDto.setW8StatusValue(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setW9StatusValue(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setDiscrTradingCodeValue(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setAccountType(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setContratosPa(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setCashMarginAccount(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setModeloRelacionamiento(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setDebitCardIndicator(filaCuentas.get(i)); i++;

            rectificacionCuentasNoInformadaDto.setOpenDate(getLocalDateValueAsString(filaCuentas.get(i))); i++;

            rectificacionCuentasNoInformadaDto.setCloseDate(getLocalDateValue(filaCuentas.get(i))); i++;

            rectificacionCuentasNoInformadaDto.setParticipantType(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setClientInvestmentProfile(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setPortfolio(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setTipoServicio(filaCuentas.get(i)); i++;

            rectificacionCuentasNoInformadaDto.setAdvisoryFeeAnnualPct(getBigDecimalValue(filaCuentas.get(i))); i++;


            rectificacionCuentasNoInformadaDto.setLastStatementDate(getLocalDateValue(filaCuentas.get(i))); i++;

            rectificacionCuentasNoInformadaDto.setMainAdvisor(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setSecondaryAdvisor(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setEmailMainAdvisor(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setEmailSecondaryAdvisor(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setTaxId(filaCuentas.get(i)); i++;

            rectificacionCuentasNoInformadaDto.setLastActivityMonth(getLocalDateValue(filaCuentas.get(i))); i++;

            rectificacionCuentasNoInformadaDto.setInstitutionCode(filaCuentas.get(i)); i++;
            rectificacionCuentasNoInformadaDto.setRestrictionDate(filaCuentas.get(i)); i++;

            rectificacionCuentasNoInformadaDto.setFondeo(getBigDecimalValue(filaCuentas.get(i))); i++;

            rectificacionCuentasNoInformadaDto.setMontoComprometido(getBigDecimalValue(filaCuentas.get(i)));
        } catch (Exception e) {
            throw new MapperException("Error en columna "+(i+1)+" ["+filaCuentas.get(i)+"]. "+e);
        }
        return rectificacionCuentasNoInformadaDto;
    }

    public static RectificacionSaldosNoInformadoDto rectificacionSaldosNoInformadaDtoFromHtml(List<String> filaSaldos) throws MapperException {
        var rectificacionSaldosNoInformadoDto  = new RectificacionSaldosNoInformadoDto();
        int i=0;
        if(filaSaldos.size()<CANT_COL_SAL) {
            throw new MapperException("No vienen todas las columnas ("+CANT_COL_SAL+")");
        }
        try {
            rectificacionSaldosNoInformadoDto.setCustodian(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setClientId(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setFirmNo(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setSubNo(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setOfficeId(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setRepNo(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setRep(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setAccountNo(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setName(filaSaldos.get(i)); i++;

            rectificacionSaldosNoInformadoDto.setSymbol(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setCusip(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setIsin(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setProductType(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setSecurityDescription(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setCashMarginAccount(filaSaldos.get(i)); i++;

            rectificacionSaldosNoInformadoDto.setQuantity(getBigDecimalValue(filaSaldos.get(i))); i++;
            rectificacionSaldosNoInformadoDto.setMarketPrice(getBigDecimalValue(filaSaldos.get(i))); i++;

            rectificacionSaldosNoInformadoDto.setCurrency(filaSaldos.get(i)); i++;

            rectificacionSaldosNoInformadoDto.setMarketValue(getBigDecimalValue(filaSaldos.get(i))); i++;
            rectificacionSaldosNoInformadoDto.setFxRate(getBigDecimalValue(filaSaldos.get(i))); i++;
            rectificacionSaldosNoInformadoDto.setUsdeMarketValue(getBigDecimalValue(filaSaldos.get(i))); i++;
            rectificacionSaldosNoInformadoDto.setAdvisoryFeeAnual(getBigDecimalValue(filaSaldos.get(i))); i++;

            rectificacionSaldosNoInformadoDto.setFactor(getIntegerValue(filaSaldos.get(i))); i++;

            rectificacionSaldosNoInformadoDto.setComisionDevengadaDiaria(getBigDecimalValue(filaSaldos.get(i))); i++;
            rectificacionSaldosNoInformadoDto.setUsdeMarketPrice(getBigDecimalValue(filaSaldos.get(i))); i++;

            rectificacionSaldosNoInformadoDto.setSecNo(getIntegerValue(filaSaldos.get(i))); i++;

            rectificacionSaldosNoInformadoDto.setDesc1(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setDesc2(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setDesc3(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setIdSubSubTipoActivo(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setIdSubTipoActivo(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setIdTipoActivo(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setNombreSubSubTipoActivo(filaSaldos.get(i)); i++;
            rectificacionSaldosNoInformadoDto.setSecId(filaSaldos.get(i));

        } catch (Exception e) {
            throw new MapperException("Error en columna "+(i+1)+" ["+filaSaldos.get(i)+"]. "+e);
        }
        return rectificacionSaldosNoInformadoDto;
    }


    public static RectificacionMovimientosNoInformadoDto rectificacionMovimientosNoInformadaDtoFromHtml(List<String> filaMovimientos) throws MapperException {
        var rectificacionMovimientosNoInformadoDto  = new RectificacionMovimientosNoInformadoDto();
        int i=0;
        if(filaMovimientos.size()<CANT_COL_MOV) {
            throw new MapperException("No vienen todas las columnas ("+CANT_COL_MOV+")");
        }
        try {

            rectificacionMovimientosNoInformadoDto.setCustodian(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setClientId(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setOfficeId(filaMovimientos.get(i)); i++;

            rectificacionMovimientosNoInformadoDto.setAccountNo(getIntegerValue(filaMovimientos.get(i))); i++;

            rectificacionMovimientosNoInformadoDto.setName(filaMovimientos.get(i)); i++;

            rectificacionMovimientosNoInformadoDto.setTradeDate(getLocalDateValueAsString(filaMovimientos.get(i))); i++;
            rectificacionMovimientosNoInformadoDto.setSettlementDate(getLocalDateValueAsString(filaMovimientos.get(i))); i++;
            rectificacionMovimientosNoInformadoDto.setActivity(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setBuySell(filaMovimientos.get(i)); i++;

            rectificacionMovimientosNoInformadoDto.setQuantity(getBigDecimalValue(filaMovimientos.get(i))); i++;
            rectificacionMovimientosNoInformadoDto.setPrice(getBigDecimalValue(filaMovimientos.get(i))); i++;
            rectificacionMovimientosNoInformadoDto.setComission(getBigDecimalValue(filaMovimientos.get(i))); i++;
            rectificacionMovimientosNoInformadoDto.setFees(getBigDecimalValue(filaMovimientos.get(i))); i++;
            rectificacionMovimientosNoInformadoDto.setNetAmount(getBigDecimalValue(filaMovimientos.get(i))); i++;
            rectificacionMovimientosNoInformadoDto.setUsdeNetAmount(getBigDecimalValue(filaMovimientos.get(i))); i++;
            rectificacionMovimientosNoInformadoDto.setPrincipal(getBigDecimalValue(filaMovimientos.get(i))); i++;

            rectificacionMovimientosNoInformadoDto.setCusip(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setSymbol(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setIsin(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setCurrency(filaMovimientos.get(i)); i++;

            rectificacionMovimientosNoInformadoDto.setFxRate(getBigDecimalValue(filaMovimientos.get(i))); i++;
            rectificacionMovimientosNoInformadoDto.setInterest(getBigDecimalValue(filaMovimientos.get(i))); i++;

            rectificacionMovimientosNoInformadoDto.setCurrencyBase(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setCashMarginAccount(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setProductType(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setSecurityDescription(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setActivityDescription(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setActivityCode(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setSourceCode(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setReporte(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setDescription1(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setDescription2(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setDescription3(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setTicker(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setIdSubSubTipoActivo(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setIdSubTipoActivo(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setIdTipoActivo(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setNombreSubSubTipoActivo(filaMovimientos.get(i)); i++;
            rectificacionMovimientosNoInformadoDto.setSecId(filaMovimientos.get(i)); i++;

            rectificacionMovimientosNoInformadoDto.setAplicaFlujoNeto(getIntegerValue(filaMovimientos.get(i)));


        } catch (Exception e) {
            throw new MapperException("Error en columna "+(i+1)+" ["+filaMovimientos.get(i)+"]. "+e);
        }
        return rectificacionMovimientosNoInformadoDto;
    }

    public static List<String> listaStringFromHojaExcelHtml(ArrayList <LinkedHashMap> hojaExcelHtml, int filaBaseCero, int sizeOfReturn) throws MapperException {
        List<String> listaGenerica    = new ArrayList<>();
        var filagenerica = ((ArrayList)(hojaExcelHtml.get(filaBaseCero)).get("cells"));
        for (var col=0; col<sizeOfReturn; col++) {
            var celda   = getCellValue(filagenerica, col);
            if (col==0 && (celda==null || celda.isEmpty())) {
                return listaGenerica;
            }
            listaGenerica.add(celda);
        }
        return listaGenerica;
    }

    public static String getCellValue(ArrayList filagenerica, int col) throws MapperException {
        for (var celdaActual: filagenerica) {
            var index           = (Integer)(((LinkedHashMap)celdaActual).get("index"));
            if (index==col) {
                var valor           = (((LinkedHashMap)celdaActual).get("value"));
                if (valor==null) {
                    return null;
                } else if (valor instanceof String) {
                    return (String)valor;
                } else if (valor instanceof Integer) {
                    return String.valueOf(valor);
                } else if (valor instanceof BigDecimal) {
                    return String.valueOf(valor);
                } else if (valor instanceof Double) {
                    return String.valueOf(valor);
                } else {
                    throw new MapperException("Tipo de dato no admitido en celda "+(col+1)+" (index: "+index+") para la fila");
                }
            }
        }
        return null;
    }

    public static BigDecimal getBigDecimalValue(String cellValue) throws MapperException {
        if(cellValue==null || cellValue.isEmpty()) {
            return null;
        }

        if(! ( cellValue.matches("^(-?)\\d+$") ||
                cellValue.matches("^(-?)\\d+[.,]\\d+$") ||
                cellValue.matches("^(-?)\\d+[Ee](-?)\\d+$") ||
                cellValue.matches("^(-?)\\d+[.,]\\d+[Ee](-?)\\d+$"))  ) {
            throw new MapperException("El valor ["+cellValue+"] no es un número decimal válido");
        }

        return BigDecimal.valueOf(Double.valueOf(cellValue.replace(",",".")));
    }

    public static Integer getIntegerValue(String cellValue) throws MapperException {
        if(cellValue==null || cellValue.isEmpty()) {
            return null;
        }

        if(! (cellValue.matches("^(-?)\\d+$") || cellValue.matches("^(-?)\\d+[,.](0+)$")) ) {
            throw new MapperException("El valor ["+cellValue+"] no es un número entero válido");
        }
        return Integer.valueOf(Double.valueOf(cellValue.replace(",",".")).intValue());
    }

    public static LocalDate getLocalDateValue(String cellValue) {
        if(cellValue==null || cellValue.isEmpty()) {
            return null;
        }
        cellValue   = cellValue.replace("\u00A0", "");

        //Verifica si cellValue tiene patrón YYYY-MM-DD
        if(cellValue.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return LocalDate.parse(cellValue);
        }
        //Verifica si cellValue tiene patrón YYYY-MM-DD seguido de "algo más" (descartamos lo adicional, parte de hora)
        if(cellValue.matches("^\\d{4}-\\d{2}-\\d{2}.+$")) {
            return LocalDate.parse(cellValue.substring(0,10));
        }
        var valorNumerico    = Double.valueOf(cellValue);
        return CalendarioHelper.dateFromExcelNumber(valorNumerico);
    }

    public static String getLocalDateValueAsString(String cellValue) {
        if(cellValue==null || cellValue.isEmpty()) {
            return null;
        }
        var dateAsLocalDate   = getLocalDateValue(cellValue);
        var calendarioHelper    = new CalendarioHelper();

        return calendarioHelper.convierteDateToString(Date.from(dateAsLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));


    }




}
