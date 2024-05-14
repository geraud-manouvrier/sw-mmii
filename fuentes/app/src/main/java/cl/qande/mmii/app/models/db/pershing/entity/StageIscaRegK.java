package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_isca_reg_k", schema = "stage_pershing")
public class StageIscaRegK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_proceso")
    private Long idProceso;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Size(max = 100)
    @Column(name = "record_indicator", length = 100)
    private String recordIndicator;

    @Column(name = "record_id_sequence_number")
    private Integer recordIdSequenceNumber;

    @Size(max = 100)
    @Column(name = "cusip_number", length = 100)
    private String cusipNumber;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_1", length = 100)
    private String exchangeCodeSedol1;

    @Size(max = 100)
    @Column(name = "sedol_1", length = 100)
    private String sedol1;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_2", length = 100)
    private String exchangeCodeSedol2;

    @Size(max = 100)
    @Column(name = "sedol_2", length = 100)
    private String sedol2;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_3", length = 100)
    private String exchangeCodeSedol3;

    @Size(max = 100)
    @Column(name = "sedol_3", length = 100)
    private String sedol3;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_4", length = 100)
    private String exchangeCodeSedol4;

    @Size(max = 100)
    @Column(name = "sedol_4", length = 100)
    private String sedol4;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_5", length = 100)
    private String exchangeCodeSedol5;

    @Size(max = 100)
    @Column(name = "sedol_5", length = 100)
    private String sedol5;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_6", length = 100)
    private String exchangeCodeSedol6;

    @Size(max = 100)
    @Column(name = "sedol_6", length = 100)
    private String sedol6;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_7", length = 100)
    private String exchangeCodeSedol7;

    @Size(max = 100)
    @Column(name = "sedol_7", length = 100)
    private String sedol7;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_8", length = 100)
    private String exchangeCodeSedol8;

    @Size(max = 100)
    @Column(name = "sedol_8", length = 100)
    private String sedol8;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_9", length = 100)
    private String exchangeCodeSedol9;

    @Size(max = 100)
    @Column(name = "sedol_9", length = 100)
    private String sedol9;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_10", length = 100)
    private String exchangeCodeSedol10;

    @Size(max = 100)
    @Column(name = "sedol_10", length = 100)
    private String sedol10;

    @Size(max = 100)
    @Column(name = "exchange_code_sedol_11", length = 100)
    private String exchangeCodeSedol11;

    @Size(max = 100)
    @Column(name = "sedol_11", length = 100)
    private String sedol11;

    @Size(max = 100)
    @Column(name = "campo_26", length = 100)
    private String campo26;

    @Size(max = 100)
    @Column(name = "eor", length = 100)
    private String eor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Long idProceso) {
        this.idProceso = idProceso;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getRecordIndicator() {
        return recordIndicator;
    }

    public void setRecordIndicator(String recordIndicator) {
        this.recordIndicator = recordIndicator;
    }

    public Integer getRecordIdSequenceNumber() {
        return recordIdSequenceNumber;
    }

    public void setRecordIdSequenceNumber(Integer recordIdSequenceNumber) {
        this.recordIdSequenceNumber = recordIdSequenceNumber;
    }

    public String getCusipNumber() {
        return cusipNumber;
    }

    public void setCusipNumber(String cusipNumber) {
        this.cusipNumber = cusipNumber;
    }

    public String getExchangeCodeSedol1() {
        return exchangeCodeSedol1;
    }

    public void setExchangeCodeSedol1(String exchangeCodeSedol1) {
        this.exchangeCodeSedol1 = exchangeCodeSedol1;
    }

    public String getSedol1() {
        return sedol1;
    }

    public void setSedol1(String sedol1) {
        this.sedol1 = sedol1;
    }

    public String getExchangeCodeSedol2() {
        return exchangeCodeSedol2;
    }

    public void setExchangeCodeSedol2(String exchangeCodeSedol2) {
        this.exchangeCodeSedol2 = exchangeCodeSedol2;
    }

    public String getSedol2() {
        return sedol2;
    }

    public void setSedol2(String sedol2) {
        this.sedol2 = sedol2;
    }

    public String getExchangeCodeSedol3() {
        return exchangeCodeSedol3;
    }

    public void setExchangeCodeSedol3(String exchangeCodeSedol3) {
        this.exchangeCodeSedol3 = exchangeCodeSedol3;
    }

    public String getSedol3() {
        return sedol3;
    }

    public void setSedol3(String sedol3) {
        this.sedol3 = sedol3;
    }

    public String getExchangeCodeSedol4() {
        return exchangeCodeSedol4;
    }

    public void setExchangeCodeSedol4(String exchangeCodeSedol4) {
        this.exchangeCodeSedol4 = exchangeCodeSedol4;
    }

    public String getSedol4() {
        return sedol4;
    }

    public void setSedol4(String sedol4) {
        this.sedol4 = sedol4;
    }

    public String getExchangeCodeSedol5() {
        return exchangeCodeSedol5;
    }

    public void setExchangeCodeSedol5(String exchangeCodeSedol5) {
        this.exchangeCodeSedol5 = exchangeCodeSedol5;
    }

    public String getSedol5() {
        return sedol5;
    }

    public void setSedol5(String sedol5) {
        this.sedol5 = sedol5;
    }

    public String getExchangeCodeSedol6() {
        return exchangeCodeSedol6;
    }

    public void setExchangeCodeSedol6(String exchangeCodeSedol6) {
        this.exchangeCodeSedol6 = exchangeCodeSedol6;
    }

    public String getSedol6() {
        return sedol6;
    }

    public void setSedol6(String sedol6) {
        this.sedol6 = sedol6;
    }

    public String getExchangeCodeSedol7() {
        return exchangeCodeSedol7;
    }

    public void setExchangeCodeSedol7(String exchangeCodeSedol7) {
        this.exchangeCodeSedol7 = exchangeCodeSedol7;
    }

    public String getSedol7() {
        return sedol7;
    }

    public void setSedol7(String sedol7) {
        this.sedol7 = sedol7;
    }

    public String getExchangeCodeSedol8() {
        return exchangeCodeSedol8;
    }

    public void setExchangeCodeSedol8(String exchangeCodeSedol8) {
        this.exchangeCodeSedol8 = exchangeCodeSedol8;
    }

    public String getSedol8() {
        return sedol8;
    }

    public void setSedol8(String sedol8) {
        this.sedol8 = sedol8;
    }

    public String getExchangeCodeSedol9() {
        return exchangeCodeSedol9;
    }

    public void setExchangeCodeSedol9(String exchangeCodeSedol9) {
        this.exchangeCodeSedol9 = exchangeCodeSedol9;
    }

    public String getSedol9() {
        return sedol9;
    }

    public void setSedol9(String sedol9) {
        this.sedol9 = sedol9;
    }

    public String getExchangeCodeSedol10() {
        return exchangeCodeSedol10;
    }

    public void setExchangeCodeSedol10(String exchangeCodeSedol10) {
        this.exchangeCodeSedol10 = exchangeCodeSedol10;
    }

    public String getSedol10() {
        return sedol10;
    }

    public void setSedol10(String sedol10) {
        this.sedol10 = sedol10;
    }

    public String getExchangeCodeSedol11() {
        return exchangeCodeSedol11;
    }

    public void setExchangeCodeSedol11(String exchangeCodeSedol11) {
        this.exchangeCodeSedol11 = exchangeCodeSedol11;
    }

    public String getSedol11() {
        return sedol11;
    }

    public void setSedol11(String sedol11) {
        this.sedol11 = sedol11;
    }

    public String getCampo26() {
        return campo26;
    }

    public void setCampo26(String campo26) {
        this.campo26 = campo26;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}