package medical_store;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import static medical_store.Index.jf;

public class SupplierWiseMedList extends JFrame implements ActionListener {
    JButton submit, clear, print;
    JComboBox msname;
    String s,sname;
    JLabel l1, ln;
    JTextField t1 = new JTextField();
    Font f;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    public SupplierWiseMedList() {
        f = new Font("Times New Roman",Font.BOLD,20);
        jf.setLayout(null);
        
        ln = new JLabel("Supplier wise Medicine report");
        ln.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30)); 
        ln.setForeground(new java.awt.Color(51, 153, 255));
        ln.setBounds(450,50,400,40);
        jf.add(ln);

        l1 = new JLabel("Enter Supplier name:");
        l1.setBounds(350,150,250,25);
        jf.add(l1);

        msname = new JComboBox();
        msname.setBounds(650,150,150,25);
        msname.setToolTipText("select medicine supplier name");
        jf.add(msname);
        msname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                s = (String)msname.getSelectedItem();
                t1.setText(s);
            }
        });

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store", "root", "");
            System.out.println("Connected to database.");
            ps = con.prepareStatement("select sname from supplier");
            rs = ps.executeQuery();
            while(rs.next()) {
                sname = rs.getString(1);
                msname.addItem(sname);
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


        submit = new JButton("Submit",new ImageIcon("images/open.png"));
        submit.setBounds(400,230,110,35); 
        submit.setToolTipText("click to open daily purchase report");
        jf.add(submit);
        submit.addActionListener(this);

        clear = new JButton("Clear",new ImageIcon("images/clear.png"));
        clear.setBounds(600,230,110,35);
        clear.setToolTipText("click to clear textfield");
        jf.add(clear);
        clear.addActionListener(this);
        
        print = new JButton("Print",new ImageIcon("images/save.png"));
        print.setBounds(800,230,110,35);
        print.setToolTipText("click to clear textfield");
        jf.add(print);
        print.addActionListener(this);

        scrlPane.setBounds(5,330,1225,200);
        jf.add(scrlPane);scrlPane.hide();
        tabGrid.setFont(new Font ("Times New Roman",0,15));

   	model.addColumn("S_ID");
   	model.addColumn("S_NAME");
  	model.addColumn("M_BNO");
  	model.addColumn("M_NAME");
  	model.addColumn("M_EXPDATE");
  	model.addColumn("M_QTY");
  	model.addColumn("M_PURPRICE");
  	model.addColumn("M_SALEPRICE");
        
  	ln = new JLabel("Supplier wise Medicine report");
        ImageIcon img = new ImageIcon("images/5.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setText("BACK");
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.validate();
        jf.repaint();

        jf.setTitle("Supplier Wise Medicine Report");
    }

public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==submit) {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        scrlPane.show();
  	int r = 0;
        try {
            if(((t1.getText()).equals(""))) {
                JOptionPane.showMessageDialog(this,"Please supplier name !","Warning!!!",JOptionPane.WARNING_MESSAGE);
            } else {
                int foundrec = 0;
                Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("SELECT sid,sname,mbno,mname,mexpdate,mqty,mpurprice,msaleprice from medicine where sname='"+t1.getText()+"' ");
                while(rs.next()) {
                    model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
                    foundrec = 1;
                }
                if (foundrec == 0) {
                    JOptionPane.showMessageDialog(null,"Not any medicine provide by given supplier","Dialog",JOptionPane.WARNING_MESSAGE);
                }
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
    } else if(ae.getSource() == clear) {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        scrlPane.hide();
        //t1.setText("");
    } else if(ae.getSource() == print) {
        new PrintUIWindow(scrlPane);
    }
}
}
