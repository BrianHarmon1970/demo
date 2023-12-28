package com.harmonengineering.entity;

import javax.persistence.*;

@Entity
@Table( name="customer")
public class CustomerRecord
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID" )              private Long ID ;
    @Column( name = "name" )            private String customerName ;
    @Column( name = "phone" )           private String customerPhone ;
    @Column( name = "address" )           private String customerAddress ;

    public CustomerRecord() {}

    public Long getID() { return ID; }
    public String getCustomerName()  { return customerName; }
    public String getCustomerPhone() { return customerPhone ; }
    public String getCustomerAddress() { return customerAddress; }

    public void setID(Long ID) { this.ID = ID; }
    public void setCustomerName(String customerName)   { this.customerName = customerName; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }
}
