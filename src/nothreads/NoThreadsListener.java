package nothreads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoThreadsListener implements ActionListener{

    NoThreadsPrueba ntp;

    public NoThreadsListener(NoThreadsPrueba ntp) {
        this.ntp = ntp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String aux = ntp.campo.getText();
          System.out.println(aux);
    }
}
