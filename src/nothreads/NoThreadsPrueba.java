package nothreads;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NoThreadsPrueba {

    JButton btn, btn2;
    JProgressBar pgb[];
    JFrame frame;
    JPanel panel;
    JTextField campo;
    NoThreadsListener listener;
    String msg;
    int inc1, inc2 = 0;

    public NoThreadsPrueba() {
        frame = new JFrame("JProgressBar - With Threads");
        panel = new JPanel(new FlowLayout());
        listener = new NoThreadsListener(this);
        pgb = new JProgressBar[2];
        campo = new JTextField("Esto no es posible");
        btn = new JButton("Start");
        btn2 = new JButton("Imprimir Texto");
        pgb[0] = new JProgressBar(SwingConstants.HORIZONTAL, 0, 20);
        pgb[1] = new JProgressBar(SwingConstants.HORIZONTAL, 0, 20);
    }

    public void meta() {
        msg = "Programa que ejecuta componentes de tipo JProgressBar";
        msg += " sin hacer uso de hilos";
        JOptionPane.showMessageDialog(frame, msg);
    }

    public void addComponents() {
        for (int i = 0; i < 2; i++) {
            pgb[i].setValue(0);
            pgb[i].setStringPainted(true);
        }
        btn.addActionListener(listener);
        btn2.addActionListener(listener);
        panel.add(pgb[0]);
        panel.add(btn);
        panel.add(pgb[1]);
        panel.add(campo);
        panel.add(btn2);
        frame.add(panel);
    }

    public void launchFrame() {
        frame.setLocationRelativeTo(null);
        frame.setSize(750, 85);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void ejecutarProgressBar(int selector) {
        int ATRASO = 500;
        int minimum = pgb[selector].getMinimum();
        int maximum = pgb[selector].getMaximum();
        for (int i = minimum; i < maximum; i++) {
            try {
                int value = pgb[selector].getValue();
                pgb[selector].setValue(value + 1);
                Thread.sleep(ATRASO);
            } catch (InterruptedException ignoredException) {
            }
        }
        //pgb[selector].setValue(0);
    }

    public static void main(String[] args) {
        NoThreadsPrueba prueba = new NoThreadsPrueba();
        prueba.meta();
        prueba.addComponents();
        prueba.launchFrame();
        prueba.ejecutarProgressBar(1);
    }
}
