package nothreads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoThreadsListener implements ActionListener {

    NoThreadsPrueba ntp;

    public NoThreadsListener(NoThreadsPrueba ntp) {
        this.ntp = ntp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ntp.btn) {
            ntp.inc1 = 0;
            ntp.pgb[0].setValue(0);
            ntp.ejecutarProgressBar(0);
        } else if (ae.getSource() == ntp.btn2) 
            System.out.println(ntp.campo.getText());
    }
}
