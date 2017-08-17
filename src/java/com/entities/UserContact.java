package com.entities;

public class UserContact {
    private int id_user_contact;
    private int id_user;
    private int id_contact;
    private byte isAccepted;

    public int getId_user_contact() {
        return id_user_contact;
    }

    public void setId_user_contact(int id_user_contact) {
        this.id_user_contact = id_user_contact;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_contact() {
        return id_contact;
    }

    public void setId_contact(int id_contact) {
        this.id_contact = id_contact;
    }

    public byte getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(byte isAccepted) {
        this.isAccepted = isAccepted;
    }

    public UserContact(int id_user_contact, int id_user, int id_contact, byte isAccepted) {
        this.id_user_contact = id_user_contact;
        this.id_user = id_user;
        this.id_contact = id_contact;
        this.isAccepted = isAccepted;
    }

    public UserContact() {
    }
    
}
