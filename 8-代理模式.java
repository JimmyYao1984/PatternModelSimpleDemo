//代理模式 访问控制
public class Account{
}

public interface Driveable{
	void drive();
}

//没有账户不让骑
public Bike implements Driveable{
	public Account account;

	@Override
	public void drive(){
		if(account == null){
			return;
		}
		System.out.println("骑单车")
	}
}

//代理有账户
public Proxy implement Driveable{
	private Bike bike;

	public Proxy(Bike bike){
		this.bike = bike;
	}

	@Override
	public void drive(){
		bike.account  = new Account();
		bike.drive();
	}

}

public static void main(String[] args){
	Driveable driveable = new Proxy(new Bike());
	driveable.drive();
}
