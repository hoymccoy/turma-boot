package org.skh.turma.boot.domain.participant;

import org.skh.turma.boot.domain.property.PropertyOwner;
import org.skh.turma.boot.domain.tournament.Tournament;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Participant.
 */
@Entity(name = "participant")
public class Participant extends PropertyOwner implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "tournament")
    private Tournament tournament;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        if (!super.equals(o)) return false;

        Participant that = (Participant) o;

        return getTournament().equals(that.getTournament());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getTournament().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "tournament=" + tournament +
                '}';
    }
}
