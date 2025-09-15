package com.example.demo.SOAP;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.DTO.PaymentRequest;
import com.example.demo.DTO.PaymentResponse;

@Endpoint
public class ExternalServiceSimulator {
    
    
    @PayloadRoot(namespace = "http://payment", localPart = "PaymentRequest")
    @ResponsePayload
    
    public PaymentResponse processPayment(@RequestPayload  PaymentRequest request) throws Exception {
        PaymentResponse response = new PaymentResponse();
        
        response.setOrderId(request.getOrderId());
        response.setAmount(request.getAmount());
        response.setMethod(request.getMethod());
        response.setStatus("SUCCESS"); 
        XMLGregorianCalendar paymentDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        response.setPaymentDate(paymentDate);
       
        return response;
    }
}
