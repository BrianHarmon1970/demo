package com.harmonengineering.entity;

import javax.persistence.*;

@Entity
@Table( name="driver")
//@EnableTransactionManagement
public class DriverRecord
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID" )              private Long ID ;
    @Column( name = "driver_name" )    private String driverName ;
    @Column( name = "driver_age" ) private Long driverAge ;

    public DriverRecord() {}

    public Long getID() { return ID; }
    public String getDriverName() { return driverName; }
    public Long getDriverAge() { return driverAge; }

    public void setID(Long ID) { this.ID = ID; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public void setDriverAge(Long driverAge) { this.driverAge = driverAge; }
}
