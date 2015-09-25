package medical_store;
import javax.swing.*;
import java.awt.*;
import static medical_store.Index.jf;
 
class About extends JFrame {
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2,b3;

    About() {
        jf.setLayout(null);

        l1 = new JLabel("Medical Stock Manangement System");
        l1.setFont(new Font("Berlin Sans FB Demi", 1, 30)); 
        l1.setForeground(Color.black);
        l1.setBounds(400,50,500,40);
        jf.add(l1);

        
        l2 = new JLabel("This  System  has  been  developed  by,  Mr.SHUBHAM  NANDA");
        l2.setBounds(100, 130,600,40);
        jf.add(l2);
        
        ImageIcon img1 = new ImageIcon("images/me.jpg");
        l3 = new JLabel();
        l3.setIcon(img1);        
        l3.setBounds(100, 180, 200, 200);     
        jf.add(l3);

        l6 = new JLabel("In this system, we can add details of Medicines and Suppliers. We can also update, delete & search for the existing details. Also, there is");           
        l6.setFont(new Font("Times New Roman", 1, 15));
        l6.setBounds(100, 530, 1100, 40);
        jf.add(l6);

        l7 = new JLabel("provision for furnishing daily purchase report and supplier wise medicine report. This software has been developed for the management of");
        l7.setFont(new Font("Times New Roman", 1, 15));
        l7.setBounds(100, 550, 1100, 40);
        jf.add(l7);
        
        l4 = new JLabel("stock of Medicine & suppliers for the medical store. It is a java(swing) based Medical Store Management System. It is platform independent, and");
        l4.setFont(new Font("Times New Roman", 1, 15));
        l4.setBounds(100, 570, 1100, 40);
        jf.add(l4);
        
        l5 = new JLabel("connected to its DataBase using JDBC");
        l5.setFont(new Font("Times New Roman", 1, 15));
        l5.setBounds(100, 590, 1100, 40);
        jf.add(l5);
        
        ImageIcon img = new ImageIcon("images/12.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setText("BACK");
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.setTitle("About System");
        jf.validate();
        jf.repaint();
    }
}

