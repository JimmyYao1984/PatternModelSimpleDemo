//代理模式，访问控制
public class Account {

}

public interface Drivable {
    void drive();
}

//没有账户不让骑
public class Bike implements Drivable {
    public Account account;

    @Override
    public void drive() {
        if (account == null) {
            return;
        }
        System.out.println("骑单车");
    }
}

//代理有账户
public class Proxy implements Drivable {
    private Bike bike;

    public Proxy(Bike bike){
        this.bike = bike;
    }

    @Override
    public void drive(){
        bike.account = new Account();
        bike.drive();
    }
}

public static void main(String[] args){
    Drivable drivable = new Proxy(new Bike());
    drivable.drive();
}
