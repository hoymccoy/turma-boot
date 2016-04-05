package org.skh.turma.boot.domain.participant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A ParticipantPropertyGroup.
 */
@Entity(name = "partpropgroup")
public class ParticipantPropertyGroup implements Serializable {

    @Id
    private String name;
    
    @OneToMany(mappedBy = "group")
    @JsonIgnore
    private Set<ParticipantPropertyGroupAssignment> groupAssignments = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ParticipantPropertyGroupAssignment> getGroupAssignments() {
        return groupAssignments;
    }

    public void setGroupAssignments(Set<ParticipantPropertyGroupAssignment> participantPropertyGroupAssignments) {
        this.groupAssignments = participantPropertyGroupAssignments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipantPropertyGroup)) return false;

        ParticipantPropertyGroup that = (ParticipantPropertyGroup) o;

        if (!name.equals(that.name)) return false;
        return groupAssignments.equals(that.groupAssignments);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + groupAssignments.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ParticipantPropertyGroup{" +
                ", name='" + name + '\'' +
                ", groupAssignments=" + groupAssignments +
                '}';
    }
}
