package br.com.dbc.slc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.dbc.slc.persistence.PersistentObject;

@Entity
@Table(name = "DRUPO_LIQUIDO_PRODUTO")
public class GrupoLiquidProdt extends PersistentObject {

    private static final long serialVersionUID = 880091954522392252L;

    private String IdentdLinhaBilat;
    private String TpDeb_Cred;
    private String ISPBIFCredtd;
    private String ISPBIFDebtd;
    private String VlrLanc;
    private String CNPJNLiqdantDebtd;
    private String NomCliDebtd;
    private String CNPJNLiqdantCredtd;
    private String NomCliCredtd;
    private String TpTranscSLC;

    @Column(name = "IdentdLinhaBilat")
    public String getIdentdLinhaBilat() {
        return IdentdLinhaBilat;
    }

    public void setIdentdLinhaBilat(String identdLinhaBilat) {
        IdentdLinhaBilat = identdLinhaBilat;
    }

    @Column(name = "TpDeb_Cred")
    public String getTpDeb_Cred() {
        return TpDeb_Cred;
    }

    public void setTpDeb_Cred(String tpDeb_Cred) {
        TpDeb_Cred = tpDeb_Cred;
    }

    @Column(name = "ISPBIFCredtd")
    public String getISPBIFCredtd() {
        return ISPBIFCredtd;
    }

    public void setISPBIFCredtd(String iSPBIFCredtd) {
        ISPBIFCredtd = iSPBIFCredtd;
    }

    @Column(name = "ISPBIFDebtd")
    public String getISPBIFDebtd() {
        return ISPBIFDebtd;
    }

    public void setISPBIFDebtd(String iSPBIFDebtd) {
        ISPBIFDebtd = iSPBIFDebtd;
    }

    @Column(name = "VlrLanc")
    public String getVlrLanc() {
        return VlrLanc;
    }

    public void setVlrLanc(String vlrLanc) {
        VlrLanc = vlrLanc;
    }

    @Column(name = "CNPJNLiqdantDebtd")
    public String getCNPJNLiqdantDebtd() {
        return CNPJNLiqdantDebtd;
    }

    public void setCNPJNLiqdantDebtd(String cNPJNLiqdantDebtd) {
        CNPJNLiqdantDebtd = cNPJNLiqdantDebtd;
    }

    @Column(name = "NomCliDebtd")
    public String getNomCliDebtd() {
        return NomCliDebtd;
    }

    public void setNomCliDebtd(String nomCliDebtd) {
        NomCliDebtd = nomCliDebtd;
    }

    @Column(name = "CNPJNLiqdantCredtd")
    public String getCNPJNLiqdantCredtd() {
        return CNPJNLiqdantCredtd;
    }

    public void setCNPJNLiqdantCredtd(String cNPJNLiqdantCredtd) {
        CNPJNLiqdantCredtd = cNPJNLiqdantCredtd;
    }

    @Column(name = "NomCliCredtd")
    public String getNomCliCredtd() {
        return NomCliCredtd;
    }

    public void setNomCliCredtd(String nomCliCredtd) {
        NomCliCredtd = nomCliCredtd;
    }

    @Column(name = "TpTranscSLC")
    public String getTpTranscSLC() {
        return TpTranscSLC;
    }

    public void setTpTranscSLC(String tpTranscSLC) {
        TpTranscSLC = tpTranscSLC;
    }

}
