package TH5;

public class Main {
    public static void main(String[] args) {
        CountdownRunnable countdownRunnable = new CountdownRunnable();
        Thread countdownThread = new Thread(countdownRunnable);
        countdownThread.start();
    }

}
