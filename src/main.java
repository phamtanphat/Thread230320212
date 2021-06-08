import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class main {
    static int a = 0 ,b = 0 , c = 0;
    public static void main (String[] args) throws Exception{
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50 ; i++) {
                    a = i;
                    System.out.println("A = " + a);
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50 ; i++) {
                    b = i;
                    System.out.println("B = " + b);
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50 ; i++) {
                    c = a + b;
                    System.out.println("C = " + c);
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
