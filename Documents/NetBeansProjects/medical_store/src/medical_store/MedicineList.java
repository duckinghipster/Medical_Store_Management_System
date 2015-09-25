package medical_store;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import static medical_store.Index.jf;

public class MedicineList extends JFrame {
    JLabel ln;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    public MedicineList() {
        jf.setLayout(null);
        
        ln = new JLabel("Stock Of Medicines");
        ln.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30)); 
        ln.setForeground(new java.awt.Color(51, 153, 255));
        ln.setBounds(500,80,300,40);
        jf.add(ln);

        scrlPane.setBounds(5, 200, 1225, 200);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("Batchno");
        model.addColumn("Name");model.addColumn("Company");
        model.addColumn("Quantity");
        model.addColumn("Type");
        model.addColumn("Purcahasedate");model.addColumn("Expirydate");
        model.addColumn("Purchaseprice");
        model.addColumn("Saleprice");
        model.addColumn("Rackno");
        model.addColumn("Supplierid");
        model.addColumn("suppliername");
                    
        int r = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store","root","");
            System.out.println("Connected to database.");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from medicine");
            while(rs.next()) {
                model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});
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

        ImageIcon img = new ImageIcon("images/6.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setText("BACK");
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        jf.validate();
        jf.repaint();
        jf.setTitle("Medicine List");
    }
}
