package medical_store;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import static medical_store.Index.jf;

public class SupplierList extends JFrame {
    JLabel ln;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    public SupplierList() {
        jf.setLayout(null);
        ln = new JLabel("List Of Supplier Details");
        ln.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20)); 
        ln.setForeground(new java.awt.Color(51, 153, 255));
        ln.setBounds(500,30,300,40);
        jf.add(ln);

        scrlPane.setBounds(5, 130, 1225, 345);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("S_ID");
        model.addColumn("S_NAME");
        model.addColumn("S_Address");
        model.addColumn("S_PhNo");
        model.addColumn("S_EmailId");

        int r = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
            System.out.println("Connected to database.");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from supplier");
            while(rs.next()) {
                model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
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
        
        ImageIcon img = new ImageIcon("images/4.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setText("BACK");
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.setTitle("Supplier List");
        jf.validate();
        jf.repaint();
    }
}

