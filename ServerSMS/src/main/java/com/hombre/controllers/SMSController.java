package com.hombre.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hombre.model.ConfirmationMessage;
import com.hombre.model.SMS;

@Controller
@RequestMapping("sendsms")
public class SMSController {

//     @RequestMapping(value="sendsms", method = RequestMethod.GET)
//     @ResponseBody
//     public ConfirmationMessage sendMessage(@RequestParam String phoneNumber, @RequestParam String message) throws JsonParseException,
//     JsonMappingException, IOException {
//     String status="KO";
//    
//     if (1==1) {//validate number and message format
//     //send sms
//     System.out.println("SMS message has been sent to the number: "+phoneNumber+" with content" +message);
//     status="OK";
//     } else {
//     System.out.println("SMS message couldn't be sent");
//     }
//     return confirmMessage(status);
//     }
//
//     public ConfirmationMessage confirmMessage(String status){
//     Date date = new Date();
//     BigDecimal price = new BigDecimal(3.50);
//    
//     ObjectMapper mapper = new ObjectMapper();
//     String json = "";
//    
//     ConfirmationMessage message = new ConfirmationMessage(date, status, price);
//    
//     try {
//     json = mapper.writeValueAsString(message);
//     } catch (JsonGenerationException e) {
//     e.printStackTrace();
//     } catch (JsonMappingException e) {
//     e.printStackTrace();
//     } catch (IOException e) {
//     e.printStackTrace();
//     }
//    
//     return message;
//     }

    // With JSON

    @RequestMapping(value = "sendsms", method = RequestMethod.POST)
    @ResponseBody
    public ConfirmationMessage sendMessage(@RequestBody SMS sms) throws JsonParseException, JsonMappingException, IOException {
        String status = "KO";

        if (1 == 1) {// validate number and message format
            // send sms
            System.out.println("SMS message has been sent to the number: " + sms.getPhoneNumber() + " with content: " + sms.getMessage());
            status = "OK";
        } else {
            System.out.println("SMS message couldn't be sent");
        }
        return confirmMessage(status);
    }

    public ConfirmationMessage confirmMessage(String status) {
        Date date = new Date();
        BigDecimal price = new BigDecimal(3.50);

        ObjectMapper mapper = new ObjectMapper();
        String json = "";

        ConfirmationMessage message = new ConfirmationMessage(date, status, price);

        try {
            json = mapper.writeValueAsString(message);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }
}
