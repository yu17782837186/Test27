package cn.com.state;
//模拟购票
public class TestUnsafe implements Runnable{
//    private int ticketNum = 10;
//    private boolean flag =  true;
//
//    @Override
//    public void run() {
//        while(flag) {
//            test();
//        }
//    }
//    public void test() {
//        if (ticketNum < 0) {
//            this.flag = false;
//            return;
//        }
//        try {
//            Thread .sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"-->"+ticketNum--);
//    }
//    public static void main(String[] args) {
//        TestUnsafe t = new TestUnsafe();
//        new Thread(t,"小明").start();
//        new Thread(t,"小红").start();
//        new Thread(t,"小亮").start();
//    }
    private int ticketNum = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while(flag) {
            test();
        }
    }
    public void test() {
        if (ticketNum < 0) {
            this.flag = false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticketNum--);
    }

    public static void main(String[] args) {
        TestUnsafe t = new TestUnsafe();
        new Thread(t,"小明").start();
        new Thread(t,"小亮").start();
        new Thread(t,"小军").start();
    }
}
