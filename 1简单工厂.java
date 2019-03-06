//简单工厂模式
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

//简单工厂
public class BikeFactory{
	public Bike getBike(Class c){
		Bike bike = null;
		try{
			bike = (Bike)Class.forName(c.getName()).newInstance();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return bike;
	}
}

public static void main(String[] args) {
    BikeFactory bikeFactory = new BikeFactory();
    
    Bike bike = bikeFactory.getBike(Mobike.class);
    bike.drive();

    bike = bikeFactory.getBike(OfoBike.class);
    bike.drive();
}
