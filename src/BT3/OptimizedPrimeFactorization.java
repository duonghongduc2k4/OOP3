package BT3;

import java.util.Scanner;

public class OptimizedPrimeFactorization implements Runnable{
    private int number;

    private boolean isPrime(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số: ");
        number = sc.nextInt();
        if (number <= 1) {
            System.out.println("Ko phải số NT");

            return false;

        }
        for (int i = 2; i <=Math.sqrt(number) ; i++) {
            if (number%i == 0) {
                System.out.println("Ko phải số NT");

                return false;
            }
            return true;

        }
        return true;
    }
    @Override
    public void run() {
        while (true){
            if (isPrime()) {
                System.out.println("Số NT: "+number);
            }
            number++;
        }
    }
}
