package org.skh.turma.boot.domain.property;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A PropertyDefinition.
 */
@Entity(name="PROPDEF")
public class PropertyDefinition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic(optional = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private PropertyType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyDefinition)) return false;

        PropertyDefinition that = (PropertyDefinition) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PropertyDefinition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
