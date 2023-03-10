package org.crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "specialty")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String specName;
    @Column(name = "statusId")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Integer getId() {
        return id;
    }

    public String getSpecName() {
        return specName;
    }

    public Status getStatus() {
        return status;
    }

    public Specialty() {

    }

    public Specialty(Integer id, String name) {
        this.id = id;
        this.specName = name;
        this.status = Status.ACTIVE;
    }



    public void setId(Integer id) {
        this.id = id;
    }


    public void setSpecName(String name) {
        this.specName = name;
    }



    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", name=" + specName +
                ", status'" +status+ '\'' +
                '}';
    }
}