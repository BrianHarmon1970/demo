package com.harmonengineering.controller;
/*==============================================================================
 GENERIC Template: BasicRESTfulCrudController
     Template for Springboot REST API Controller implementing Create Read Update Delete for
     Generalized record entity definition. Experimental, not yet functional.
     - issues implementing the Autowired Repository bean from Spring library.
        can try manually creating the bean but the automatic 'wiring' can not
        be constructed properly.
 */

import com.harmonengineering.inventoryservice.InventoryServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

class BasicRESTfulCrudController< ENTITY_T>
{

    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceApplication.class);

    JpaRepository<ENTITY_T, Long> repository ;
    public BasicRESTfulCrudController() { }
//    public BasicRESTfulCrudController( JpaRepository<ENTITY_T, Long> basicRepo )
//    {
//        this.repository = basicRepo ;
//    }


    //--    /api/driver/ - method GET, return all accounts
    @GetMapping( path="")
    public List<ENTITY_T> getAllDrivers()
    {
        return repository.findAll() ;
    }

    //--    /api/driver/ - method POST, create a new account with supplied RequestBody
    @PostMapping( path="" )
    public ENTITY_T postNewDriverRecord( @RequestBody ENTITY_T newRecord )
    {
//        logger.info( "newRecord >" + newRecord.getContactName() +
//                "\nEmail = " + newRecord.getContactEmail() +
//                "\nPhone = " + newRecord.getContactPhone()) ;
//        //return newRecord ;
        return repository.save(newRecord);
    }
    //--    /api/driver/ - method PUT, update the record with indicated id in RequestBody supplied update data.
    @PutMapping( path="" )
    public ENTITY_T updateDriver( @RequestBody ENTITY_T modifiedRecord )
    {
        //logger.info( "modifiedRecord > " + modifiedRecord.getContactName() ) ;
        return repository.save( modifiedRecord ) ;
    }
    //--    /api/driver/ - method DELETE, delete the existing record with id indicated in RequestBody
    @DeleteMapping( path = "" )
    public void deleteDriver( @RequestBody ENTITY_T deleteRecord )
    {
        repository.delete( deleteRecord ) ;
    }
    //--    /api/driver/{id} - method GET, return the account with specified id
    @GetMapping( path="{id}")
    public ENTITY_T getContactById( @PathVariable Long id )
    {
        Optional<ENTITY_T> result = repository.findById( id ) ;
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
        repository.deleteById( id ) ;
    }

}
