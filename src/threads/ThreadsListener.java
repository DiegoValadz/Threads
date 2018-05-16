package threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadsListener implements ActionListener {

    ThreadsPrueba tp;

    public ThreadsListener(ThreadsPrueba tp) {
        this.tp = tp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == tp.btn) {
            tp.inc1 = 0;
            MyThread thread = new MyThread(tp.pgb[0]);
            thread.start();
        } else if (ae.getSource() == tp.btn2) 
            System.out.println(tp.campo.getText());
    }
}
