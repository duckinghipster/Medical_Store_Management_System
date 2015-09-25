package medical_store;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import static medical_store.Index.jf;

public class DeleteSupplier extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t2, t3, t4, t5;
    JButton b0, b1, b2, b3;
    GridBagLayout gbl;
    GridBagConstraints gbc;
    Font f;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    DeleteSupplier() {
        Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);

        l6=new JLabel("Delete Supplier");
        l6.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20)); 
        l6.setForeground(new java.awt.Color(51, 153, 255));
        l6.setBounds(500,70,300,40);
        jf.add(l6);

            l2 = new JLabel("Supplier name*");
        l2.setBounds(350,160,170,25);
            jf.add(l2);

            t2=new JTextField(20);
            t2.setBounds(520,160,200,25);t2.setToolTipText("Enter supplier name");
            jf.add(t2);

            l3 = new JLabel("Supplier address*");
        l3.setBounds(350,200,170,25);
            jf.add(l3);

            t3=new JTextField(20);
            t3.setBounds(520,200,250,25);t3.setToolTipText("Enter supplier address");
            jf.add(t3);

            l4 = new JLabel("Supplier phone no*");
        l4.setBounds(350,240,170,25);
            jf.add(l4);

            t4=new JTextField(20);
            t4.setBounds(520,240,100,25);t4.setToolTipText("Enter supplier phone no");
            jf.add(t4);

            l5 = new JLabel("Supplier email id*");
        l5.setBounds(350,280,170,25);
            jf.add(l5);

            t5=new JTextField(20);
            t5.setBounds(520,280,200,25);t5.setToolTipText("Enter supplier emailid");
            jf.add(t5);


            b0 = new JButton("Open",new ImageIcon("images/open.png"));
            b0.setBounds(350,330,110,35);b0.setToolTipText("click to open supplier details");
            jf.add(b0); b0.addActionListener(this);

            b1 = new JButton("Delete",new ImageIcon("images/delete.png"));
            b1.setBounds(500,330,110,35);b1.setToolTipText("click to update supplier details");
            jf.add(b1);b1.addActionListener(this);

            b2 = new JButton("Clear",new ImageIcon("images/clear.png"));
            b2.setBounds(650,330,110,35);b2.setToolTipText("click to clear all textfilds");
            jf.add(b2);b2.addActionListener(this);

            b3 = new JButton("All",new ImageIcon("images/all.png"));
            b3.setBounds(800,330,110,35);b3.setToolTipText("click to view all supplier details");
            jf.add(b3); b3.addActionListener(this);

        scrlPane.setBounds(5, 400, 1225, 200);
        jf.add(scrlPane);scrlPane.hide();
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("S_ID");
        model.addColumn("S_NAME");
        model.addColumn("S_ADDRESS");
        model.addColumn("S_PHONENO");
        model.addColumn("S_EMAILID");
        
        ImageIcon img = new ImageIcon("images/2.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setText("BACK");
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.setTitle("Update Supplier");
        jf.validate();
        jf.repaint();
    }

public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==b0) {
        if(((t2.getText()).equals(""))) {
            JOptionPane.showMessageDialog(this,"Please enter supplier name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                scrlPane.show();
                int foundrec = 0, r = 0;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
                System.out.println("Connected to database.");
                ps = con.prepareStatement("select * from supplier where sname like '%" + t2.getText() + "%'");
                rs = ps.executeQuery();
                while(rs.next()) {
                    model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5) });
                    foundrec = 1;
                }
                if (foundrec == 0) {
                     JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
                 }
                con.close();
            }

            catch(SQLException se) {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error:"+se);
            }
            catch(Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error:"+e);
            }
        }
    } else if(ae.getSource() == b1) {
        if(((t2.getText()).equals("")) && ((t2.getText()).equals(""))) {
		  JOptionPane.showMessageDialog(this,"Please enter supplier semailid or name !","Warning!!!",JOptionPane.ERROR_MESSAGE);
	} else {
            try {
	    Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
            System.out.println("Connected to database.");
	    ps = con.prepareStatement("delete from supplier where semailid = '" + t5.getText() + "' or sname = '"+t2.getText()+"'");
	    ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record is deleted.");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                con.close();
            }
            catch(SQLException se) {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error:"+se);
            }
            catch(Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error:"+e);
            }
        }
    } else if(ae.getSource()==b2) {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        scrlPane.hide();
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
    } else if(ae.getSource()==b3) {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        scrlPane.show();
  	int r = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
            System.out.println("Connected to database.");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * from supplier" );
            while(rs.next()) {
            	model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5) });
            }
            con.close();
        }
        catch(SQLException se)
        {
            System.out.println(se);
            JOptionPane.showMessageDialog(null,"SQL Error"+se);
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error:"+e);
        }
    }
}
}

