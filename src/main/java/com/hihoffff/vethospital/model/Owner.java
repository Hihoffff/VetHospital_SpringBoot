package com.hihoffff.vethospital.model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private List<String> pets;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public List<String> getPets() {return pets;}
    public void setPets(List<String> pets) {this.pets = pets;}

    public Owner() {
    }
    public Owner(Long id, String name, String phoneNumber, List<String> pets) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pets = pets;
    }
}
