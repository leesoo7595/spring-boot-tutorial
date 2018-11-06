package org.isooproject;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {

    @Id @GeneratedValue
    private long id;

    private String email;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date joined;

}
