package com.skillsup.kirill.springjava.entity;

import javax.persistence.*;
import com.google.common.base.Objects;

/**
 * Created by Kirill on 29.12.2015.
 */

@Entity
@Table(name = "Contacts")
public class MappedContact {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MappedContact that = (MappedContact) o;

        return Objects.equal(this.id, that.id) && Objects.equal(this.name, that.name) && Objects.equal(this.phone, that.phone) && Objects.equal(this.email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(this.id, this.name, this.phone, this.email);
    }

    @Override
    public String toString() {
        return "MapedContact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
