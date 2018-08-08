import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

 class NextPage extends JFrame{

    void tabview(){
       
        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable();
       
        // create a table model and set a Column Identifiers to this model
        Object[] columns = {"Id","Member Strength","Batch","Performance Type"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
       
        // set the model to the table
        table.setModel(model);
       
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
       
        // create JTextFields
        JTextField textId = new JTextField();
        JTextField textFname = new JTextField();
        JTextField textLname = new JTextField();
        JTextField textAge = new JTextField();
       
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");    
       
        textId.setBounds(20, 220, 100, 25);
        textFname.setBounds(20, 250, 100, 25);
        textLname.setBounds(20, 280, 100, 25);
        textAge.setBounds(20, 310, 100, 25);
       
        btnAdd.setBounds(150, 220, 100, 25);
        btnUpdate.setBounds(150, 265, 100, 25);
        btnDelete.setBounds(150, 310, 100, 25);
       
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
       
        frame.setLayout(null);
       
        frame.add(pane);
       
        // add JTextFields to the jframe
        frame.add(textId);
        frame.add(textFname);
        frame.add(textLname);
        frame.add(textAge);
   
        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
       
        // create an array of objects to set the row data
        Object[] row = new Object[4];
       
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                row[0] = textId.getText();
                row[1] = textFname.getText();
                row[2] = textLname.getText();
                row[3] = textAge.getText();
               
                // add row to the model
                model.addRow(row);
            }
        });
       
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
           
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
       
        // get selected row data From table to textfields
        table.addMouseListener(new MouseAdapter(){
       
        @Override
        public void mouseClicked(MouseEvent e){
           
            // i = the index of the selected row
            int i = table.getSelectedRow();
           
            textId.setText(model.getValueAt(i, 0).toString());
            textFname.setText(model.getValueAt(i, 1).toString());
            textLname.setText(model.getValueAt(i, 2).toString());
            textAge.setText(model.getValueAt(i, 3).toString());
        }
        });
       
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
               
                if(i >= 0)
                {
                   model.setValueAt(textId.getText(), i, 0);
                   model.setValueAt(textFname.getText(), i, 1);
                   model.setValueAt(textLname.getText(), i, 2);
                   model.setValueAt(textAge.getText(), i, 3);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
       
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       
    }
}
class Loginc implements ActionListener
 {
  JButton SUBMIT;
  JPanel panel;
  JLabel label1,label2;
  JTextField  text1,text2;
  JFrame f= new JFrame();
   void logscreen() {
      
   //JFrame f=new JFrame();
     // f.setSize(300,100);
      //f.setVisible(true);
  
   label1 = new JLabel();
   label1.setText("Username:");
   text1 = new JTextField(15);
 
   label2 = new JLabel();
   label2.setText("Password:");
   text2 = new JPasswordField(15);
 
   SUBMIT=new JButton("SUBMIT");
  
   panel=new JPanel(new GridLayout(3,1));
   f.add(panel);
   panel.add(label1);
   panel.add(text1);
   panel.add(label2);
   panel.add(text2);
   panel.add(SUBMIT);
   f.add(panel,BorderLayout.CENTER);
   SUBMIT.addActionListener(this);
   f.setTitle("LOGIN FORM");
   f.setSize(300,100);
      f.setVisible(true);
   }
        

  public void actionPerformed(ActionEvent ae)
   {
   String value1=text1.getText();
   String value2=text2.getText();
   if (value1.equals("rajaram") && value2.equals("jat123")) {
       f.dispose();
   NextPage page=new NextPage();
   page.tabview();
   //page.setVisible(true);
   //JLabel label = new JLabel("Welcome:"+value1);
   //page.getContentPane().add(label);
   //page.setVisible(true);
   }
   else{
   System.out.println("enter the valid username and password");
   JOptionPane.showMessageDialog(f,"Incorrect login or password",
   "Error",JOptionPane.ERROR_MESSAGE);
   }
 }
 }
  class NewClass
 {
   public static void main(String arg[])
   {
   try
   {
   Loginc frame=new Loginc();
   frame.logscreen();
   }
   catch(Exception e)
   {JOptionPane.showMessageDialog(null, e.getMessage());}
   }
 }