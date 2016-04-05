package org.skh.turma.boot.repository;

import org.skh.turma.boot.domain.property.PropertyOwner;
import org.skh.turma.boot.domain.property.Property;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hmc on 03.04.2016.
 */
public interface PropertyRepository extends CrudRepository<Property, Long> {
    List<Property> findByOwner(PropertyOwner owner);
}
