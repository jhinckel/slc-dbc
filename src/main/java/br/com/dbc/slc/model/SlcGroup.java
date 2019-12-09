package br.com.dbc.slc.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class SlcGroup {

    private String lineIdentifier;
    private TransactionType transactionType;
    private BigDecimal iSPBIFCredtd;
    private BigDecimal iSPBIFDebtd;
    private BigDecimal reportedValue;
    private String cNPJNLiqdantDebtd;
    private String cNPJNLiqdantCredtd;
    private String nomCliDebtd;
    private String nomCliCredtd;
    private String tpTranscSLC;

    @XmlElement(name = "IdentdLinhaBilat")
    public String getLineIdentifier() {
        return lineIdentifier;
    }

    public void setLineIdentifier(String lineIdentifier) {
        this.lineIdentifier = lineIdentifier;
    }

    @XmlElement(name = "TpDeb_Cred")
    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @XmlElement(name = "ISPBIFCredtd")
    public BigDecimal getiSPBIFCredtd() {
        return iSPBIFCredtd;
    }

    public void setiSPBIFCredtd(BigDecimal iSPBIFCredtd) {
        this.iSPBIFCredtd = iSPBIFCredtd;
    }

    @XmlElement(name = "ISPBIFDebtd")
    public BigDecimal getiSPBIFDebtd() {
        return iSPBIFDebtd;
    }

    public void setiSPBIFDebtd(BigDecimal iSPBIFDebtd) {
        this.iSPBIFDebtd = iSPBIFDebtd;
    }

    @XmlElement(name = "VlrLanc")
    public BigDecimal getReportedValue() {
        return reportedValue;
    }

    public void setReportedValue(BigDecimal reportedValue) {
        this.reportedValue = reportedValue;
    }

    @XmlElement(name = "CNPJNLiqdantDebtd")
    public String getcNPJNLiqdantDebtd() {
        return cNPJNLiqdantDebtd;
    }

    public void setcNPJNLiqdantDebtd(String cNPJNLiqdantDebtd) {
        this.cNPJNLiqdantDebtd = cNPJNLiqdantDebtd;
    }

    @XmlElement(name = "CNPJNLiqdantCredtd")
    public String getcNPJNLiqdantCredtd() {
        return cNPJNLiqdantCredtd;
    }

    public void setcNPJNLiqdantCredtd(String cNPJNLiqdantCredtd) {
        this.cNPJNLiqdantCredtd = cNPJNLiqdantCredtd;
    }

    @XmlElement(name = "NomCliDebtd")
    public String getNomCliDebtd() {
        return nomCliDebtd;
    }

    public void setNomCliDebtd(String nomCliDebtd) {
        this.nomCliDebtd = nomCliDebtd;
    }

    @XmlElement(name = "NomCliCredtd")
    public String getNomCliCredtd() {
        return nomCliCredtd;
    }

    public void setNomCliCredtd(String nomCliCredtd) {
        this.nomCliCredtd = nomCliCredtd;
    }

    @XmlElement(name = "TpTranscSLC")
    public String getTpTranscSLC() {
        return tpTranscSLC;
    }

    public void setTpTranscSLC(String tpTranscSLC) {
        this.tpTranscSLC = tpTranscSLC;
    }

}
