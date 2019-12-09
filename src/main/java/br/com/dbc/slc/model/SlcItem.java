package br.com.dbc.slc.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.dbc.slc.persistence.PersistentObject;

@Entity
@Table(name = "SLC")
public class SlcItem extends PersistentObject {

    private static final long serialVersionUID = -2651970924141575126L;

    private String codMsg;
    private String numCtrlSLC;
    private String iSPBIF;
    private String tpInf;
    private String dtHrSLC;
    private String dtMovto;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection(targetClass = GrupoLiquid.class)
    private List<GrupoLiquid> grupoLiquid;

    public String getCodMsg() {
        return codMsg;
    }

    public void setCodMsg(String messageCode) {
        this.codMsg = messageCode;
    }

    public String getNumCtrlSLC() {
        return numCtrlSLC;
    }

    public void setNumCtrlSLC(String slcControlNumber) {
        this.numCtrlSLC = slcControlNumber;
    }

    public String getISPBIF() {
        return iSPBIF;
    }

    public void setISPBIF(String iSPBIF) {
        this.iSPBIF = iSPBIF;
    }

    public String getTpInf() {
        return tpInf;
    }

    public void setTpInf(String informationType) {
        this.tpInf = informationType;
    }

    public String getDtHrSLC() {
        return dtHrSLC;
    }

    public void setDtHrSLC(String slcTime) {
        this.dtHrSLC = slcTime;
    }

    public String getDtMovto() {
        return dtMovto;
    }

    public void setDtMovto(String movimentationDate) {
        this.dtMovto = movimentationDate;
    }

    public List<GrupoLiquid> getGrupoLiquid() {
        if (this.grupoLiquid == null) {
            this.grupoLiquid = new LinkedList<GrupoLiquid>();
        }
        return grupoLiquid;
    }

    public void setGrupoLiquid(List<GrupoLiquid> grupoLiquid) {
        this.grupoLiquid = grupoLiquid;
    }

    @Transient
    public void addGrupoLiquid(GrupoLiquid grupoLiquid) {
        getGrupoLiquid().add(grupoLiquid);
    }

}
