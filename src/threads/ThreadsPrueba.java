package threads;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ThreadsPrueba {

    JButton btn, btn2;
    JProgressBar pgb[];
    JFrame frame;
    JPanel panel;
    JTextField campo;
    ThreadsListener listener;
    String msg;
    int inc1, inc2 = 0;

    public ThreadsPrueba() {
        frame = new JFrame("JProgressBar - With Threads");
        panel = new JPanel(new FlowLayout());
        listener = new ThreadsListener(this);
        pgb = new JProgressBar[2];
        campo = new JTextField("Esto es posible gracias a los hilos");
        btn = new JButton("Start");
        btn2 = new JButton("Imprimir Texto");
        pgb[0] = new JProgressBar(SwingConstants.HORIZONTAL, 0, 20);
        pgb[1] = new JProgressBar(SwingConstants.HORIZONTAL, 0, 20);
    }

    public void meta() {
        msg = "Programa que ejecuta componentes de tipo JProgressBar";
        msg += " simultaneamente haciendo uso de hilos";
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

    public void ejecutarProgressBar() {
        MyThread threadP = new MyThread(pgb[1]);
        threadP.start();
    }

    public static void main(String[] args) {
        ThreadsPrueba prueba = new ThreadsPrueba();
        prueba.meta();
        prueba.ejecutarProgressBar();
        prueba.addComponents();
        prueba.launchFrame();
    }

}
