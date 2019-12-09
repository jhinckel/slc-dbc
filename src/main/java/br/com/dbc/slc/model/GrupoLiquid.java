package br.com.dbc.slc.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.dbc.slc.persistence.PersistentObject;

@Entity
@Table(name = "GRUPO_LIQUIDO")
public class GrupoLiquid extends PersistentObject {

    private static final long serialVersionUID = -989491831531617352L;

    private String dtLiquid;
    private String numSeqCicloLiquid;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection(targetClass = GrupoProdt.class)
    private List<GrupoProdt> grupoProdt;

    @Column(name = "DtLiquid")
    public String getDtLiquid() {
        return dtLiquid;
    }

    public void setDtLiquid(String liquidationDate) {
        this.dtLiquid = liquidationDate;
    }

    @Column(name = "NumSeqCicloLiquid")
    public String getNumSeqCicloLiquid() {
        return numSeqCicloLiquid;
    }

    public void setNumSeqCicloLiquid(String sequenceNumberLiquidationCycle) {
        this.numSeqCicloLiquid = sequenceNumberLiquidationCycle;
    }

    public List<GrupoProdt> getGrupoProdt() {
        if (this.grupoProdt == null) {
            this.grupoProdt = new LinkedList<GrupoProdt>();
        }
        return grupoProdt;
    }

    public void setGrupoProdt(List<GrupoProdt> grupoProdt) {
        this.grupoProdt = grupoProdt;
    }

    @Transient
    public void addGrupoProdt(GrupoProdt grupoProdt) {
        getGrupoProdt().add(grupoProdt);
    }
}
