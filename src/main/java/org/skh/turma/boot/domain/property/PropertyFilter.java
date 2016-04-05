package org.skh.turma.boot.domain.property;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A PropertyFilter.
 */
@Entity
public class PropertyFilter extends PropertyOwner implements Serializable {

    @Basic(optional = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private PropertyFilterRule rule;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public PropertyFilterRule getRule() {
        return rule;
    }
    
    public void setRule(PropertyFilterRule rule) {
        this.rule = rule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyFilter)) return false;
        if (!super.equals(o)) return false;

        PropertyFilter that = (PropertyFilter) o;

        if (!getName().equals(that.getName())) return false;
        return getRule() == that.getRule();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getRule().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PropertyFilter{" +
                "name='" + name + '\'' +
                ", rule=" + rule +
                '}';
    }
}
