package org.AirlineCargoEJB.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.jws.WebService;

import org.AirlineCargoEJB.dto.CargoBookingRequest;
import org.AirlineCargoEJB.dto.CargoEvent;
import org.AirlineCargoEJB.dto.CargoShipment;

@Stateless
@WebService(endpointInterface = "com.airlinecargo.service.CargoServiceRemote")
public class CargoServiceImpl implements CargoServiceRemote {
    private static final Map<String, CargoShipment> shipments = new HashMap<>();
    private static int trackingCounter = 1000;

    @Override
    public String bookShipment(CargoBookingRequest request) {
        String trackingNumber = "SLA" + trackingCounter++;
        CargoShipment shipment = new CargoShipment(trackingNumber, "BOOKED", new ArrayList<>());
        shipments.put(trackingNumber, shipment);
        return trackingNumber;
    }

    @Override
    public String getShipmentStatus(String trackingNumber) {
        return shipments.containsKey(trackingNumber) ? shipments.get(trackingNumber).getStatus() : "NOT_FOUND";
    }

    @Override
    public boolean updateShipmentEvent(String trackingNumber, CargoEvent event) {
        if (shipments.containsKey(trackingNumber)) {
            shipments.get(trackingNumber).getEventHistory().add(event);
            shipments.get(trackingNumber).setStatus(event.getEventType());
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelShipment(String trackingNumber) {
        if (shipments.containsKey(trackingNumber) && "BOOKED".equals(shipments.get(trackingNumber).getStatus())) {
            shipments.get(trackingNumber).setStatus("CANCELLED");
            return true;
        }
        return false;
    }

    @Override
    public List<CargoShipment> getShipmentsByShipper(String shipperName) {
        return new ArrayList<>(shipments.values());
    }
}