
/* package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.SOAP.PaymentSoapClient;

@RestController
@Tag(name = "Payment", description = "This is the payment endpoint which interacts with the SOAP service")

public class PaymentController {
    
    private final PaymentSoapClient paymentSoapClient;

    @Autowired
    public PaymentController(PaymentSoapClient paymentSoapClient) {
        this.paymentSoapClient = paymentSoapClient;
    }

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@RequestParam Long orderId,
                               @RequestParam Double amount,
                               @RequestParam String method) throws Exception {

         paymentSoapClient.createPaymentRequest(orderId, amount, method);
         return ResponseEntity.ok("Payment request created for Order ID: " + orderId);
    }
}
*/