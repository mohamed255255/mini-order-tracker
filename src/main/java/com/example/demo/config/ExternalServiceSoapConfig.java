package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


///specifying the config for the (clients) who want to link with my service 
@Configuration
@EnableWs
public class ExternalServiceSoapConfig {
    /// .WSDL is an document or file.WSDL that is sent in this URL created from the XSD
    ///  and more data like port and namespace are added to it it 
    @Bean
    public DefaultWsdl11Definition calculatorServiceDefinition() {
        DefaultWsdl11Definition wsdlDefinition = new DefaultWsdl11Definition();
        wsdlDefinition.setPortTypeName("paymentServicePort");
        wsdlDefinition.setLocationUri("/ws");
        wsdlDefinition.setTargetNamespace("http://bank/payment");
        wsdlDefinition.setSchema(orderServiceSchema());
        return wsdlDefinition;
    }

    //// XML schema  loader
    @Bean
    public XsdSchema orderServiceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("payment.xsd"));
    }


}
