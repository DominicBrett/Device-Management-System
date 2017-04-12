/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Character.isDigit;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author dominic
 */
public class ApplicationModel {
   
 
    
   ArrayList<Device> devices = new ArrayList<Device>();

public void addDevice(String computerName)
{
    int id = devices.size();
    Device device = new Device(computerName, true, id);

    devices.add(device);
}
public void changeAvailabilty(int i)
{
 for(Device device : devices)
 {
     if(device.getId() == i)
     {
         if(device.isAvailable())
         {
             device.setAvailable(false);
         }
         else
         {
             device.setAvailable(true);
         }
     }
 }
}
public String printDevices()
{
    String deviceList = "";
  for (Device device: devices)
  {
      deviceList += device.getId();
      if(device.getId() < 10)
      {
          deviceList += "    ";
      }
      else if (device.getId() < 100)
      {
          deviceList += "  ";
      }
       
      deviceList += device.getComputerName();
      if(device.isAvailable())
      {
          deviceList += "     Available \n";
      }
      else
      {
          deviceList += "   Unavailable \n";
      }
  }
  return deviceList;
}
  BufferedReader infile = null;
    String txtString;
    int i = 0;
    
   public void readDevices(String fileName)
   {
    try {
    infile = new BufferedReader(new FileReader(fileName));
    // Reads first line so while statment dosen't
        txtString = infile.readLine();

        while ((txtString = infile.readLine()) != null) {
            Device device = new Device(txtString, true, devices.size());

            if (device != null) {
                devices.add(device);
                i++;
               
            }
        }
    } 
    catch(IOException e)
      {
          //debugging
          e.printStackTrace();
    }
    finally
    {
        if (infile != null) {
            try {
                infile.close();
           
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   }
   public String printDeviceDetails(int i)
   {
       String output = "";
        for(Device device : devices)
 {
    if(device.getId() == i)
     {
         output += "Device ID : " + device.getId() + "\nDevice Name : " + device.getComputerName() + "\nDevice Description : " + device.getDeviceDetails();
     } 
 }
     return output;
     
   
   }
    
    
private static ApplicationModel instance;
 public static ApplicationModel getInstance() {
        return instance;
    }

   
    public static void setInstance(ApplicationModel instance) {
        ApplicationModel.instance = instance;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */