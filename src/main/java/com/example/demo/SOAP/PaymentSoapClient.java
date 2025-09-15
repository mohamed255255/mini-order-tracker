package com.example.demo.SOAP;

import org.springframework.stereotype.Component;
import com.example.demo.DTO.PaymentRequest;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

@Component
public class PaymentSoapClient {

    public void createPaymentRequest(Long orderId, Double amount, String method) throws Exception {
      
        PaymentRequest request = new PaymentRequest();
       
        request.setOrderId(orderId);
        request.setAmount(amount);
        request.setMethod(method);
        request.setStatus("PENDING");

        XMLGregorianCalendar paymentDate = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(new GregorianCalendar());
        request.setPaymentDate(paymentDate);

    }

}

