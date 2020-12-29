package com.springbootcrudfullstackwithmaven.rooms.model;


import javax.persistence.*;

@Entity
@Table(name="OWNER")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ownerId")
    private int ownerId;
    @Column(name = "ownerName")
    private String ownerName;
    @Column(name = "ownerContact")
    private String ownerContact;
    @Column(name = "ownerMail")
    private String ownerMail;
    @Column(name = "location")
    private String location;
    @Column(name = "noOfVacancy")
    private int noOfVacancy;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) {
        this.ownerMail = ownerMail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNoOfVacancy() {
        return noOfVacancy;
    }

    public void setNoOfVacancy(int noOfVacancy) {
        this.noOfVacancy = noOfVacancy;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerContact() {
        return ownerContact;
    }


    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public Owner() {
        super();
    }

    public Owner(int ownerId, String ownerName, String ownerContact, String ownerMail, String location, int noOfVacancy) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerContact = ownerContact;
        this.ownerMail = ownerMail;
        this.location = location;
        this.noOfVacancy = noOfVacancy;
    }


}
