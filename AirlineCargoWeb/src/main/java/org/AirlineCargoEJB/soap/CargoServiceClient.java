package org.AirlineCargoEJB.soap;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.AirlineCargoEJB.dto.CargoBookingRequest;
import org.AirlineCargoEJB.service.CargoServiceRemote;

public class CargoServiceClient {
    public static void main(String[] args) throws Exception {
        URL wsdlURL = new URL("http://localhost:8080/airlinecargo/CargoService?wsdl");
        QName qname = new QName("http://ejb.airlinecargo.com/", "CargoServiceBeanService");
        Service service = Service.create(wsdlURL, qname);
        CargoServiceRemote cargoService = service.getPort(CargoServiceRemote.class);

        CargoBookingRequest request = new CargoBookingRequest();
        request.setShipperName("John Doe");
        request.setConsigneeName("Jane Smith");
        request.setOrigin("New York");
        request.setDestination("Los Angeles");
        request.setWeight(100.5);
     

        String trackingNumber = cargoService.bookShipment(request);
        System.out.println("Shipment booked with tracking number: " + trackingNumber);
    }
}
