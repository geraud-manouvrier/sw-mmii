package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.models.db.core.entity.OficinaStonex;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Component
public class ReportesIngresosEgresosHelper {

    @Autowired
    private CalendarioHelper calendarioHelper;


    public Date excelValueAsDate(String originalValue, String formatIn) throws QandeMmiiException {
        if(originalValue == null || originalValue.equals("")) {
            return null;
        }
        try {
            return calendarioHelper.convierteFechaStrToDateWithFormat(originalValue, formatIn);
        } catch (ParseException e) {
            throw new QandeMmiiException(e, "Error al formatear fecha ["+originalValue+"] al formato ["+formatIn+"]: "+e.getMessage());
        }
    }

    public String[] encabezadoPrincipalReporte() {
        return new String[]{
                "INGRESOS", "GASTOS - Distribution Fee", "RECONOCIMIENTO ADICIONAL", "COLLECT ON BEHALF OF",
                "AuM Promedio", "Advisory Fee promedio", "Margen promedio SURA US"
        };

    }

    public String generaNombreReporteMensual(Date fecha) {
        var strDate = calendarioHelper.convierteDateToStringWithFormat(fecha, "MMddyyyy");
        return "Informe de Ingresos y Egresos Mensual - "+strDate+".xlsx";
    }

    public String generaNombreReporteDiario(Date fecha) {
        var strDate = calendarioHelper.convierteDateToStringWithFormat(fecha, "MMddyyyy");
        return "Informe de Ingresos y Egresos Diario - "+strDate+".xlsx";
    }



    public Font setHeaderFont(Workbook reporteExcel, int row, int grupoValores) {
        Font font = reporteExcel.createFont();
        switch (row) {
            case 1:
                if (grupoValores==4) {
                    font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
                }
            case 2:
            case 3:
            case 4:
            default:
                font.setBold(true);
        }

        return font;
    }

    public XSSFColor headerColor(int row, int grupoValores) {
        switch (row) {
            case 1:
                return headerFirstColor(grupoValores);
            case 2:
                return headerSecondColor(grupoValores);
            case 3:
                return headerThirdColor(grupoValores);
            case 4:
                return headerFourthColor(grupoValores);
            default:
                return headerFirstColor(grupoValores);
        }
    }

    private XSSFColor headerFirstColor(int grupoValores) {
        switch (grupoValores) {
            case 1:
                return excelColorFromRgb(142, 169, 219);
            case 2:
                return excelColorFromRgb(244, 176, 132);
            case 3:
                return excelColorFromRgb(169, 208, 142);
            case 4:
                return excelColorFromRgb(58, 56, 56);
            case 5:
                return excelColorFromRgb(191, 143, 0);
            case 6:
                return excelColorFromRgb(155, 194, 230);
            case 7:
                return excelColorFromRgb(201, 201, 201);
            default:
                return excelColorFromRgb(250, 250, 250);
        }
    }

    private XSSFColor headerSecondColor(int grupoValores) {
        switch (grupoValores) {
            case 1:
                return excelColorFromRgb(47, 117, 181);
            case 2:
                return excelColorFromRgb(237, 125, 49);
            case 3:
                return excelColorFromRgb(112, 173, 71);
            case 4:
                return excelColorFromRgb(208, 206, 206);
            case 5:
                return excelColorFromRgb(255, 230, 153);
            case 6:
                return excelColorFromRgb(221, 235, 247);
            case 7:
                return excelColorFromRgb(237, 237, 237);
            default:
                return excelColorFromRgb(250, 250, 250);
        }
    }

    private XSSFColor headerThirdColor(int grupoValores) {
        switch (grupoValores) {
            case 1:
                return excelColorFromRgb(142, 169, 219);
            case 2:
                return excelColorFromRgb(244, 176, 132);
            case 3:
                return excelColorFromRgb(169, 208, 142);
            case 4:
                return excelColorFromRgb(174, 170, 170);
            case 5:
                return excelColorFromRgb(255, 230, 153);
            case 6:
                return excelColorFromRgb(221, 235, 247);
            case 7:
                return excelColorFromRgb(237, 237, 237);
            default:
                return excelColorFromRgb(250, 250, 250);
        }
    }

    private XSSFColor headerFourthColor(int grupoValores) {
        switch (grupoValores) {
            case 1:
                return excelColorFromRgb(142, 169, 219);
            case 2:
                return excelColorFromRgb(244, 176, 132);
            case 3:
                return excelColorFromRgb(169, 208, 142);
            case 4:
                return excelColorFromRgb(174, 170, 170);
            case 5:
                return excelColorFromRgb(255, 230, 153);
            case 6:
                return excelColorFromRgb(221, 235, 247);
            case 7:
                return excelColorFromRgb(237, 237, 237);
            default:
                return excelColorFromRgb(250, 250, 250);
        }
    }

    private XSSFColor excelColorFromRgb(int r, int g, int b) {
        return new XSSFColor(new byte[] {(byte) r, (byte) g, (byte) b});
    }



    public BigDecimal[] fourthRowValue(List<OficinaStonex> listaOficinas, int grupoValores, int indicadorOficna) {
        var oficina = listaOficinas.get(indicadorOficna);
        switch (grupoValores) {
            case 2:
                return new BigDecimal[] {oficina.getDistributionFeePercent()};
            case 3:
                return new BigDecimal[] {oficina.getReconocimientoAdicionalPercent(), oficina.getIvaPercent()};
            case 4:
                return new BigDecimal[] {oficina.getCollectOnBehalfOfPercent(), oficina.getIvaPercent()};
            default:
                return new BigDecimal[] {null};
        }
    }


    public void addCell(Row row, int column, Object cellValue, CellStyle customStyle) {
        var newCell = row.createCell(column);
        if (cellValue==null) {
            newCell.setCellValue("");
        } else {
            if (cellValue instanceof String) {
                newCell.setCellValue((String)cellValue);
            } else if (cellValue instanceof Double) {
                newCell.setCellValue((Double)cellValue);
            } else if (cellValue instanceof Integer) {
                newCell.setCellValue((Integer)cellValue);
            } else if (cellValue instanceof Date) {
                newCell.setCellValue((Date)cellValue);
            } else if (cellValue instanceof BigDecimal) {
                newCell.setCellValue(((BigDecimal)cellValue).doubleValue());
            } else {
                newCell.setCellValue(cellValue.toString());
            }
        }

        if (customStyle!=null) {
            newCell.setCellStyle(customStyle);
        }
    }

    public int calculaColumna(int numOficina, int grupoValores, int desfaseInicial, int cantidadOficinas) {
        if (numOficina==0) {
            //Oficina 0 es para totales
            numOficina  = cantidadOficinas+1;
        }

        int tamanioBloque1 = (cantidadOficinas+1)*2;
        int tamanioBloqueAux = ((grupoValores-3)*3*cantidadOficinas);
        int tamanioBloque2 = (cantidadOficinas*3)*2;
        int tamanioBloque3 = ((cantidadOficinas+1)*(grupoValores-5));

        if(grupoValores<=2) {
            //Ingresos, Gastos y Recon. Adic.
            return ((cantidadOficinas+1)*(grupoValores-1))+(numOficina)+desfaseInicial-1;
        } else if ((grupoValores==3) || (grupoValores==4)) {
            return tamanioBloque1+tamanioBloqueAux+((numOficina-1)*3)+desfaseInicial;
        } else {
            return tamanioBloque1+tamanioBloque2+tamanioBloque3+numOficina+desfaseInicial-1;
        }
    }

}
