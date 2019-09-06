package cn.com.state;

public class TestUnsafe2 {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚礼金");
        Drawing you = new Drawing(account,80,"悲伤的你");
        Drawing wife = new Drawing(account,90,"快乐的她");
        you.start();
        wife.start();
    }
}

class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }


}
//模拟取款
class Drawing extends Thread {
    Account account; //取钱的账户
    int drawingMoney; //取的钱数
    int packetTotal; //口袋钱总数
    public Drawing(Account account,int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    @Override
    public void run() {
        if (account.money - drawingMoney < 0) {
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money= account.money - drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName()+"-->账户余额为："+account.money);
        System.out.println(this.getName()+"-->口袋的钱为："+packetTotal);
    }

}
