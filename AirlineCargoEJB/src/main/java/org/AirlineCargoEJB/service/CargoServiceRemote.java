package org.AirlineCargoEJB.service;

import java.util.List;

import javax.ejb.Remote;

import org.AirlineCargoEJB.dto.CargoBookingRequest;
import org.AirlineCargoEJB.dto.CargoEvent;
import org.AirlineCargoEJB.dto.CargoShipment;

@Remote
public interface CargoServiceRemote {
    String bookShipment(CargoBookingRequest request);
    String getShipmentStatus(String trackingNumber);
    boolean updateShipmentEvent(String trackingNumber, CargoEvent event);
    boolean cancelShipment(String trackingNumber);
    List<CargoShipment> getShipmentsByShipper(String shipperName);
}
