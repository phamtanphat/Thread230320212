import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class main {
    public static void main (String[] args) throws Exception{
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                handleLogic("A");
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                handleLogic("B");
            }
        });
        threadA.start();
        threadB.start();

        // xử đồng bộ mỗi lần chạy chỉ  1 thread chạy
    }
    private synchronized static void handleLogic(String name){
        for (int i = 0; i < 200 ; i++) {
            System.out.println(name + " " + i);
        }
    }
}
