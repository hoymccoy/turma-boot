package org.skh.turma.boot.domain;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.skh.turma.boot.Application;
import org.skh.turma.boot.repository.PropertyDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hmc on 03.04.2016.
 */
@TestExecutionListeners({ DbUnitTestExecutionListener.class})
@SpringApplicationConfiguration(classes = Application.class)
@DatabaseSetup(PropertyDefinitionRepositoryIT.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { PropertyDefinitionRepositoryIT.DATASET })
@DirtiesContext
public class PropertyDefinitionRepositoryIT extends AbstractTransactionalJUnit4SpringContextTests {
    protected static final String DATASET = "classpath:datasets/it-propertydefinitions.xml";

    @Autowired
    private PropertyDefinitionRepository repository;

    @Test
    public void dummyTest() {
        assertThat(repository.findAll()).hasSize(3);
    }
}
