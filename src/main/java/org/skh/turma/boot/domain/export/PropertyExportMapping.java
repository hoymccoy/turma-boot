package org.skh.turma.boot.domain.export;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hmc on 02.04.2016.
 */
@Entity
public class PropertyExportMapping implements Serializable {

    @Id
    private String name;

    @Basic(optional = false)
    private String valueQuery;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private ExportTarget target;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueQuery() {
        return valueQuery;
    }

    public void setValueQuery(String valueQuery) {
        this.valueQuery = valueQuery;
    }

    public ExportTarget getTarget() {
        return target;
    }

    public void setTarget(ExportTarget target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyExportMapping)) return false;

        PropertyExportMapping that = (PropertyExportMapping) o;

        if (!getName().equals(that.getName())) return false;
        if (!getValueQuery().equals(that.getValueQuery())) return false;
        return getTarget() == that.getTarget();

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getValueQuery().hashCode();
        result = 31 * result + getTarget().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PropertyExportMapping{" +
                "name='" + name + '\'' +
                ", valueQuery='" + valueQuery + '\'' +
                ", target=" + target +
                '}';
    }
}
