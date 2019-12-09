package br.com.dbc.slc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.dbc.slc.persistence.PersistentObject;

@Entity
@Table(name = "BCMSG")
@XmlRootElement(name = "BCMSG")
@EntityListeners(AuditingEntityListener.class)
public class BcMsg extends PersistentObject {

    private static final long serialVersionUID = -2547687561435108998L;

    private String identdEmissor;
    private String identdDestinatario;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection(targetClass = SequencyGroup.class)
    private Set<SequencyGroup> sequencyGroups;
    private String domSist;
    private String nUOp;

    @NotNull
    @Column(name = "emitter")
    @XmlElement(name = "IdentdEmissor")
    public String getIdentdEmissor() {
        return identdEmissor;
    }

    public void setIdentdEmissor(String emitterIdentity) {
        this.identdEmissor = emitterIdentity;
    }

    @NotNull
    @Column(name = "receiver")
    @XmlElement(name = "IdentdDestinatario")
    public String getIdentdDestinatario() {
        return identdDestinatario;
    }

    public void setIdentdDestinatario(String receiverIdentity) {
        this.identdDestinatario = receiverIdentity;
    }

    @XmlElement(name = "Grupo_Seq")
    public Set<SequencyGroup> getSequencyGroups() {
        return sequencyGroups;
    }

    public void setSequencyGroups(Set<SequencyGroup> sequencyGroups) {
        this.sequencyGroups = sequencyGroups;
    }

    @Column(name = "dom_sist")
    @XmlElement(name = "DomSist")
    public String getDomSist() {
        return domSist;
    }

    public void setDomSist(String domSist) {
        this.domSist = domSist;
    }

    @NotNull
    @Column(name = "operation_number")
    @XmlElement(name = "NUOp")
    public String getnUOp() {
        return nUOp;
    }

    public void setnUOp(String operationNumber) {
        this.nUOp = operationNumber;
    }

}
