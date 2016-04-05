package org.skh.turma.boot.domain.participant;

import org.skh.turma.boot.domain.property.PropertyDefinition;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A ParticipantPropertyGroupAssignment.
 */
@Entity
public class ParticipantPropertyGroupAssignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Boolean optional;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Integer position;

    @ManyToOne(optional = false)
    private PropertyDefinition definition;

    @ManyToOne(optional = false)
    private ParticipantPropertyGroup group;

    public PropertyDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(PropertyDefinition definition) {
        this.definition = definition;
    }

    public ParticipantPropertyGroup getGroup() {
        return group;
    }

    public void setGroup(ParticipantPropertyGroup group) {
        this.group = group;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipantPropertyGroupAssignment)) return false;

        ParticipantPropertyGroupAssignment that = (ParticipantPropertyGroupAssignment) o;

        if (!id.equals(that.id)) return false;
        if (!getOptional().equals(that.getOptional())) return false;
        if (!getPosition().equals(that.getPosition())) return false;
        if (!getDefinition().equals(that.getDefinition())) return false;
        return getGroup().equals(that.getGroup());

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + getOptional().hashCode();
        result = 31 * result + getPosition().hashCode();
        result = 31 * result + getDefinition().hashCode();
        result = 31 * result + getGroup().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ParticipantPropertyGroupAssignment{" +
                "id=" + id +
                ", optional=" + optional +
                ", position=" + position +
                ", definition=" + definition +
                ", group=" + group +
                '}';
    }
}

