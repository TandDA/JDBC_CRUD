package org.crud.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "developer")
public class Developer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    Set skills;
    Specialty specialty;
    @Column(name = "statusId")
    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.ACTIVE;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set getSkills() {
        return skills;
    }


    public Developer(){

    };

    public Developer(int id, String firstName, String lastName, Set skills, Specialty specialty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.status = Status.ACTIVE;
        this.specialty = specialty;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSkills(Set skill) {
        this.skills = skill;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName +
                ", lastName" + lastName +
                ", Skills" + skills  +
                ", Specialty" + specialty +
                ", status'" +status+ '\'' +
                '}';
    }
}