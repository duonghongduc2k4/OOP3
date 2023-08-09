package BT3;

public class Main {
    public static void main(String[] args) {
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization();
        Thread thread = new Thread(optimizedPrimeFactorization);

        thread.start();
    }
}
