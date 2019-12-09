package br.com.dbc.slc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DOC")
public class DOC {

    // private String xmlns;
    private BcMsg bcmsg;
    private SisMsg sismsg;

    // @XmlAttribute(name = "xmlns")
    // public String getXmlns() {
    //     return xmlns;
    // }

    // public void setXmlns(String xmlns) {
    //     this.xmlns = xmlns;
    // }

    @XmlElement(name = "BCMSG")
    public BcMsg getBcmsg() {
        return bcmsg;
    }

    public void setBcmsg(BcMsg bcmsg) {
        this.bcmsg = bcmsg;
    }

    @XmlElement(name="SISMSG")
    public SisMsg getSismsg() {
        return sismsg;
    }

    public void setSismsg(SisMsg sismsg) {
        this.sismsg = sismsg;
    }

 }
