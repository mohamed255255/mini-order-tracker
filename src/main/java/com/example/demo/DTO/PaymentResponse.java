package com.example.demo.DTO;

import javax.xml.datatype.XMLGregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PaymentRequest", namespace = "http://payment")
@XmlAccessorType(XmlAccessType.FIELD)

public class PaymentResponse {

    private String method;
    private Double amount;
    private String status;
    private XMLGregorianCalendar paymentDate;
    private Long orderId;



    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public XMLGregorianCalendar getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(XMLGregorianCalendar paymentDate) {
        this.paymentDate = paymentDate;
    }
}
