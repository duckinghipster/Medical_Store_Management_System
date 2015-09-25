package medical_store;
import static medical_store.Index.jf;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static medical_store.Index.jf;

public class DeleteMedicine extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ln;
    JButton b0,b1,b2,b3;
    JComboBox msname,tabtype;
    String s,sid1,tabt;
    Font f;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    DeleteMedicine() {
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);

        ln = new JLabel(" Delete Medicine ");
        ln.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20)); 
        ln.setForeground(new java.awt.Color(51, 153, 255));
        ln.setBounds(500,50,300,40);
        jf.add(ln);

        l1 = new JLabel("Medicine Batch no*");
        l1.setBounds(400,100,200,25);
        jf.add(l1);

        t1 = new JTextField(20);
        t1.setBounds(600,100,100,25);t1.setToolTipText("Enter medicine batch no");
        jf.add(t1);

        l2 = new JLabel("Medicine name*");
        l2.setBounds(400,140,200,25);
        jf.add(l2);

        t2 = new JTextField(20);
        t2.setBounds(600,140,200,25);t2.setToolTipText("Enter medicine name");
        jf.add(t2);

        
        l5 = new JLabel("Med expiry date*");
        l5.setBounds(400,180,250,25);
        jf.add(l5);

        t5 = new JTextField(20);
        t5.setBounds(600,180,100,25);t5.setToolTipText("Enter medicine expiry date");
        jf.add(t5);

        
        b0 = new JButton("Open",new ImageIcon("images//open.png"));
        b0.setBounds(350,240,110,35);
        b0.setToolTipText("click to open medicine details");
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Delete",new ImageIcon("images//delete.png"));
        b1.setBounds(500,240,110,35);
        b1.setToolTipText("click to delete medicine details");
        jf.add(b1); 
        b1.addActionListener(this);

        b2= new JButton("Clear",new ImageIcon("images//clear.png"));
        b2.setBounds(650,240,110,35);
        b2.setToolTipText("click to clear all textfields");
        jf.add(b2); 
        b2.addActionListener(this);

        b3 = new JButton("All",new ImageIcon("images//all.png"));
        b3.setBounds(800,240,110,35);b3.setToolTipText("click to view all medicine details");
        jf.add(b3); 
        b3.addActionListener(this);

        scrlPane.setBounds(5,380,1225,200);
        jf.add(scrlPane);scrlPane.hide();
        tabGrid.setFont(new Font ("Times New Roman",0,15));

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

        ImageIcon img = new ImageIcon("images/8.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setText("BACK");
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.validate();
        jf.repaint();
        jf.setTitle("Delete Medicine ");
    }

public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==b0) {
        if(((t1.getText()).equals(""))&&((t2.getText()).equals(""))&&((t5.getText()).equals(""))) {
            JOptionPane.showMessageDialog(this,"Please enter medicine batchno or name or mexpdate!","Warning!!!",JOptionPane.WARNING_MESSAGE);
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
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
		System.out.println("Connected to database.");  

                ps = con.prepareStatement("select * from medicine where mname like '%" + t2.getText() + "%' and mbno like '%" + t1.getText() + "%' and mexpdate like '%" + t5.getText() + "%'");
                rs = ps.executeQuery();
                while(rs.next()) {
		    model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});
                    foundrec = 1;
                }
                if (foundrec == 0) {
                    JOptionPane.showMessageDialog(null,"Record is not available","Dialogs",JOptionPane.WARNING_MESSAGE);
                }
                con.close();
            }
            catch(SQLException se)
            {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error:"+se);
            }
   	    catch(Exception e)
            {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Error:"+e);
            }
        }
    } else if(ae.getSource()==b1) {
        if(((t1.getText()).equals(""))&&((t2.getText()).equals(""))) {
            JOptionPane.showMessageDialog(this,"Please enter medicine batchno or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
		System.out.println("Connected to database.");
                ps=con.prepareStatement("delete from medicine where mbno='"+t1.getText()+"' or mname='"+t2.getText()+"'");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Record is deleted.");
                t1.setText("");
                t2.setText("");
                t5.setText("");
                con.close();
            }
            catch(SQLException se)
            {
		System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL Error:"+se);
            }
	    catch(Exception e)
            {
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
        t1.setText("");
        t2.setText("");
        t5.setText("");        
    } else if(ae.getSource()==b3) {
  	int r = 0;
        try {
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            scrlPane.show();
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
            System.out.println("Connected to database.");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * from medicine" );
            while(rs.next()) {
                model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12) });
            }
            con.close();
        }
        catch(SQLException se)
        {
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


