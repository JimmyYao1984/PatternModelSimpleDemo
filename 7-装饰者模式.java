//装饰者模式 保持原有系统不变的情况下 附加其他功能
public abstract class ABikeProduce{
	protected abstract String getDesc();
	protected abstract int cost();
}

public class Bike extends ABikeProduce{
	@Override
	protected String getDesc{
		return "一辆普通的自行车";
	}

	@Override
	protected int cost(){
		return 100;
	}
}

public class ABikeProduceDecorator extends ABikeProduce{
	private ABikeProduce aBikeProduce;

	public ABikeProduceDecorator(ABikeProduce aBikeProduce){
		this.aBikeProduce = aBikeProduce;
	}

	@Override
	protected String getDesc{
		return this.aBikeProduce.getDesc();
	}

	@Override
	protected int cost(){
		return this.aBikeProduce.cost();
	}
}

//刹车系统装饰器
public class BrakeProduceDecorate extends ABikeProduceDecorator{
	public BrakeProduceDecorate(ABikeProduce aBikeProduce){
		super(aBikeProduce);
	}

	@Override
	protected String getDesc(){
		return super.getDesc() + " 增加一个牛逼的刹车系统";
	}

	@Override
	protected int cost(){
		return super.cost() + 20;
	}
}

public class GpsProduceDecorate extends ABikeProduceDecorator{
	public GpsProduceDecorate(ABikeProduce aBikeProduce){
		super(aBikeProduce);
	}

	@Override
	protected String getDesc(){
		return super.getDesc() + " 安装GPS定位系统";
	}

	@Override
	protected int cost(){
		return super.cost() + 50;
	}
}

public class SeatProduceDecorate extends ABikeProduceDecorator{
	public SeatProduceDecorate(ABikeProduce aBikeProduce){
		super(aBikeProduce);
	}

	@Override
	protected String getDesc(){
		return super.getDesc() + " 换一个蛋不疼的舒服车凳";
	}

	@Override
	protected int cost(){
		return super.cost() + 10;
	}
}

public static void main(String[] args){
	ABikeProduce bike = new Bike();
	bike = new GpsProduceDecorate(bike);
	bike = new SeatProduceDecorate(bike);
	bike = new BrakeProduceDecorate(bike);
	System.out.println(bike.getDesc() + " 总费用：" + bike.cost());
}
