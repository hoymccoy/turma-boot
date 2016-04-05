package org.skh.turma.boot.domain.export;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by hmc on 02.04.2016.
 */
@Entity
public class ExportMappingDefinition implements Serializable {

    @Id
    private String name;

    @ManyToMany
    private Set<PropertyExportMapping> mappings;
}
