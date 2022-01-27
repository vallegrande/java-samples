package dev.jhordycg.sample.jee.tdd.ttdsample.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class Person implements Serializable {
    private Long id;
    private String firstname;
    private String lastname;
    private Date birthdate;
}
