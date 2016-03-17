package com.atb.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * Common code for Controllers 
 */
public abstract class BaseController {
    
    static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                String[].class, new StringArrayPropertyEditor(null));
    }

    /**
     * Return json formatted error response for any internal server errors
     * @return ResponseBody
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public String handleException(Exception ex) {
        logger.error("Exception occured", ex);
        final StringBuffer response = new StringBuffer();
        response.append("{\"message\":\"");
        response.append(ex.getMessage());
        response.append("\"}");
        return response.toString();
    }

    /**
     * Return json formatted error response for bad request
     *
     * @return ResponseBody
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ HttpMessageNotReadableException.class })
    @ResponseBody
    public String handleValidationException(HttpMessageNotReadableException ex) throws IOException {
        logger.error("Bad error: ", ex);
        // method called when a input validation failure occurs
        return "{\"message\": \"Invalid Request \"}";
    }

}
