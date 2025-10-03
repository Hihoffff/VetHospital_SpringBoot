package com.hihoffff.vethospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Byte age;
    private String type;
    private Long ownerId;

    public Long getOwnerId() {return ownerId;}
    public void setOwnerId(Long ownerId) {this.ownerId = ownerId;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Byte getAge() {return age;}
    public void setAge(Byte age) {this.age = age;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public Pet() {
    }
    public Pet(Long id, String name, Byte age, String type, Long ownerId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.ownerId = ownerId;

    }
}
