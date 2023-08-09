package TH3;

public class Main {
    public static void main(String[] args) {
        EvenNumbersRunnable evenNumbersRunnable = new EvenNumbersRunnable();
        Thread evenThread = new Thread(evenNumbersRunnable);
        evenThread.start();
    }
}
