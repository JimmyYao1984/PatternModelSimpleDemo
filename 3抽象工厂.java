//抽象工厂模式
public abstract class Bike{
	public abstract void drive();
}

public abstract class Car{
	public abstract void drive();
}

//滴滴共享单车
public class DidiBike extends Bike{
	public void drive(){
		System.out.println("骑滴滴的共享单车");
	}
}

//滴滴共享汽车
public class DidiCar extends Car{
	public void drive(){
		System.out.println("开滴滴共享汽车");
	}
}

//摩拜单车
public class Mobike extends Bike{
	public void drive(){
		System.out.println("骑摩拜单车");
	}
}

//产品线可以扩展，汽车、单车....
public interface SharedVehicleFactory{
	Bike getBike();
	Car getCar();
}

//滴滴生成的汽车和单车是同一个产品族
public class DidiFactory implements SharedVehicleFactory{
	@Override
	public Bike getBike(){
		Bike bike = new DidiBike();
		return bike;
	}

	@Override
	public Car getCar(){
		Car car = new DidiCar();
		return car;
	}
}

public class MobikeFactory implements SharedVehicleFactory{
	@Override
	public Bike getBike(){
		Bike bike = new Mobike();
		return bike;
	}

	@Override
	public Car getCar(){
		return null;
	}
}

public static void main(String[] args) {
	SharedVehicleFactory sharedVehicleFactory = new DidiFactory();
	sharedVehicleFactory.getBike().drive();
	sharedVehicleFactory.getCar().drive();

}
