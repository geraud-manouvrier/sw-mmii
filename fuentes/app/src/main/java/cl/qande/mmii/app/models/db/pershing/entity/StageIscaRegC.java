package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "stage_isca_reg_c", schema = "stage_pershing")
public class StageIscaRegC {
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
    @Column(name = "state_tax_ind", length = 100)
    private String stateTaxInd;

    @Size(max = 100)
    @Column(name = "fts_ind", length = 100)
    private String ftsInd;

    @Size(max = 100)
    @Column(name = "amt_ind", length = 100)
    private String amtInd;

    @Size(max = 100)
    @Column(name = "ric_indicator", length = 100)
    private String ricIndicator;

    @Size(max = 100)
    @Column(name = "number_of_description_lines", length = 100)
    private String numberOfDescriptionLines;

    @Size(max = 100)
    @Column(name = "secutiry_description_line_1", length = 100)
    private String secutiryDescriptionLine1;

    @Size(max = 100)
    @Column(name = "secutiry_description_line_2", length = 100)
    private String secutiryDescriptionLine2;

    @Size(max = 100)
    @Column(name = "secutiry_description_line_3", length = 100)
    private String secutiryDescriptionLine3;

    @Size(max = 100)
    @Column(name = "secutiry_description_line_4", length = 100)
    private String secutiryDescriptionLine4;

    @Size(max = 100)
    @Column(name = "secutiry_description_line_5", length = 100)
    private String secutiryDescriptionLine5;

    @Size(max = 100)
    @Column(name = "user_cusip_identifier", length = 100)
    private String userCusipIdentifier;

    @Column(name = "price_purge_date")
    private LocalDate pricePurgeDate;

    @Size(max = 100)
    @Column(name = "taxable_indicator", length = 100)
    private String taxableIndicator;

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

    public String getStateTaxInd() {
        return stateTaxInd;
    }

    public void setStateTaxInd(String stateTaxInd) {
        this.stateTaxInd = stateTaxInd;
    }

    public String getFtsInd() {
        return ftsInd;
    }

    public void setFtsInd(String ftsInd) {
        this.ftsInd = ftsInd;
    }

    public String getAmtInd() {
        return amtInd;
    }

    public void setAmtInd(String amtInd) {
        this.amtInd = amtInd;
    }

    public String getRicIndicator() {
        return ricIndicator;
    }

    public void setRicIndicator(String ricIndicator) {
        this.ricIndicator = ricIndicator;
    }

    public String getNumberOfDescriptionLines() {
        return numberOfDescriptionLines;
    }

    public void setNumberOfDescriptionLines(String numberOfDescriptionLines) {
        this.numberOfDescriptionLines = numberOfDescriptionLines;
    }

    public String getSecutiryDescriptionLine1() {
        return secutiryDescriptionLine1;
    }

    public void setSecutiryDescriptionLine1(String secutiryDescriptionLine1) {
        this.secutiryDescriptionLine1 = secutiryDescriptionLine1;
    }

    public String getSecutiryDescriptionLine2() {
        return secutiryDescriptionLine2;
    }

    public void setSecutiryDescriptionLine2(String secutiryDescriptionLine2) {
        this.secutiryDescriptionLine2 = secutiryDescriptionLine2;
    }

    public String getSecutiryDescriptionLine3() {
        return secutiryDescriptionLine3;
    }

    public void setSecutiryDescriptionLine3(String secutiryDescriptionLine3) {
        this.secutiryDescriptionLine3 = secutiryDescriptionLine3;
    }

    public String getSecutiryDescriptionLine4() {
        return secutiryDescriptionLine4;
    }

    public void setSecutiryDescriptionLine4(String secutiryDescriptionLine4) {
        this.secutiryDescriptionLine4 = secutiryDescriptionLine4;
    }

    public String getSecutiryDescriptionLine5() {
        return secutiryDescriptionLine5;
    }

    public void setSecutiryDescriptionLine5(String secutiryDescriptionLine5) {
        this.secutiryDescriptionLine5 = secutiryDescriptionLine5;
    }

    public String getUserCusipIdentifier() {
        return userCusipIdentifier;
    }

    public void setUserCusipIdentifier(String userCusipIdentifier) {
        this.userCusipIdentifier = userCusipIdentifier;
    }

    public LocalDate getPricePurgeDate() {
        return pricePurgeDate;
    }

    public void setPricePurgeDate(LocalDate pricePurgeDate) {
        this.pricePurgeDate = pricePurgeDate;
    }

    public String getTaxableIndicator() {
        return taxableIndicator;
    }

    public void setTaxableIndicator(String taxableIndicator) {
        this.taxableIndicator = taxableIndicator;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}