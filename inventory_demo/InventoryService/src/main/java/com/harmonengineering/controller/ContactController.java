package com.harmonengineering.controller;
/*==============================================================================
 RESTful CRUD API implementation for inventory demo Contact database

   + HTTP METHOD GET - retrieve all records
   + HTTP METHOD POST - insert new record
   + HTTP METHOD PUT - update existing record
   + HTTP METHOD DELETE - delete record with specific ID

 ================================================================================*/

import com.harmonengineering.entity.ContactRecord;
import com.harmonengineering.entity.ContactRecordRepository;
import com.harmonengineering.inventoryservice.InventoryServiceApplication;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController()
@RequestMapping(value = "${com.harmonengineering.inventoryservice.contact-root}")
@CrossOrigin(origins = "http://localhost:4200",
        methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT } ,
        allowedHeaders = "*", maxAge = 3600 )
//public class ContactController extends BasicRESTfulCrudController<ContactRecord> {
//    public ContactController( ContactRecordRepository contactRepo )
//    {
//        super(contactRepo);
//        this.repository = contactRepo ;
//    }
//} ;
public class ContactController
{
    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceApplication.class);

    private static final XStream xstream = new XStream( ); ;
    private final ContactRecordRepository contactRecordRepository ;
    public ContactController( ContactRecordRepository contactRepo )
    {
        this.contactRecordRepository = contactRepo ;
        // alias to shorten to just the class name without the fullly qualified package name attributes- B>S>H> 1/1/24
        xstream.alias( "contact", ContactRecord.class ) ;
        // alias of a field within the contact record just because we can and it could be useful at some
        // point in the future - B>S>H> 1/1/24
        xstream.aliasField( "name", ContactRecord.class, "contactName" ) ;
        xstream.aliasField( "email", ContactRecord.class, "contactEmail" ) ;
        xstream.aliasField( "phone", ContactRecord.class, "contactPhone" ) ;
        // omission of the ID field from the XML
        xstream.omitField(ContactRecord.class, "ID" ) ;
    }

    //--    /api/driver/ - method GET, return all accounts
    @GetMapping( path="")
    public List<ContactRecord> getAllContacts()

    {
        List<ContactRecord> list = contactRecordRepository.findAll() ;
        StringBuilder stringXml  = new StringBuilder("Contact XML -->");

        for (ContactRecord contactRecord : list)
        {
            stringXml.append("\n");
            stringXml.append(xstream.toXML(contactRecord));

        }
        logger.info(stringXml.toString()) ;
        return list ;
    }

    //--    /api/driver/ - method POST, create a new account with supplied RequestBody
    @PostMapping( path="" )
    public ContactRecord postNewContactRecord( @RequestBody ContactRecord newRecord )
    {
        logger.info( "newRecord >" + newRecord.getContactName() +
                "\nEmail = " + newRecord.getContactEmail() +
                "\nPhone = " + newRecord.getContactPhone()) ;

        //return newRecord ;
        return contactRecordRepository.save(newRecord);
    }

    //--    /api/driver/ - method PUT, update the record with indicated id in RequestBody supplied update data.
    @PutMapping( path="" )
    public ContactRecord updateContact( @RequestBody ContactRecord modifiedRecord )
    {
        logger.info( "modifiedRecord > " + modifiedRecord.getContactName() ) ;
        return contactRecordRepository.save( modifiedRecord ) ;
    }

    //--    /api/driver/ - method DELETE, delete the existing record with id indicated in RequestBody
    @DeleteMapping( path = "" )
    public void deleteDriver( @RequestBody ContactRecord deleteRecord )
    {
        contactRecordRepository.delete( deleteRecord ) ;
    }

    //--    /api/driver/{id} - method GET, return the account with specified id
    @GetMapping( path="{id}")
    public ContactRecord getContactById( @PathVariable Long id )
    {
        Optional<ContactRecord> result = contactRecordRepository.findById( id ) ;

        String stringXml = xstream.toXML( result.orElseThrow() ) ;
        logger.info( "Contact XML -->\n" + stringXml ) ;

        return result.orElseThrow() ;
    }

    //--    /api/driver/{id} - method PUT, update the record having specified id with supplied RequestBody data
    @PutMapping( path="{id}")
    public ContactRecord updateContactRecordWithId( @PathVariable Long id, @RequestBody ContactRecord updateRecord )
    {
        updateRecord.setID( id ) ;
        return contactRecordRepository.save( updateRecord ) ;
    }

    //--    /api/driver/{id} - method DELETE, delete the existing record with the specified id
    @DeleteMapping( path="{id}")
    public void deleteContactById( @PathVariable Long id )
    {
        contactRecordRepository.deleteById( id ) ;
    }
    @PutMapping( path="/export")
    public ContactRecord exportContactRecord( ContactRecord updateRecord )
    {
        String stringXml = xstream.toXML( updateRecord ) ;
        logger.info( stringXml ) ;
        return updateRecord ;
    }
}

