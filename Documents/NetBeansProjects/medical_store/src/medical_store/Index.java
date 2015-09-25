package medical_store;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Index {    
    static JFrame jf = new JFrame();
    public static void main(String args[]) {
        new Lock();
        jf.setSize(1250,700);
        jf.setLocation(20, 20);
        //jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
