package org.skh.turma.boot.domain.tournament;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skh.turma.boot.domain.export.ExportMappingDefinition;
import org.skh.turma.boot.domain.participant.Participant;
import org.skh.turma.boot.domain.participant.ParticipantPropertyGroup;
import org.skh.turma.boot.domain.property.PropertyFilter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Tournament.
 */
@Entity(name = "tournament")
public class Tournament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "reg_begin", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerBegin;

    @Column(name = "reg_end", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerEnd;

    @Min(value = 1)
    @Column(name = "max_part", nullable = false)
    private Integer maxParticipants;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="form_group")
    private ParticipantPropertyGroup formPropertyGroup;

    @ManyToOne
    @JoinColumn(name="list_group")
    private ParticipantPropertyGroup listPropertyGroup;

    @ManyToOne
    @JoinColumn(name="export_mapping")
    private ExportMappingDefinition exportMapping;

    @OneToMany(mappedBy = "tournament")
    @JsonIgnore
    private Set<Participant> participants = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    private Set<PropertyFilter> groupFilters = new HashSet<>();

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

    public LocalDate getRegisterBegin() {
        return registerBegin;
    }

    public void setRegisterBegin(LocalDate registerBegin) {
        this.registerBegin = registerBegin;
    }

    public LocalDate getRegisterEnd() {
        return registerEnd;
    }

    public void setRegisterEnd(LocalDate registerEnd) {
        this.registerEnd = registerEnd;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public ParticipantPropertyGroup getFormPropertyGroup() {
        return formPropertyGroup;
    }

    public void setFormPropertyGroup(ParticipantPropertyGroup formPropertyGroup) {
        this.formPropertyGroup = formPropertyGroup;
    }

    public ParticipantPropertyGroup getListPropertyGroup() {
        return listPropertyGroup;
    }

    public void setListPropertyGroup(ParticipantPropertyGroup listPropertyGroup) {
        this.listPropertyGroup = listPropertyGroup;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    public Set<PropertyFilter> getGroupFilters() {
        return groupFilters;
    }

    public void setGroupFilters(Set<PropertyFilter> groupFilters) {
        this.groupFilters = groupFilters;
    }

    public ExportMappingDefinition getExportMapping() {
        return exportMapping;
    }

    public void setExportMapping(ExportMappingDefinition exportMapping) {
        this.exportMapping = exportMapping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tournament)) return false;

        Tournament that = (Tournament) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!registerBegin.equals(that.registerBegin)) return false;
        if (!registerEnd.equals(that.registerEnd)) return false;
        if (!maxParticipants.equals(that.maxParticipants)) return false;
        if (!formPropertyGroup.equals(that.formPropertyGroup)) return false;
        if (listPropertyGroup != null ? !listPropertyGroup.equals(that.listPropertyGroup) : that.listPropertyGroup != null)
            return false;
        if (!participants.equals(that.participants)) return false;
        if (exportMapping != null ? !exportMapping.equals(that.exportMapping) : that.exportMapping != null)
            return false;
        return groupFilters.equals(that.groupFilters);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + registerBegin.hashCode();
        result = 31 * result + registerEnd.hashCode();
        result = 31 * result + maxParticipants.hashCode();
        result = 31 * result + formPropertyGroup.hashCode();
        result = 31 * result + (listPropertyGroup != null ? listPropertyGroup.hashCode() : 0);
        result = 31 * result + participants.hashCode();
        result = 31 * result + (exportMapping != null ? exportMapping.hashCode() : 0);
        result = 31 * result + groupFilters.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registerBegin=" + registerBegin +
                ", registerEnd=" + registerEnd +
                ", maxParticipants=" + maxParticipants +
                ", formPropertyGroup=" + formPropertyGroup +
                ", listPropertyGroup=" + listPropertyGroup +
                ", participants=" + participants +
                ", exportMapping=" + exportMapping +
                ", groupFilters=" + groupFilters +
                '}';
    }
}
