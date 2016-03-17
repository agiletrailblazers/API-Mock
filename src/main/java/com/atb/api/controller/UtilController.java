package com.atb.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class UtilController extends BaseController {

    static final Logger logger = LoggerFactory.getLogger(UtilController.class);

    @Value("${property.name}")
    private String propertyName;

    @Value("${loans.json}")
    private String loans;
    
    /**
     * A simple "is alive" API.
     *
     * @return Empty response with HttpStatus of OK
     * @throws Exception
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> ping() throws Exception {
        logger.trace("Service ping initiated");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * A simple API to tell us which environment it is 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/env", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String env() throws Exception {
        logger.info("Service env initiated");
        return propertyName;
    }
    
    @RequestMapping(value = "/loans", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getLoansDelinquent(@RequestParam String status) throws Exception {
        logger.info("Loans: " + status);
        return loans;
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/loans/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateLoan(@PathVariable("id") String id, @RequestBody String loadBody) throws Exception {
        logger.info("Update to load id: " + id);
    }
    
}
