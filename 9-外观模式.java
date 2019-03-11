//外观模式 只与高层结构发生交互 不与子系统发生交互
public class Account{
	public boolean isRegister;
	public boolean isDeposited;
	public boolean isBlackList;

	public Account(boolean isRegister,boolean isDeposited,boolean isBlackList){
		this.isRegister = isRegister;
		this.isDeposited = isDeposited;
		this.isBlackList = isBlackList;
	}
}

//注册业务子系统
public class RegisterService{
	public boolean hasRegistered(Account account){
		System.out.println("校验此账户是否注册过");
		return account.isRegister;
	}
}

//押金业务子系统
public class DepositService{
	public boolean hasDeposited(Account account){
		System.out.println("校验此账户是否已交押金");
		return account.isDeposited;
	}
}

//黑名单子系统
public class BlackListService{
	public boolean hasOnBlackList(Account account){
		System.out.println("校验此账户是否在黑名单上");
		return account.isBlackList;
	}
}

public class Bike{
	private RegisterService registerService = new RegisterService();
	private DepositService depositService = new DepositService();
	private BlackListService blackListService = new BlackListService();

	public void drive(Account account){
		if(!registerService.hasRegistered(account)){
			System.out.println("你的账户还没有注册，不能骑");
			return;
		}
		if(!depositService.hasDeposited(account)){
			System.out.println("你的账户还没有交押金，不能骑");
			return;
		}
		if(blackListService.hasOnBlackList(account)){
			System.out.println("你是个黑户，不能骑");
			return;
		}
		System.out.println("高高兴兴骑上单车了");
	}
}

public static void main(String[] args){
	Bike bike = new Bike();
	Account account = new Account(true, true, false);
	bike.drive(account);
}
