
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
            private JPanel sortPanel = new JPanel();
        private JButton searchButton = new JButton("Submit");
        private JTextField availFeild = new JTextField("", 6);
        private JButton availButton = new JButton("Submit");
   
        private JTextField searchFeild = new JTextField("", 6);
        private JTextField searchFeild2 = new JTextField("", 6);
          private JLabel searchLabel = new JLabel(" Create Device (App will close) :   ");
                    private JLabel searchFieldLabel = new JLabel(" Device Name :   ");
                       private JLabel searchField2Label = new JLabel(" Device Descritption :   ");
      private JLabel availLabel = new JLabel(" Change Availability :   ");
  
           private JLabel deviceLabel = new JLabel(" Search Device :   ");
           private JTextField deviceFeild = new JTextField("", 6);
              private JButton deviceButton = new JButton("Submit");
              
              //Sort Panel Componenets
                     private JLabel sortLabel = new JLabel(" Sort By:   ");
                  private JButton iDSortButton = new JButton("1/0");
                  private JButton alphSortButton = new JButton("A/Z");
                  private JButton availableSortButton = new JButton("Availibility");
                  
                  //Sort Booleans
                    private boolean aZ = true;
                    private boolean num01 = false;
                    private boolean avail = true;
      
public void jFramePrint()
{

    this.setLayout(new BorderLayout());
    this.add(controlPanel,BorderLayout.SOUTH);
     this.add(sortPanel,BorderLayout.NORTH);
    searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             String Input = searchFeild.getText();
              String Input2 = searchFeild2.getText();
             ApplicationModel.getInstance().writeDevices(Input, Input2);
//             deviceDisplay.setText(" ");
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
  // Sort Pannel Buttons
       alphSortButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

              if (aZ == true)
            {
            
             deviceDisplay.setText(ApplicationModel.getInstance().sortDeviceAZ());
              alphSortButton.setText("Z/A");
             aZ = false;
            }
              else
              {
                   deviceDisplay.setText(ApplicationModel.getInstance().sortDeviceZA());
                            alphSortButton.setText("A/Z");
             aZ = true;
              }
           
        }
    });
       iDSortButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          
              if (num01 == true)
            {
             deviceDisplay.setText(ApplicationModel.getInstance().sortDevice01());
             iDSortButton.setText("1/0");
             num01 = false;
        }
              else
              {
                    deviceDisplay.setText(ApplicationModel.getInstance().sortDevice10());
                   iDSortButton.setText("0/1");
             num01 = true;
              }
        }
    });
         availableSortButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          
              if (avail == true)
            {
             deviceDisplay.setText(ApplicationModel.getInstance().sortDeviceAU());
          
             avail = false;
        }
              else
              {
                    deviceDisplay.setText(ApplicationModel.getInstance().sortDeviceUA());
   
             avail = true;
              }
        }
    });
  
       
    
        
   deviceDisplay.setText(ApplicationModel.getInstance().printDevices());
   
   //controlPanel Add
    controlPanel.add(searchLabel);
      controlPanel.add(searchFieldLabel);
    controlPanel.add(searchFeild);
            controlPanel.add(searchField2Label);
        controlPanel.add(searchFeild2);
    controlPanel.add(searchButton);
        controlPanel.add(availLabel);
    controlPanel.add(availFeild);
    controlPanel.add(availButton);
      controlPanel.add(deviceLabel);
    controlPanel.add(deviceFeild);
    controlPanel.add(deviceButton);
    
    //sortPanel Add
        sortPanel.add(sortLabel);
    sortPanel.add(iDSortButton);
    sortPanel.add(alphSortButton);
    sortPanel.add(availableSortButton);

    
    this.setSize(1600,900);
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
    

        
      
    
  
        
      
    
  
