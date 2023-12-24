package com.harmonengineering.controller;


import com.harmonengineering.driver_demo.DriverDemoApplication;

import com.harmonengineering.entity.DriverRecordRepository;
import com.harmonengineering.entity.DriverRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(value = "${com.harmonengineering.driver_demo.driver-root}")

@CrossOrigin(origins = "http://localhost:4200",
        methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT } ,
        allowedHeaders = "*", maxAge = 3600 )

public class DriverController
{
    private static final Logger logger = LoggerFactory.getLogger(DriverDemoApplication.class);

    private DriverRecordRepository driverRecordRepository ;
    public DriverController( DriverRecordRepository driverRepo )
    {
        this.driverRecordRepository = driverRepo ;
    }

    //--    /api/driver/ - method GET, return all accounts
    @GetMapping( path="")
    public List<DriverRecord> getAllDrivers()
    {
        return driverRecordRepository.findAll() ;
    }

    //--    /api/driver/ - method POST, create a new account with supplied RequestBody
    @PostMapping( path="" )
    public DriverRecord postNewDriverRecord( @RequestBody DriverRecord newRecord )
    {
        logger.info( "newRecord >" + newRecord.getDriverName() +
                "\ndriverAge = " + newRecord.getDriverAge()) ;
        //return newRecord ;
        return driverRecordRepository.save(newRecord);
    }
    //--    /api/driver/ - method PUT, update the record with indicated id in RequestBody supplied update data.
    @PutMapping( path="" )
    public DriverRecord updateDriver( @RequestBody DriverRecord modifiedRecord )
    {
        logger.info( "modifiedRecord > " + modifiedRecord.getDriverName() ) ;
        return driverRecordRepository.save( modifiedRecord ) ;
    }
    //--    /api/driver/ - method DELETE, delete the existing record with id indicated in RequestBody
    @DeleteMapping( path = "" )
    public void deleteDriver( @RequestBody DriverRecord deleteRecord )
    {
        driverRecordRepository.delete( deleteRecord ) ;
    }
    //--    /api/driver/{id} - method GET, return the account with specified id
    @GetMapping( path="{id}")
    public DriverRecord getAccountById( @PathVariable Long id )
    {
        Optional<DriverRecord> result = driverRecordRepository.findById( id ) ;
        return result.orElseThrow() ;
    }
    //--    /api/driver/{id} - method PUT, update the record having specified id with supplied RequestBody data
    @PutMapping( path="{id}")
    public DriverRecord updateDriverRecordWithId( @PathVariable Long id, @RequestBody DriverRecord updateRecord )
    {
        updateRecord.setID( id ) ;
        return driverRecordRepository.save( updateRecord ) ;
    }
    //--    /api/driver/{id} - method DELETE, delete the existing record with the specified id
    @DeleteMapping( path="{id}")
    public void deleteDriverById( @PathVariable Long id )
    {
        driverRecordRepository.deleteById( id ) ;
    }

}
