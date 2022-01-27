package dev.jhordycg.sample.jee.tdd.ttdsample.dao;

import com.github.database.rider.core.DBUnitRule;
import com.github.database.rider.core.api.dataset.DataSet;
import org.h2.tools.RunScript;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
class PersonImplementTest {

    @Rule
    private final AbstractPersistence persistence = new H2Persistence();
    @Rule
    private final PersonImplement personImplement = new PersonImplement(persistence);
    @Rule
    private final DBUnitRule dbUnitRule = DBUnitRule.instance(persistence.connect());

    PersonImplementTest() throws SQLException {
    }

    @BeforeAll
    static void setup() throws SQLException, FileNotFoundException {
        var schemaFile = Objects.requireNonNull(PersonImplementTest.class.getResource("/schema-person.sql")).getPath();
        RunScript.execute(new H2Persistence().connect(), new FileReader(schemaFile));
    }

    @Test
    @DataSet(value = "data-person.csv", cleanBefore = true)
    void testCreate() throws Exception {
        var people = personImplement.list();
        assertEquals(1, people.size());
    }
}