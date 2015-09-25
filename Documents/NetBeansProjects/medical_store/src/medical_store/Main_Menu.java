package medical_store;
import static medical_store.Index.jf;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main_Menu extends JFrame implements ActionListener {   
    
    JMenuBar mbar;
    JMenu m0, m1, m2, m3, m4, m5;
    JMenuItem m0_1, m1_1, m1_2, m1_3, m1_4, m1_5, m2_1, m2_2, m2_3, m2_4, m2_5, m3_1, m3_2, m4_1, m5_1;
    JLabel l1, LogoColl, l2;
    GridBagLayout gbl;

    public Main_Menu() {
        jf.setLayout(null);
         
        l1 = new JLabel("WELCOME");
        l1.setFont(new Font("Berlin Sans FB Demi", 1, 50)); 
        l1.setForeground(new Color(51, 153, 255));
        jf.add(l1);
        l1.setBounds(470, 50, 300, 50);
        
        l2 = new JLabel("MEDICAL STOCK MANAGEMENT SYSTEM");
        l2.setFont(new Font("Berlin Sans FB Demi", 1, 35)); 
        l2.setForeground(new Color(0, 0, 0));
        jf.add(l2);
        l2.setBounds(320, 350, 700, 50);

        mbar = new JMenuBar();
        jf.setJMenuBar(mbar);
           
        m0 = new JMenu("Home");
        mbar.add(m0);
        m0_1 = new JMenuItem("Go to Home",new ImageIcon("images/home.png"));
        m0.add(m0_1);
        
        m1 = new JMenu("Supplier");
        mbar.add(m1);
        m1_1 = new JMenuItem("Add New Supplier",new ImageIcon("images/addnew.png"));
        m1.add(m1_1);
        m1_2 = new JMenuItem("search Supplier",new ImageIcon("images/search.png"));
        m1.add(m1_2);
        m1_3 = new JMenuItem("Update Supplier",new ImageIcon("images/update.png"));
        m1.add(m1_3);
        m1_4 = new JMenuItem("Delete Supplier",new ImageIcon("images/delete.png"));
        m1.add(m1_4);
        m1_5 = new JMenuItem("List of Supplier",new ImageIcon("images/all.png"));
        m1.add(m1_5);

        m2 = new JMenu("Medicine");
        mbar.add(m2);
        m2_1 = new JMenuItem("Add New Medicine",new ImageIcon("images/addnew.png"));
        m2.add(m2_1);
        m2_2 = new JMenuItem("search Medicine",new ImageIcon("images/search.png"));
        m2.add(m2_2);
        m2_3 = new JMenuItem("Update Medicine",new ImageIcon("images/update.png"));
        m2.add(m2_3);
        m2_4 = new JMenuItem("Delete Medicine",new ImageIcon("images/delete.png"));
        m2.add(m2_4);
        m2_5 = new JMenuItem("Stock of Medicine",new ImageIcon("images/all.png"));
        m2.add(m2_5);


        m3 = new JMenu("Report");
        mbar.add(m3);
        m3_1 = new JMenuItem("Daily Purchase Report",new ImageIcon("images/report.png"));
        m3.add(m3_1);

        m3_2 = new JMenuItem("Suplier wise medicine Report",new ImageIcon("images/report.png"));
        m3.add(m3_2);

        m4 = new JMenu("About");
        mbar.add(m4);
        m4_1 = new JMenuItem("About System",new ImageIcon("images/help.png"));
        m4.add(m4_1);

        m5 = new JMenu("Lock");
        mbar.add(m5);
        m5_1 = new JMenuItem("Lock",new ImageIcon("images/lock.png"));
        m5.add(m5_1);

        m0_1.addActionListener(this);
        
        m1_1.addActionListener(this);
        m1_2.addActionListener(this);
        m1_3.addActionListener(this);
        m1_4.addActionListener(this);
        m1_5.addActionListener(this);

        m2_1.addActionListener(this);
        m2_2.addActionListener(this);
        m2_3.addActionListener(this);
        m2_4.addActionListener(this);
        m2_5.addActionListener(this);

        m3_1.addActionListener(this);
        m3_2.addActionListener(this);
        m4_1.addActionListener(this);
        m5_1.addActionListener(this);
        
        ImageIcon img = new ImageIcon("images/1.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.validate();
        jf.repaint();
        jf.setTitle("Main Menu");
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == m0_1) {
            jf.getContentPane().removeAll();
            Main_Menu i = new Main_Menu();
        }
        
        else if(ae.getSource() == m1_1) {
            jf.getContentPane().removeAll();
            new AddNewSupplier();
        } else if(ae.getSource() == m1_2) {
            jf.getContentPane().removeAll();
            new SearchSupplier();
        } else if(ae.getSource() == m1_3) {
            jf.getContentPane().removeAll();
            new UpdateSupplier();
        } else if(ae.getSource() == m1_4) {
            jf.getContentPane().removeAll();
            new DeleteSupplier();
        } else if(ae.getSource() == m1_5) {
            jf.getContentPane().removeAll();
            new SupplierList();
        }


        else if(ae.getSource()==m2_1) {
            jf.getContentPane().removeAll();
            new AddNewMedicine();
        } else if(ae.getSource()==m2_2) {
            jf.getContentPane().removeAll();
            new SearchMedicine();
        } else if(ae.getSource()==m2_3) {
            jf.getContentPane().removeAll();
            new UpdateMedicine();
        } else if(ae.getSource()==m2_4) {
            jf.getContentPane().removeAll();
            new DeleteMedicine();
        } else if(ae.getSource()==m2_5) {
            jf.getContentPane().removeAll();
            new MedicineList();
        }


        else if(ae.getSource()==m3_1) {
            jf.getContentPane().removeAll();
            new DailyPurchaseReport();
        } else if(ae.getSource()==m3_2) {
            jf.getContentPane().removeAll();
            new SupplierWiseMedList();
        }


        else if(ae.getSource()==m4_1) {
            jf.getContentPane().removeAll();
            new About();
        }

        else if(ae.getSource()==m5_1) {
            jf.getContentPane().removeAll();
            mbar.hide();
            new Lock();
        }
    }
}
