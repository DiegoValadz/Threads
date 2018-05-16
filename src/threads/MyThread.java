package threads;

import javax.swing.JProgressBar;

public class MyThread extends Thread {

    private static int ATRASO = 500;
    JProgressBar progressBar;

    public MyThread(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }
    
    public void run() {
        int minimum = progressBar.getMinimum();
        int maximum = progressBar.getMaximum();
        for (int i = minimum; i < maximum; i++) {
            try {
                int value = progressBar.getValue();
                progressBar.setValue(value + 1);
                Thread.sleep(ATRASO);
            } catch (InterruptedException e) {
            }
        }
    }
}
