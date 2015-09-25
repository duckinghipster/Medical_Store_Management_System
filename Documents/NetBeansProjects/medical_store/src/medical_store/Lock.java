package medical_store;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static medical_store.Index.jf;

public class Lock extends JFrame implements ActionListener {
    JPasswordField t2;
    Lock() {  
        jf.setLayout(null);
        
        JLabel l1 = new JLabel("MEDICAL STOCK MANAGEMENT SYSTEM");
        l1.setFont(new Font("Berlin Sans FB Demi", 1, 30)); 
        l1.setForeground(new java.awt.Color(51, 153, 255));
        l1.setBounds(380,50,600,40);
        jf.add(l1);
        
        t2 = new JPasswordField(30);
        t2.setBounds(550,250,200,30);
        t2.setToolTipText("Enter Unlock code");
        jf.add(t2);
        
        JButton b0 = new JButton("Unlock",new ImageIcon("images/Unlock.png"));
        b0.setBounds(595,320,110,30);
        b0.setToolTipText("click to unlock");
        jf.add(b0);
        b0.addActionListener(this);
        
        JLabel l2 = new JLabel("Copyright © 2014 - Designed and Developed By: Shubham Nanda");
        l2.setFont(new Font("Arial", Font.BOLD, 15)); 
        l2.setForeground(Color.black);
        l2.setBounds(450,630,600,40);
        jf.add(l2);
        
        ImageIcon img = new ImageIcon("images/3.jpg");
        JLabel j = new JLabel();
        j.setIcon(img);
        j.setText("BACK");
        j.setPreferredSize(new java.awt.Dimension(1250, 700));
        jf.add(j);
        j.setBounds(0, 0, 1250, 700);
        
        jf.validate();
        jf.repaint();
        jf.setTitle("LOCK SCREEN");
    }
    
    public void actionPerformed(ActionEvent e) {
        if (t2.getText().equals("admin")) {
            jf.getContentPane().removeAll();
            new Main_Menu();
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect password !","Warning!!!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
