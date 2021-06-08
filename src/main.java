

public class main {
    static int a = 0, b = 0, c = 0;

    public static void main(String[] args) throws Exception {
        MyFlag myFlag = new MyFlag(0);

//        0 => A chạy;
//        1 => B chạy;
//        2 => C chạy;

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag) {
                    for (int i = 1; i <= 50;) {
                        if (myFlag.count == 0) {
                            a = i;
                            System.out.println("A = " + a);
                            myFlag.count = 1;
                            myFlag.notifyAll();
                            i++;
                        } else {
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag) {
                    for (int i = 1; i <= 50;) {
                        if (myFlag.count == 1) {
                            b = i;
                            System.out.println("B = " + b);
                            myFlag.count = 2;
                            myFlag.notifyAll();
                            i++;
                        } else {
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag) {
                    for (int i = 1; i <= 50;) {
                        if (myFlag.count == 2) {
                            c = a + b;
                            System.out.println("C = " + c);
                            myFlag.count = 0;
                            myFlag.notifyAll();
                            i++;
                        } else {
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
