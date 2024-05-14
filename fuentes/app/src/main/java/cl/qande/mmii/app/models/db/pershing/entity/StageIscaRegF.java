package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "stage_isca_reg_f", schema = "stage_pershing")
public class StageIscaRegF {
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
    @Column(name = "campo_4", length = 100)
    private String campo4;

    @Column(name = "expanded_bid_price", precision = 45, scale = 20)
    private BigDecimal expandedBidPrice;

    @Column(name = "expanded_ask_price", precision = 45, scale = 20)
    private BigDecimal expandedAskPrice;

    @Column(name = "expanded_previous_day_price", precision = 45, scale = 20)
    private BigDecimal expandedPreviousDayPrice;

    @Column(name = "expanded_latest_price", precision = 45, scale = 20)
    private BigDecimal expandedLatestPrice;

    @Column(name = "expanded_end_of_month_price", precision = 45, scale = 20)
    private BigDecimal expandedEndOfMonthPrice;

    @Column(name = "contract_share_quantity", precision = 45, scale = 20)
    private BigDecimal contractShareQuantity;

    @Column(name = "year_covered_under_cost_basis_rules")
    private Integer yearCoveredUnderCostBasisRules;

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

    public String getCampo4() {
        return campo4;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    public BigDecimal getExpandedBidPrice() {
        return expandedBidPrice;
    }

    public void setExpandedBidPrice(BigDecimal expandedBidPrice) {
        this.expandedBidPrice = expandedBidPrice;
    }

    public BigDecimal getExpandedAskPrice() {
        return expandedAskPrice;
    }

    public void setExpandedAskPrice(BigDecimal expandedAskPrice) {
        this.expandedAskPrice = expandedAskPrice;
    }

    public BigDecimal getExpandedPreviousDayPrice() {
        return expandedPreviousDayPrice;
    }

    public void setExpandedPreviousDayPrice(BigDecimal expandedPreviousDayPrice) {
        this.expandedPreviousDayPrice = expandedPreviousDayPrice;
    }

    public BigDecimal getExpandedLatestPrice() {
        return expandedLatestPrice;
    }

    public void setExpandedLatestPrice(BigDecimal expandedLatestPrice) {
        this.expandedLatestPrice = expandedLatestPrice;
    }

    public BigDecimal getExpandedEndOfMonthPrice() {
        return expandedEndOfMonthPrice;
    }

    public void setExpandedEndOfMonthPrice(BigDecimal expandedEndOfMonthPrice) {
        this.expandedEndOfMonthPrice = expandedEndOfMonthPrice;
    }

    public BigDecimal getContractShareQuantity() {
        return contractShareQuantity;
    }

    public void setContractShareQuantity(BigDecimal contractShareQuantity) {
        this.contractShareQuantity = contractShareQuantity;
    }

    public Integer getYearCoveredUnderCostBasisRules() {
        return yearCoveredUnderCostBasisRules;
    }

    public void setYearCoveredUnderCostBasisRules(Integer yearCoveredUnderCostBasisRules) {
        this.yearCoveredUnderCostBasisRules = yearCoveredUnderCostBasisRules;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}