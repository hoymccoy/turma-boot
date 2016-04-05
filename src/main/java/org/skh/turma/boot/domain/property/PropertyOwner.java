package org.skh.turma.boot.domain.property;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hmc on 02.04.2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PropertyOwner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private Set<Property> properties = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyOwner)) return false;

        PropertyOwner that = (PropertyOwner) o;

        if (!getId().equals(that.getId())) return false;
        return getProperties().equals(that.getProperties());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getProperties().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PropertyOwner{" +
                "id=" + id +
                ", properties=" + properties +
                '}';
    }
}
