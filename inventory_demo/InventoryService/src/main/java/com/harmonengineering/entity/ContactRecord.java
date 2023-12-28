package com.harmonengineering.entity;

import javax.persistence.*;

@Entity
@Table( name="contact")
public class ContactRecord
{
    @Id   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID" )              private Long ID ;
    @Column( name = "name" )            private String contactName ;
    @Column( name = "email" )           private String contactEmail ;
    @Column( name = "phone" )           private String contactPhone ;


    public ContactRecord() {}

    public Long getID() { return ID; }
    public String getContactName()  { return contactName; }
    public String getContactEmail() { return contactEmail; }
    public String getContactPhone() { return contactPhone ; }

    public void setID(Long ID) { this.ID = ID; }
    public void setContactName(String contactName)   { this.contactName = contactName; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

}
