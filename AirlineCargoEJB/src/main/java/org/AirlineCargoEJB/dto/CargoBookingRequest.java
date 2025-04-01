package org.AirlineCargoEJB.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class CargoBookingRequest implements Serializable {
    private String shipperName;
    private String consigneeName;
    private String origin;
    private String destination;
    private double weight;

    // Default constructor (required for JAXB)
    public CargoBookingRequest() {}

    public CargoBookingRequest(String shipperName, String consigneeName, String origin, String destination, double weight) {
        this.shipperName = shipperName;
        this.consigneeName = consigneeName;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    // Getters and Setters
    public String getShipperName() { return shipperName; }
    public void setShipperName(String shipperName) { this.shipperName = shipperName; }

    public String getConsigneeName() { return consigneeName; }
    public void setConsigneeName(String consigneeName) { this.consigneeName = consigneeName; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

	public void setDeclaredValue(int i) {
		// TODO Auto-generated method stub
		
	}
}