package TH2;

public class EvenNumbersThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i+=2) {
            System.out.println(i);
        }
    }
}
