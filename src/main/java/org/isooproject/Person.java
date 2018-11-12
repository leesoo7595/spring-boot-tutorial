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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }
}
