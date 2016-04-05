package org.skh.turma.boot.domain.property;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A ParticipantProperty.
 */
@Entity(name="PROP")
public class Property implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "string_val")
    private String stringValue;
    @Column(name = "int_val")
    private Integer intValue;
    @Column(name = "date_val")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateValue;

    @ManyToOne
    @JoinColumn(name = "owner")
    private PropertyOwner owner;

    @ManyToOne(optional = false)
    @JoinColumn(name = "definition")
    private PropertyDefinition definition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public PropertyOwner getOwner() {
        return owner;
    }

    public void setOwner(PropertyOwner owner) {
        this.owner = owner;
    }

    public LocalDate getDateValue() {
        return dateValue;
    }

    public void setDateValue(LocalDate dateValue) {
        this.dateValue = dateValue;
    }

    public PropertyDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(PropertyDefinition definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;

        Property that = (Property) o;

        if (!id.equals(that.id)) return false;
        if (stringValue != null ? !stringValue.equals(that.stringValue) : that.stringValue != null) return false;
        if (intValue != null ? !intValue.equals(that.intValue) : that.intValue != null) return false;
        if (dateValue != null ? !dateValue.equals(that.dateValue) : that.dateValue != null) return false;
        if (!owner.equals(that.owner)) return false;
        return definition.equals(that.definition);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (stringValue != null ? stringValue.hashCode() : 0);
        result = 31 * result + (intValue != null ? intValue.hashCode() : 0);
        result = 31 * result + (dateValue != null ? dateValue.hashCode() : 0);
        result = 31 * result + owner.hashCode();
        result = 31 * result + definition.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ParticipantProperty{" +
                "id=" + id +
                ", stringValue='" + stringValue + '\'' +
                ", intValue=" + intValue +
                ", dateValue=" + dateValue +
                ", owner=" + owner +
                ", definition=" + definition +
                '}';
    }
}
