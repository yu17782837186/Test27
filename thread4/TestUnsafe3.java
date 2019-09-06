package cn.com.state;

import java.util.ArrayList;
import java.util.List;
//操作容器  存在改的情况下需要线程安全，读，拷贝的情况下不一定需要控制线程安全
public class TestUnsafe3 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            new Thread(()->{
//                list.add(Thread.currentThread().getName());
//            }).start();
//        }
//        System.out.println(list.size());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()-> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
