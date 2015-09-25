package medical_store;
import static medical_store.Index.jf;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class AddNewSupplier extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4, t5, tr, tq;
    JLabel l1, l2, l3, l4, l5, l6;
    JButton b0, b1, b2, b3;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    AddNewSupplier() {
        jf.setLayout(null);
        l6 = new JLabel("New Supplier details");
        l6.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20)); 
        l6.setForeground(new java.awt.Color(51, 153, 255));
        l6.setBounds(500,50,300,40);
        jf.add(l6);

        l2 = new JLabel("Supplier name*");
        l2.setBounds(350,160,170,25);
        jf.add(l2);

        t2 = new JTextField(20);
        t2.setBounds(520,160,200,25);
        t2.setToolTipText("Enter supplier name");
        jf.add(t2);

        l3 = new JLabel("Supplier address*");
        l3.setBounds(350,200,170,25);
        jf.add(l3);

        t3 = new JTextField(20);
        t3.setBounds(520,200,250,25);
        t3.setToolTipText("Enter supplier address");
        jf.add(t3);

        l4 = new JLabel("Supplier phone no*");
        l4.setBounds(350,240,170,25);
        jf.add(l4);

        t4 = new JTextField(20);
        t4.setBounds(520,240,100,25);
        t4.setToolTipText("Enter supplier phone no");
        jf.add(t4);

        l5 = new JLabel("Supplier email id*");
        l5.setBounds(350,280,170,25);
        jf.add(l5);

        t5 = new JTextField(20);
        t5.setBounds(520,280,200,25);
        t5.setToolTipText("Enter supplier email id");
        jf.add(t5);

        b0 = new JButton("Save",new ImageIcon("images/save.png"));
        b0.setBounds(350,330,110,35);
        b0.setToolTipText("click to save supplier details");
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Clear",new ImageIcon("images/clear.png"));
        b1.setBounds(500,330,110,35);
        b1.setToolTipText("click to clear all textfilds");
        jf.add(b1); 
        b1.addActionListener(this);

        b2 = new JButton("Suppliers",new ImageIcon("images/all.png"));
        b2.setBounds(650,330,110,35);
        b2.setToolTipText("click to view all supplier details");
        jf.add(b2); 
        b2.addActionListener(this);

        b3 = new JButton("Home",new ImageIcon("images/home.png"));
        b3.setBounds(800,330,110,35);
        b3.setToolTipText("click to go to main-menu page");
        jf.add(b3); 
        b3.addActionListener(this);

        scrlPane.setBounds(5, 400, 1225, 200);
        jf.add(scrlPane);
        scrlPane.hide();
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("S_ID");
        model.addColumn("S_NAME");
        model.addColumn("S_ADDRESS");
        model.addColumn("S_PHONENO");
        model.addColumn("S_EMAILID");
        ImageIcon img = new ImageIcon("images/6.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setText("BACK");
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.validate();
        jf.repaint();
        jf.setTitle("Add New Supplier");  
}

public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == b0) {
        String mob = t4.getText();
        String email = t5.getText();
        Pattern p = Pattern.compile("[_a-z_A-Z_0-9]+[0-9]*@[a-zA-Z0-9]+.[a-zA-Z0-9]+");
        Matcher m = p.matcher(email);
        boolean matchFound = m.matches();

        if(((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))) {
            JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
        } else if(!matchFound) {
            JOptionPane.showMessageDialog(this,"Invalid email id!","Warning!!!",JOptionPane.WARNING_MESSAGE);
        }else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
                System.out.println("Connected to database.");
                
                //checker block starts
                int flag = 0;
                Statement stmt = con.createStatement();
                String query = "SELECT * from supplier";
                rs = stmt.executeQuery(query);
                String u = null;
                String v = null;
                while (rs.next()) {
                    u = rs.getString("sname");
                    v = rs.getString("semailid");
                    if (u.equals(t2.getText()) && v.equals(t5.getText())) {
                        flag = 1;
                        break;
                    }
                }  
                
                rs.close();
                stmt.close();
                //checker block ends
                if (flag == 0) {
                    ps = con.prepareStatement("insert into supplier (sname, saddress, sphoneno, semailid) values (?,?,?,?)");
                    ps.setString(1, t2.getText()); 
                    ps.setString(2, t3.getText());
                    ps.setString(3, t4.getText());
                    ps.setString(4, t5.getText());
                    ps.executeUpdate();

                    int reply = JOptionPane.showConfirmDialog(null,"Supplier added successfully.Do you want add more supplier?","Added Supplier",JOptionPane.YES_NO_OPTION);

                    if (reply == JOptionPane.YES_OPTION) {
                        jf.getContentPane().removeAll();
                        AddNewSupplier a = new AddNewSupplier();
                    } else if (reply == JOptionPane.NO_OPTION) {
                        jf.getContentPane().removeAll();
                        Main_Menu i = new Main_Menu();
                    }
                    con.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Supplier already there in the database", "Already present", JOptionPane.ERROR_MESSAGE);
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                }
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
    } else if(ae.getSource()==b1) {
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        scrlPane.hide();
    } else if(ae.getSource()==b2) {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        scrlPane.show();
  	int r = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store", "root", "");
            System.out.println("Connected to database");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from supplier group by sid asc" );
            while(rs.next()) {
            	model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
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
    } else if(ae.getSource()==b3) {
        jf.getContentPane().removeAll();
        Main_Menu i = new Main_Menu();
    }
}
 
}




