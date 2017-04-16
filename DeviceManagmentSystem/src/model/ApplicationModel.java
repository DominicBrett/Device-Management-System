/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Character.isDigit;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author dominic
 */
public class ApplicationModel {
   
 
    
   ArrayList<Device> devices = new ArrayList<Device>();
   List<String> deviceData = new ArrayList<String>();

public void addDevice(String computerName)
{
    int id = devices.size();
    Device device = new Device(computerName, id, false, 0);

    devices.add(device);
}
public void changeAvailabilty(int i)
{
     List<String> toRemove = new ArrayList<>();
     for (String str : deviceData) {
                toRemove.add(str);
                }
                deviceData.removeAll(toRemove);
                    deviceData.add("Devices:");
 for(Device device : devices)
 {
     String cName = device.getComputerName();
                String cDetails = device.getDeviceDetails();
                String cAvailable;
     if(device.getId() == i)
     {
         if(device.isAvailable())
         {
            
             device.setAvailable(false);
             
               
                     cAvailable = "false";
               
             
           
                deviceData.add(cName + "," + cDetails + "," + cAvailable);
             
         }
         else if (!device.isAvailable())
         {
             device.setAvailable(true);
             
              
                
                     cAvailable = "true";
                
               
               
               
              
           
                deviceData.add(cName + "," + cDetails + "," + cAvailable);
                 }
        
     }
      else
         {
             cAvailable = Boolean.toString(device.isAvailable());
               deviceData.add(cName + "," + cDetails + "," + cAvailable);
         }
        

           
             try{
   Path file = Paths.get("src/devices.txt");
Files.write(file, deviceData, Charset.forName("UTF-8"));
       }
       catch (IOException e)
       {
           System.out.println(e);
       }
 }
 }
public String sortDeviceAZ()
{
      Collections.sort(devices, (Device a, Device b) -> a.getComputerName().compareToIgnoreCase(b.getComputerName()));
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

public String sortDeviceZA()
{
      Collections.sort(devices, (Device a, Device b) -> b.getComputerName().compareToIgnoreCase(a.getComputerName()));
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
public String sortDevice01()
{
 
     String deviceList = "";
        ArrayList<Device> devicesSorted= new ArrayList<Device>();
  
   for (int i = 0; i < devices.size(); i++)
  {
          for (Device device: devices)
  {
            if(device.getId() == i)
            {
               devicesSorted.add(device);
            }
  }
  }
  
  for (Device device: devicesSorted)
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

public String sortDevice10()
{
 
     String deviceList = "";
        ArrayList<Device> devicesSorted= new ArrayList<Device>();
  
   for (int i = 0; i < devices.size(); i++)
  {
          for (Device device: devices)
  {
            if(device.getId() == i)
            {
               devicesSorted.add(device);
            }
  }
  }
  
  Collections.reverse(devicesSorted);
   
  for (Device device: devicesSorted)
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

public String sortDeviceAU()
{
 
     String deviceList = "";
 
  

  for (Device device: devices)
  {
      if(device.isAvailable())
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
  }
    for (Device device: devices)
  {
      if(!device.isAvailable())
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
  }
   return deviceList;

  
  
}

public String sortDeviceUA()
{
 
     String deviceList = "";
 
  

  
    for (Device device: devices)
  {
      if(!device.isAvailable())
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
  }
    for (Device device: devices)
  {
      if(device.isAvailable())
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
  }
   return deviceList;

  
  
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
    deviceData.add("Devices:");
    // Reads first line so while statment dosen't
        txtString = infile.readLine();

        while ((txtString = infile.readLine()) != null) {
            Device device = new Device(txtString, devices.size(), false, 0);

            if (device != null) {
                devices.add(device);
                i++;
                deviceData.add(txtString);
               
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
   
   
    
  
    
   
   
   
   
   
   public void writeDevices(String newData, String newDescription)
   {
       deviceData.add(newData + "," + newDescription + "," + "true");

       try{
   Path file = Paths.get("src/devices.txt");

  Files.write(file, deviceData, Charset.forName("UTF-8"));
       }
       catch (IOException e)
       {
           System.out.println(e);
       }
    
   
       System.exit(0);
   }
    
   public void changeDevices(int id)
   {
       
      try{
   Path file = Paths.get("src/devices.txt");
   for(Device device: devices)
   {
       if (device.isAvailable())
       {
          
       device.setAvailable(false);
       }
       else
       {
            device.setAvailable(true);
       }
   }
Files.write(file, deviceData, Charset.forName("UTF-8"));
       }
       catch (IOException e)
       {
           System.out.println(e);
       }
        readDevices("src/devices.txt");
       System.exit(0);
   }
   public String printDeviceDetails(int i)
   {
       String output = "";
        for(Device device : devices)
 {
    if(device.getId() == i)
     {
         output += "Device ID : " + device.getId() + "\nDevice Name : " + device.getComputerName() + "\nDevice Available : " + device.isAvailable() + "\nDevice Description : " + device.getDeviceDetails();
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

    private static class PrintWriter {

        public PrintWriter() {
        }
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
