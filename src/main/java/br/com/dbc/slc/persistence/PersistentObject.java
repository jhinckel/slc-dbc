package br.com.dbc.slc.persistence;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class PersistentObject implements Serializable {

    private static final long serialVersionUID = 1652889705049311474L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid = UUID.randomUUID().toString();

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public String getUuid() {
      return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public int hashCode() {
      return uuid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!this.getClass().isInstance(obj)) {
            return false;
        }
        PersistentObject other = (PersistentObject) obj;

        return getUuid().equals(other.getUuid());
    }

}
