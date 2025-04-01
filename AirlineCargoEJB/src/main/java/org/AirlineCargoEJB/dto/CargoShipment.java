package org.AirlineCargoEJB.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class CargoShipment implements Serializable {
    private String trackingNumber;
    private String status;  // BOOKED, CANCELLED, DELIVERED, etc.
    private List<CargoEvent> eventHistory;

    public CargoShipment() {}

    public CargoShipment(String trackingNumber, String status, List<CargoEvent> eventHistory) {
        this.trackingNumber = trackingNumber;
        this.status = status;
        this.eventHistory = eventHistory;
    }

    // Getters and Setters
    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<CargoEvent> getEventHistory() { return eventHistory; }
    public void setEventHistory(List<CargoEvent> eventHistory) { this.eventHistory = eventHistory; }
}
