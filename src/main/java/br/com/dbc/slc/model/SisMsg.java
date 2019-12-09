package br.com.dbc.slc.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.dbc.slc.persistence.PersistentObject;

@Entity
@Table(name = "SISMSG")
@XmlRootElement(name = "SISMSG")
public class SisMsg extends PersistentObject {

    private static final long serialVersionUID = -2978983075937559444L;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection(targetClass = SlcItem.class)
    private List<SlcItem> slcItems;
    @Transient
    private List<JAXBElement<Object>> slcItem;

    @XmlTransient
    public List<SlcItem> getSlcItems() {
        if (this.slcItems == null) {
            this.slcItems = new LinkedList<SlcItem>();
        }
        return slcItems;
    }

    public void setSlcItems(List<SlcItem> slcItems) {
        this.slcItems = slcItems;
    }

    @Transient
    public void addSlcItem(SlcItem item) {
        getSlcItems().add(item);
    }

    @XmlAnyElement
    public List<JAXBElement<Object>> getSlcItem() {
        return slcItem;
    }

    public void setSlcItem(List<JAXBElement<Object>> slcItem) {
        this.slcItem = slcItem;
    }

}
