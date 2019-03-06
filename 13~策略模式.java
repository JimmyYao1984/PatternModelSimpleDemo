//策略模式 算法家族
//销售月卡
public abstract class Strategy{
	public abstract void sellCard();
} 

public class OneMonthStrategy extends Strategy{
	@Override
	public void sellCard(){
		System.out.println("一个月的月卡优惠5元");
	}
}

public class ThreeMonthStrategy extends Strategy{
	@Override
	public void sellCard(){
		System.out.println("三个月的月卡优惠10元");
	}
}

public class OneYearStrategy extends Strategy{
	@Override
	public void sellCard(){
		System.out.println("一年的月卡优惠50元");
	}
}

//包月充值服务
public class ChargeCardService{
	private Strategy strategy;

	public void charge(String month){
		switch(month){
			case "一个月":
				strategy = new OneMonthStrategy();
			break;

			case "三个月":
				strategy = new ThreeMonthStrategy();
			break;

			case "一年":
				strategy = new OneYearStrategy();
			break;
		}
	}
}

public static void main(String[] args){
	ChargeCardService chargeCardService = new ChargeCardService();
	chargeCardService.charge("一个月");
	chargeCardService.charge("一年");
}
