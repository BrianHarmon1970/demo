package com.harmonengineering.controller;
/*==============================================================================
 RESTful CRUD API implementation for inventory demo Customer database

   + HTTP METHOD GET - retrieve all records
   + HTTP METHOD POST - insert new record
   + HTTP METHOD PUT - update existing record
   + HTTP METHOD DELETE - delete record with specific ID

 ================================================================================*/

import com.harmonengineering.entity.ContactRecordRepository;
import com.harmonengineering.entity.CustomerRecord;
import com.harmonengineering.entity.CustomerRecordRepository;
import com.harmonengineering.inventoryservice.InventoryServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController()
@RequestMapping(value = "${com.harmonengineering.inventoryservice.customer-root}")
@CrossOrigin(origins = "http://localhost:4200",
        methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT } ,
        allowedHeaders = "*", maxAge = 3600 )
public class CustomerController
{
    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceApplication.class);
    private final CustomerRecordRepository recordRepository ;
    public CustomerController( CustomerRecordRepository customerRepo )
    {
        recordRepository = customerRepo ;
    }

    //--    /api/driver/ - method GET, return all accounts
    @GetMapping( path="")
    public List<CustomerRecord> getAllRecords()
    {
    return recordRepository.findAll() ;
    }

//--    /api/driver/ - method POST, create a new account with supplied RequestBody
    @PostMapping( path="" )
    public CustomerRecord postNewDriverRecord( @RequestBody CustomerRecord newRecord )
    {
//        logger.info( "newRecord >" + newRecord.getContactName() +
//                "\nEmail = " + newRecord.getContactEmail() +
//                "\nPhone = " + newRecord.getContactPhone()) ;
//        //return newRecord ;
        return recordRepository.save(newRecord);
    }
    //--    /api/driver/ - method PUT, update the record with indicated id in RequestBody supplied update data.
    @PutMapping( path="" )
    public CustomerRecord updateCustomer( @RequestBody CustomerRecord modifiedRecord )
    {
        //logger.info( "modifiedRecord > " + modifiedRecord.getContactName() ) ;
        return recordRepository.save( modifiedRecord ) ;
    }
    //--    /api/driver/ - method DELETE, delete the existing record with id indicated in RequestBody
    @DeleteMapping( path = "" )
    public void deleteDriver( @RequestBody CustomerRecord deleteRecord )
    {
        recordRepository.delete( deleteRecord ) ;
    }
    //--    /api/driver/{id} - method GET, return the account with specified id
    @GetMapping( path="{id}")
    public CustomerRecord getContactById( @PathVariable Long id )
    {
        Optional<CustomerRecord> result = recordRepository.findById( id ) ;
        return result.orElseThrow() ;
    }
    //--    /api/driver/{id} - method PUT, update the record having specified id with supplied RequestBody data
    //    @PutMapping( path="{id}")
    //    public ENTITY_T updateContactRecordWithId( @PathVariable Long id, @RequestBody ENTITY_T updateRecord )
    //    {
    //        updateRecord.setID( id ) ;
    //        return repository.save( updateRecord ) ;
    //    }
    //--    /api/driver/{id} - method DELETE, delete the existing record with the specified id
    @DeleteMapping( path="{id}")
    public void deleteContactById( @PathVariable Long id )
    {
        recordRepository.deleteById( id ) ;
    }
}

