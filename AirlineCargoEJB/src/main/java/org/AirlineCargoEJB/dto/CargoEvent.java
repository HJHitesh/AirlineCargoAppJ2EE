package org.AirlineCargoEJB.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement
public class CargoEvent implements Serializable {
    private String trackingNumber;
    private String eventType;  // ARRIVED, DEPARTED, HELD_BY_CUSTOMS, DELIVERED
    private String location;
    private Date timestamp;

    public CargoEvent() {}

    public CargoEvent(String trackingNumber, String eventType, String location, Date timestamp) {
        this.trackingNumber = trackingNumber;
        this.eventType = eventType;
        this.location = location;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
}

