package medical_store;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;

public class PrintUIWindow implements Printable{
    //JFrame frameToPrint;
    JScrollPane frameToPrint;
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) { 
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        frameToPrint.printAll(g);

        return PAGE_EXISTS;
    }

    public PrintUIWindow(JScrollPane scrlPane) {
        //frameToPrint = f;
        frameToPrint = scrlPane;
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                System.out.println(ex);
            }
        }
    }
}