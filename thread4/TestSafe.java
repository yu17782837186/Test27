package cn.com.state;

public class TestSafe implements Runnable{
    private int ticketNum = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while(flag) {
            //Thread.yield();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test();
        }
    }
    //线程安全 同步 成员的方法锁的是this 即这个对象
    public synchronized void test() {
        if (ticketNum <= 0) {
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
        TestSafe ts = new TestSafe();
        new Thread(ts,"小明").start();
        new Thread(ts,"小红").start();
        new Thread(ts,"小亮").start();
    }
}
