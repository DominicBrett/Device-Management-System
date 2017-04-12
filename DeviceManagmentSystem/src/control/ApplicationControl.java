/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import model.ApplicationModel;
import view.ApplicationViewer;

/**
 *
 * @author dominic
 */
public class ApplicationControl {
     public static void main(String[] args){
      ApplicationModel am = new ApplicationModel();
      ApplicationModel.setInstance(am);
      am.readDevices("src/devices.txt");
   
     
   ApplicationViewer av = new ApplicationViewer();
   ApplicationViewer.setInstance(av);
        ApplicationViewer.getInstance().jFramePrint();
        
   
      
    }
}
