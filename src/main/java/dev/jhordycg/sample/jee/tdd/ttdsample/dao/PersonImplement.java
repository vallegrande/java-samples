package dev.jhordycg.sample.jee.tdd.ttdsample.dao;

import dev.jhordycg.sample.jee.tdd.ttdsample.model.Person;

import javax.inject.Inject;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonImplement {
    private final AbstractPersistence persistence;

    @Inject
    public PersonImplement(AbstractPersistence persistence) {
        this.persistence = persistence;
    }

    public int create() throws SQLException {
        try (var connection = persistence.connect()) {
            System.out.println(connection.getClientInfo());
        }
        return 0;
    }

    public List<Person> list() {
        var query = "SELECT * FROM person";
        var people = new ArrayList<Person>();
        try (var conn = persistence.connect()) {
            try (var st = conn.createStatement()) {
                try (var rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        var person = new Person();
                        person.setId(rs.getLong("id"));
                        person.setFirstname(rs.getString("firstname"));
                        person.setLastname(rs.getString("lastname"));
                        person.setBirthdate(rs.getDate("birthdate"));
                    }
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return people;
    }
}