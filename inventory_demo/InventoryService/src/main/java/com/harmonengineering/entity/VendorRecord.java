package com.harmonengineering.entity;

import javax.persistence.*;


@Entity
@Table( name="vendor")
public class VendorRecord
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID" )              private Long ID ;
    @Column( name = "name" )            private String vendorName ;
    @Column( name = "phone" )           private String vendorPhone ;
    @Column( name = "address" )           private String vendorAddress ;


    public VendorRecord() {}

    public Long getID() { return ID; }
    public String getVendorName()  { return vendorName; }
    public String getVendorPhone() { return vendorPhone ; }
    public String getVendorAddress() { return vendorAddress; }

    public void setID(Long ID) { this.ID = ID; }
    public void setVendorName(String vendorName)   { this.vendorName = vendorName; }
    public void setVendorPhone(String vendorPhone) { this.vendorPhone = vendorPhone; }
    public void setVendorAddress(String vendorAddress) { this.vendorAddress = vendorAddress; }
}
