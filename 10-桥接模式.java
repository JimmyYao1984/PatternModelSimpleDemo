//桥接模式 强调的是两个纬度扩展
public interface Account{
	void deposit();
}

public abstract class Bike{
	protected Account account; //账户
	public abstract void drive();
	public void register(Account account){
		this.account = account;
	}
}

public class MoBike extends Bike{
	@Override
	public void drive(){
		account.deposit();
		System.out.println("骑摩拜单车");
	}
}

public class OfoBike extends Bike{
	@Override
	public void drive(){
		//收押金
		account.deposit();
		System.out.println("骑小黄车");
	}
}


public class ZhimaCreditAccount implements Account{
	void deposit(){
		System.out.println("芝麻信用免受押金");
	}
}

public class NinetynineAccount implements Account{
	void deposit(){
		System.out.println("99元押金");
	}
}

public class TwoHundredAndNinetyNineAccount implements Account{
	void deposit(){
		System.out.println("299元押金");
	}
}

public static void main(String[] args){
	Bike bike = new MoBike();
	Account account = new ZhimaCreditAccount();
	bike.register(account);
	bike.drive();

	Bike bike2 = new OfoBike(); 
	Account account2 = new NinetynineAccount();
	bike2.register(account2);
	bike2.drive();
}

