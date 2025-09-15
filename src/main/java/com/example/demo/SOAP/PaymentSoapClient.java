package com.example.demo.SOAP;

import com.example.demo.DTO.PaymentRequest;
import com.example.demo.DTO.PaymentResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

@Component
public class PaymentSoapClient {

    private final WebServiceTemplate webServiceTemplate;

    public PaymentSoapClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    
    public PaymentResponse createPaymentRequest(Long orderId, Double amount, String method) throws Exception {

        PaymentRequest request = new PaymentRequest();
        request.setOrderId(orderId);
        request.setAmount(amount);
        request.setMethod(method);
        request.setStatus("PENDING");

        XMLGregorianCalendar paymentDate =
                DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        request.setPaymentDate(paymentDate);

        // Call the remote SOAP service and cast the response
        return (PaymentResponse) webServiceTemplate.marshalSendAndReceive(request);
    }
}
