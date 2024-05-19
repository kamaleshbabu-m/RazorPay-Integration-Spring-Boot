package com.example.demo.Bean;



public class payLink {
    private String name;
    private String contact;
    private String email;
    private int amount;
    private String referenceId;

    // Constructors, getters, and setters
    // Note: You can generate getters and setters using your IDE or manually write them

    public payLink() {
    }

    public payLink(String name, String contact, String email,int amount,String referenceId) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.amount=amount;
        this.referenceId=referenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }






    // Getters and setters
}

