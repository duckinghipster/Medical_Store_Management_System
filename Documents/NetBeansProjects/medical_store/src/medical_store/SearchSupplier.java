package medical_store;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import static medical_store.Index.jf;

public class SearchSupplier extends JFrame implements ActionListener {
    JTextField t1;
    JLabel l1, l6;
    JButton b0,b1,b2;
    Font f;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    SearchSupplier() {
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);

        l6=new JLabel("Search Supplier");
        l6.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20)); 
        l6.setForeground(new java.awt.Color(51, 153, 255));
        l6.setBounds(500,50,300,40);
        jf.add(l6);

        l1= new JLabel("Search");
        l1.setBounds(350,120,130,25);
        jf.add(l1);

        t1=new JTextField(20);
        t1.setBounds(520,120,300,25);t1.setToolTipText("Enter supplier id to search supplier");
        jf.add(t1);

        b0 = new JButton("By Name",new ImageIcon("images/search.png"));
        b0.setBounds(350,190,110,35);b0.setToolTipText("click to open supplier details");
        jf.add(b0);b0.addActionListener(this);

        b1 = new JButton("By Address",new ImageIcon("images/search.png"));
        b1.setBounds(500,190,150,35);b1.setToolTipText("click to clear all textfields");
        jf.add(b1); b1.addActionListener(this);

        b2= new JButton("By Email",new ImageIcon("images/search.png"));
        b2.setBounds(690,190,110,35);b2.setToolTipText("click to view all supplier details");
        jf.add(b2); b2.addActionListener(this);
     
        scrlPane.setBounds(5,250,1225,250);
        jf.add(scrlPane);scrlPane.hide();
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("S_ID");
        model.addColumn("S_NAME");
        model.addColumn("S_ADDRESS");
        model.addColumn("S_PHONENO");
        model.addColumn("S_EMAILID");
        ImageIcon img = new ImageIcon("images/1.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setText("BACK");
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.validate();
        jf.repaint();
        jf.setTitle("Search Supplier");
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
            int foundrec = 0, r = 0;;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
            System.out.println("Connected to database.");
            ps = con.prepareStatement("select * from supplier where sname like '%" + t1.getText() + "%'");
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
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error:"+e);
        }
    } else if(ae.getSource()==b1) {
        try {
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            scrlPane.show();
            int foundrec = 0, r = 0;;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
            System.out.println("Connected to database.");
            ps = con.prepareStatement("select * from supplier where saddress like '%" + t1.getText() + "%'");
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
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error:"+e);
        }
    } else if(ae.getSource()==b2) {
  	try {
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            scrlPane.show();
            int foundrec = 0, r = 0;;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
            System.out.println("Connected to database.");
            ps = con.prepareStatement("select * from supplier where semailid like '%" + t1.getText() + "%'");
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
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error:"+e);
        }
    }
}

}
