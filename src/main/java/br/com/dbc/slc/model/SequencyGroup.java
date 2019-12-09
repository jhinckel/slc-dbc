package br.com.dbc.slc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dbc.slc.persistence.PersistentObject;

@Entity
@Table(name = "sequence_group")
@XmlRootElement(name = "Grupo_Seq")
public class SequencyGroup extends PersistentObject {

    private static final long serialVersionUID = 1712522473221530105L;

    private Long sequencyNumber;
    private String indrCont;

    @Column(name = "sequence_number")
    @XmlElement(name = "NumSeq")
    public Long getSequencyNumber() {
        return sequencyNumber;
    }

    public void setSequencyNumber(Long sequencyNumber) {
        this.sequencyNumber = sequencyNumber;
    }

    @Column(name = "indr_counter", length = 100)
    @XmlElement(name = "IndrCont")
    public String getIndrCont() {
        return indrCont;
    }

    public void setIndrCont(String indrCont) {
        this.indrCont = indrCont;
    }

}
