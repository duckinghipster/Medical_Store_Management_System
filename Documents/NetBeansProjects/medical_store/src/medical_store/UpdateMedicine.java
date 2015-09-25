package medical_store;
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

public class UpdateMedicine extends JFrame implements ActionListener
{
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

    UpdateMedicine() {
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);

        ln=new JLabel("Update Medicine");
        ln.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20)); 
        ln.setForeground(new java.awt.Color(51, 153, 255));
        ln.setBounds(500,50,300,40);
        jf.add(ln);

        l1 = new JLabel("Medicine Batch no*");
        l1.setBounds(200,100,200,25);
        jf.add(l1);

        t1 = new JTextField(20);
        t1.setBounds(400,100,100,25);t1.setToolTipText("Enter medicine batch no");
        jf.add(t1);

        l2 = new JLabel("Medicine name*");
        l2.setBounds(200,140,200,25);
        jf.add(l2);

        t2 = new JTextField(20);
        t2.setBounds(400,140,200,25);t2.setToolTipText("Enter medicine name");
        jf.add(t2);

        l3 = new JLabel("Medicine company*");
        l3.setBounds(200,180,200,25);
        jf.add(l3);

        t3 = new JTextField(20);
        t3.setBounds(400,180,200,25);t3.setToolTipText("Enter medicine company");
        jf.add(t3);

        l4 = new JLabel("Medicine quantity*");
        l4.setBounds(200,220,200,25);
        jf.add(l4);

        t4 = new JTextField(20);
        t4.setBounds(400,220,100,25);t4.setToolTipText("Enter medicine quantity");
        jf.add(t4);

        l5 = new JLabel("Med expiry date*");
        l5.setBounds(200,260,250,25);
        jf.add(l5);

        t5 = new JTextField(20);
        t5.setBounds(400,260,100,25);t5.setToolTipText("Enter medicine expiry date");
        jf.add(t5);

        l6 = new JLabel("Med purchase date*");
        l6.setBounds(200,300,260,25);
        jf.add(l6);

        t6 = new JTextField(20);
        t6.setBounds(400,300,100,25);t6.setToolTipText("Enter medicine expiry date");
        jf.add(t6);

        java.util.Date date1 = new java.util.Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date1);
        String strDate = calendar.get(Calendar.DATE)+"-"+(calendar.get(Calendar.MONTH) + 1)+"-"+calendar.get(Calendar.YEAR);
        t6.setText(strDate);

        l7 = new JLabel("Medicine type*");
        l7.setBounds(670,100,200,25);
        jf.add(l7);
        
        t7 = new JTextField(20);
        
        tabtype = new JComboBox();
        tabtype.addItem("--type--");
        tabtype.addItem("Tablet");
        tabtype.addItem("Capsule");
        tabtype.addItem("Syrup");
        tabtype.addItem("Insulin");
        tabtype.addItem("Cream");
        tabtype.addItem("Balm");
        tabtype.addItem("Drop");
        tabtype.addItem("Granul");
        tabtype.addItem("Oil");
        tabtype.addItem("Powder");
        tabtype.setBounds(920,100,100,25);
        tabtype.setToolTipText("Select medicine type");
        jf.add(tabtype);
        tabtype.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                tabt =(String)tabtype.getSelectedItem();
                t7.setText(tabt);
            }
        });

        l8 = new JLabel("Medicine purchase price*");
        l8.setBounds(670,140,220,25);
        jf.add(l8);

        t8 = new JTextField(20);
        t8.setBounds(920,140,100,25);t8.setToolTipText("Enter medicine purchase price");
        jf.add(t8);

        l9 = new JLabel("Medicine sale price*");
        l9.setBounds(670,180,200,25);
        jf.add(l9);

        t9 = new JTextField(20);
        t9.setBounds(920,180,100,25);t9.setToolTipText("Enter medicine sale price");
        jf.add(t9);

        l10 = new JLabel("Medicine rack no*");
        l10.setBounds(670,220,200,25);
        jf.add(l10);

        t10 = new JTextField(20);
        t10.setBounds(920,220,100,25);t10.setToolTipText("Enter medicine rack no");
        jf.add(t10);

        l11 = new JLabel("Supplier name*");
        l11.setBounds(670,260,250,25);
        jf.add(l11);
        t11 = new JTextField(20);
        t12 = new JTextField(20);

        msname = new JComboBox();
        msname.setBounds(920,260,130,25);msname.setToolTipText("select medicine supplier name");
        jf.add(msname);
        msname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                s =(String)msname.getSelectedItem();
                t11.setText(s);
            }
        });

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store", "root", "");
            System.out.println("Connected to database.");
            ps = con.prepareStatement("select sid, sname from supplier");
            rs = ps.executeQuery();
            while(rs.next()) {
                sid1 = rs.getString(1);
                String sname1 = rs.getString(2);
                msname.addItem(sname1);
            }
            con.close();
        }
        catch(SQLException se)
        {
            System.out.println(se);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        b0 = new JButton("Open", new ImageIcon("images/open.png"));
        b0.setBounds(350,330,110,35);
        b0.setToolTipText("click to open medicine details");
        jf.add(b0);
        b0.addActionListener(this);

        b1 = new JButton("Update", new ImageIcon("images/update.png"));
        b1.setBounds(500,330,110,35);
        b1.setToolTipText("click to update medicine details");
        jf.add(b1); 
        b1.addActionListener(this);

        b2= new JButton("Clear", new ImageIcon("images/clear.png"));
        b2.setBounds(650,330,110,35);
        b2.setToolTipText("click to clear all textfields");
        jf.add(b2); 
        b2.addActionListener(this);

    	b3 = new JButton("All", new ImageIcon("images/all.png"));
        b3.setBounds(800,330,110,35);
        b3.setToolTipText("click to view all medicine details");
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

        ImageIcon img = new ImageIcon("images/7.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setText("BACK");
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.validate();
        jf.repaint();
        jf.setTitle("Update Medicine ");     
}

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b0) {
        if(((t1.getText()).equals(""))&&((t2.getText()).equals(""))) {
            JOptionPane.showMessageDialog(this,"Please enter medicine batchno or name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
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

                ps = con.prepareStatement("select * from medicine where mname like '%" + t2.getText() + "%' and mbno like '%" + t1.getText() + "%' ");
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
    } else if(ae.getSource() == b1) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
            System.out.println("Connected to database.");
            ps=con.prepareStatement("Select sid from supplier where sname='"+s+"'");
            rs=ps.executeQuery();
            while(rs.next())
{
                String sid1=rs.getString(1);
                t12.setText(sid1);
            }
            if(((t1.getText()).equals(""))||((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((t6.getText()).equals(""))||((t7.getText()).equals(""))||((t8.getText()).equals(""))||((t9.getText()).equals(""))||((t10.getText()).equals(""))||((t11.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
            } else {
                stmt=con.createStatement();
                String str1="UPDATE medicine SET mbno='"+t1.getText()+"',mname='"+t2.getText()+"',mcompany='"+t3.getText()+"',mqty='"+t4.getText()+"',mexpdate='"+t5.getText()+"',mpurdate='"+t6.getText()+"',mtype='"+t7.getText()+"',mpurprice='"+t8.getText()+"',msaleprice='"+t9.getText()+"',mrackno='"+t10.getText()+"',sid='"+t12.getText()+"',sname='"+t11.getText()+"' where mbno='"+t1.getText()+"'or mname='"+t2.getText()+"'";
                stmt.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "Record is updated");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
                t12.setText("");
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
    } else if(ae.getSource() == b2) { 
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            scrlPane.hide();
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t7.setText("");
            t8.setText("");
            t9.setText("");
            t10.setText("");
            t11.setText("");
            t12.setText("");
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


