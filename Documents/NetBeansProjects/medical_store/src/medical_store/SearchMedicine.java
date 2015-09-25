package medical_store;
import static medical_store.Index.jf;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class SearchMedicine extends JFrame implements ActionListener
{
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ln;
    JButton b0,b1,b2,b3,b4;
    JComboBox msname;
    String s;
    Font f;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    SearchMedicine() {		
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);

        ln = new JLabel("Search Medicine");
        ln.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40)); 
        ln.setForeground(new Color(51, 153, 255));
        ln.setBounds(470,50,300,40);
        jf.add(ln);

        l1 = new JLabel("Search");
        l1.setBounds(400,140,200,30);
        jf.add(l1);
        
        t1 = new JTextField(20);
        t1.setBounds(550,140,400,30);
        t1.setToolTipText("Enter medicine name or company name or supplier name to search");
        jf.add(t1);

        b0 = new JButton("By name",new ImageIcon("images/search.png"));
        b0.setBounds(300,200,130,35);
        b0.setToolTipText("click to search medicine details By name");
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("By company",new ImageIcon("images/search.png"));
        b1.setBounds(450,200,130,35);
        b1.setToolTipText("click to search medicine details By company");
        jf.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("By supplier",new ImageIcon("images/search.png"));
        b2.setBounds(600,200,130,35);
        b2.setToolTipText("click to search medicine details By supplier");
        jf.add(b2); 
        b2.addActionListener(this);
        
        b3 = new JButton("By expdate",new ImageIcon("images/search.png"));
        b3.setBounds(750,200,130,35);
        b3.setToolTipText("click to search medicine details By expiry date");
        jf.add(b3); 
        b3.addActionListener(this);
        
        b4 = new JButton("By purdate",new ImageIcon("images/search.png"));
        b4.setBounds(900,200,130,35);
        b4.setToolTipText("click to search medicine details By expiry date");
        jf.add(b4); 
        b4.addActionListener(this);

        scrlPane.setBounds(5, 300, 1225, 200);
        jf.add(scrlPane);scrlPane.hide();
        tabGrid.setFont(new Font ("Times New Roman", 0, 15));

        model.addColumn("M_BNO");
        model.addColumn("M_NAME");
        model.addColumn("M_COMPANY");
        model.addColumn("M_QUANTITY");
        model.addColumn("M_EXPDATE");
        model.addColumn("M_PURDATE");
        model.addColumn("M_TYPE");
        model.addColumn("M_SALEPRICE");
        model.addColumn("M_PURPRICE");
        model.addColumn("M_RACKNO");
        model.addColumn("M_SID");
        model.addColumn("M_SNAME");

        ImageIcon img = new ImageIcon("images/6.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.setTitle("Search Medicine ");
        jf.validate();
        jf.repaint();
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b0) {
            try {  
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                scrlPane.show();
                int foundrec = 0, r = 0;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store", "root", "");
                System.out.println("Connected to database.");

                ps = con.prepareStatement("select * from medicine where mname like '%" + t1.getText() + "%'");
                rs = ps.executeQuery();
                while(rs.next()) {
                    model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12) });
                    foundrec = 1;
                }
                if (foundrec == 0) {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
                }

                con.close();
            }
            catch(SQLException se)
            {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error."+se);
            }
            catch(Exception e)
            {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error."+e);
            }
        } else if(ae.getSource() == b1) {
            try {
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                scrlPane.show();
                int foundrec = 0, r = 0;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store", "root", "");
                System.out.println("Connected to database.");

                ps = con.prepareStatement("select * from medicine where mcompany like '%" + t1.getText() + "%'");
                rs = ps.executeQuery();
                while(rs.next()) {
                    model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12) });
                    foundrec = 1;
                }
                if (foundrec == 0) {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
                }

                con.close();
            }
            catch(SQLException se)
            {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error."+se);
            }
            catch(Exception e)
            {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error."+e);
            }
        } else if(ae.getSource() == b2) {
            try {
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                scrlPane.show();
                int foundrec = 0, r = 0;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store", "root", "");
                System.out.println("Connected to database.");

                ps = con.prepareStatement("select * from medicine where sname like '%" + t1.getText() + "%'");
                rs = ps.executeQuery();
                while(rs.next()) {
                    model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12) });
                    foundrec = 1;
                }
                if (foundrec == 0) {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
                }

                con.close();
            }
            catch(SQLException se)
            {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error."+se);
            }
            catch(Exception e)
            {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error."+e);
            }
        } else if(ae.getSource() == b3) {
            try {
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                scrlPane.show();
                int foundrec = 0, r = 0;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store", "root", "");
                System.out.println("Connected to database.");

                ps = con.prepareStatement("select * from medicine where mexpdate like '%" + t1.getText() + "%'");
                rs = ps.executeQuery();
                while(rs.next()) {
                    model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12) });
                    foundrec = 1;
                }
                if (foundrec == 0) {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
                }

                con.close();
            }
            catch(SQLException se)
            {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error."+se);
            }
            catch(Exception e)
            {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error."+e);
            }
        } else if(ae.getSource() == b4) {
            try {
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                scrlPane.show();
                int foundrec = 0, r = 0;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store", "root", "");
                System.out.println("Connected to database.");

                ps = con.prepareStatement("select * from medicine where mpurdate like '%" + t1.getText() + "%'");
                rs = ps.executeQuery();
                while(rs.next()) {
                    model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12) });
                    foundrec = 1;
                }
                if (foundrec == 0) {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialog",JOptionPane.WARNING_MESSAGE);
                }

                con.close();
            }
            catch(SQLException se)
            {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error."+se);
            }
            catch(Exception e)
            {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error."+e);
            }
        }
    }
}


