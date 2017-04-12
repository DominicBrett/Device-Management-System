/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dominic
 */
public class Device {
    private String computerName;
    private boolean available;
    private int id;
     private String deviceDetails;


    Device(String computerName, boolean available, int id) {
     this.id = id;
        
     this.available = available;
     
     String computerDetails[] = computerName.split(",");
     this.computerName = computerDetails[0];
     this.deviceDetails = computerDetails[1];
    }

  

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
      public String getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(String deviceDetails) {
        this.deviceDetails = deviceDetails;
    }
    
}
