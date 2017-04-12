
package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ApplicationModel;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;



public class ApplicationViewer extends JFrame {
   
    private JTabbedPane tabs = new JTabbedPane();
     private JTextArea deviceDisplay = new JTextArea();
        private JTextArea aboutDisplay = new JTextArea();
            private JTextArea deviceDetailsDisplay = new JTextArea();
        private JPanel controlPanel = new JPanel();
        private JButton searchButton = new JButton("Submit");
        private JTextField availFeild = new JTextField("", 6);
        private JButton availButton = new JButton("Submit");
   
        private JTextField searchFeild = new JTextField("", 6);
          private JLabel searchLabel = new JLabel(" Create Device :   ");
      private JLabel availLabel = new JLabel(" Change Availability :   ");
  
           private JLabel deviceLabel = new JLabel(" Search Device :   ");
           private JTextField deviceFeild = new JTextField("", 6);
              private JButton deviceButton = new JButton("Submit");
      
public void jFramePrint()
{

    this.setLayout(new BorderLayout());
    this.add(controlPanel,BorderLayout.SOUTH);
    searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             String Input = searchFeild.getText();
             ApplicationModel.getInstance().addDevice(Input);
             deviceDisplay.setText(ApplicationModel.getInstance().printDevices());
            
        }
    });
    availButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             String Input = availFeild.getText();
             ApplicationModel.getInstance().changeAvailabilty(Integer.parseInt(Input));
             deviceDisplay.setText(ApplicationModel.getInstance().printDevices());
            
        }
    });
        deviceButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             String Input = deviceFeild.getText();
            
             deviceDetailsDisplay.setText(ApplicationModel.getInstance().printDeviceDetails(Integer.parseInt(Input)));
            
        }
    });
  
  
       
    
        
   deviceDisplay.setText(ApplicationModel.getInstance().printDevices());
   
    controlPanel.add(searchLabel);
    controlPanel.add(searchFeild);
    controlPanel.add(searchButton);
        controlPanel.add(availLabel);
    controlPanel.add(availFeild);
    controlPanel.add(availButton);
      controlPanel.add(deviceLabel);
    controlPanel.add(deviceFeild);
    controlPanel.add(deviceButton);
    
    this.setSize(860,690);
    this.setTitle("Device Managment System");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   
 
    aboutDisplay.append("Created by Dominic Brett");

    tabs.add("Devices", deviceDisplay);
     tabs.add("Device Information", deviceDetailsDisplay);
    tabs.add("About", aboutDisplay);

    this.add(tabs);
 this.setVisible(true);
    
}
       
   private static ApplicationViewer instance;
   
    /**
     *
     * @return the one instance of ApplicationViewer
     */
    public static ApplicationViewer getInstance() {
        return instance;
    }


    public static void setInstance(ApplicationViewer instance) {
        ApplicationViewer.instance = instance;
    }
}
    

        
      
    
  