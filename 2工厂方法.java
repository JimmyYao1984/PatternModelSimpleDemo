//工厂方法模式
public abstract class Bike{
	public abstract void drive();
}

//ofo小黄车
public class OfoBike extends Bike{
	public void drive(){
		System.out.println("骑小黄车");
	}
}

//摩拜单车
public class Mobike extends Bike{
	public void drive(){
		System.out.println("骑摩拜单车");
	}
}

//定义接口，一旦定了接口就不再改变
public abstract class BikeFactory{
	public abstract Bike getBike();
}

public class MobikeFactory extends BikeFactory{
	
	@Override
	public Bike getBike(){
		Bike bike = new Mobike()
		return bike;
	}
}

public class OfoBikeFactory extends BikeFactory{

	@Override
	public Bike getBike(){
		Bike bike = new OfoBike();
		return bike;
	}
}

//扩充不同产品等级，摩拜、小黄车、hello单车
public static void main(String[] args){
	BikeFactory bikeFactory = new MobikeFactory()
	Bike bike = bikeFactory.getBike();
	bike.drive();
}

