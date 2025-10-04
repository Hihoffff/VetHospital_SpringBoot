package com.hihoffff.vethospital.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Byte age;
    private String type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Owner owner;

    public Owner getOwner() {return owner;}
    public void setOwner(Owner owner) {this.owner = owner;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Byte getAge() {return age;}
    public void setAge(Byte age) {this.age = age;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public Pet() {
    }
    public Pet(Long id, String name, Byte age, String type, Owner owner) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.owner = owner;

    }
}
