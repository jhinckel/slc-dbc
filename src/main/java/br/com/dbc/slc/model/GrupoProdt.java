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
@Table(name = "GRUPO_PRODUTO")
public class GrupoProdt extends PersistentObject {

    private static final long serialVersionUID = 8095678372206866052L;

    private String codProdt;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection(targetClass = GrupoLiquidProdt.class)
    private List<GrupoLiquidProdt> grupoLiquidProdt;

    @Column(name = "CodProdt")
    public String getCodProdt() {
        return codProdt;
    }

    public void setCodProdt(String codProdt) {
        this.codProdt = codProdt;
    }

    public List<GrupoLiquidProdt> getGrupoLiquidProdt() {
        if (this.grupoLiquidProdt == null) {
            this.grupoLiquidProdt = new LinkedList<GrupoLiquidProdt>();
        }
        return grupoLiquidProdt;
    }

    public void setGrupoLiquidProdt(List<GrupoLiquidProdt> grupoLiquidProdt) {
        this.grupoLiquidProdt = grupoLiquidProdt;
    }

    @Transient
    public void addGrupoLiquidProdt(GrupoLiquidProdt grupoLiquidProdt) {
        getGrupoLiquidProdt().add(grupoLiquidProdt);
    }

}
