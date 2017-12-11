package com.unico.gcdrswebservice.controller;

import com.unico.gcdrswebservice.domain.GCD;
import com.unico.gcdrswebservice.exception.ErrorResponse;
import com.unico.gcdrswebservice.exception.GCDException;
import com.unico.gcdrswebservice.mqpublisher.Publisher;
import com.unico.gcdrswebservice.service.GCDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class contains all the logic for handling GCD applications
 * @Operations: pushGCD_DB_MQ, getGCDList
 * @Developer: Vikas Malviya
 */


@RestController
@RequestMapping("/gcds")
public class WebController {

    private static final Logger logger = Logger.getLogger(WebController.class.getName());
    private GCDService gcdService;

    @Autowired
    Publisher publisher;

    @Autowired
    public WebController(GCDService gcdService) {
        this.gcdService = gcdService;
    }

    /**
     * The following operation add GCD list to the Queue and Database
     *
     * @Input - firstOperand, secondOperand
     * @Response - Success/Failure response
     * @Exception - this method returns GCDException exception
     */

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public GCD pushGCD_DB_MQ(@RequestBody GCD gcd) throws GCDException {
        String response = null;

        if (logger.isLoggable(Level.INFO)) {
            logger.info("GCDRestServiceImpl->pushGCD recevied request");
        }

        if (gcd.getFirstOperand() >= 0 && gcd.getSecondOperand() >= 0) {

            publisher.produceMsg(gcd);
            System.out.println("publisher job done");
            return gcdService.pushGCD_DB_MQ(gcd);


        } else {
            logger.log(Level.SEVERE, "GCDRestServiceImpl->pushGCD-> Error occurred while processing request -> invalid input received - firstOperand : " + gcd.getFirstOperand() + " & secondOperand : " + gcd.getSecondOperand());
            throw new GCDException("Invalid input received, No valid input provided.");
        }


    }


    @RequestMapping(value = "/gcdList", method = RequestMethod.GET)
    public Iterable<GCD> getGCDList() {
        return gcdService.fetchGCDList();
    }


    /**
     * The following operation handles exception thrown by GCDException
     *
     * @Input - Exception
     * @Response - ResponseEntity
     * @Exception - N/A
     */

    @ExceptionHandler(GCDException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }


}