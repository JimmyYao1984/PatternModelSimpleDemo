//建造者模式
public abstract class Bike{
	private String wheel; //车轮
	private String brake; //刹车
	private String color; //车外观色

	public String getWheel(){
		return wheel;
	}

	public void setWheel(String wheel){
		this.wheel = wheel;
	}

	public String getBrake(){
		return brake;
	}

	public void setBrake(String brake){
		this.brake = brake;
	}

	public String getColor(){
		return color;
	}

	public void setColor(String color){
		this.color = color;
	}
}

public abstract class BikeBuildFactory{
	public abstract BikeBuildFactory makeWheel(String wheel);
	public abstract BikeBuildFactory makeBrake(String brake);
	public abstract BikeBuildFactory makeColor(String color);
	public abstract Bike build();
}

public class MobikeBuildFactory extends BikeBuildFactory{
	private Bike bike;
	public MobikeBuildFactory(){
		bike = new Bike();
	}

	public BikeBuildFactory makeWheel(String wheel){
		bike.setWheel(wheel);
		return this;
	}

	public BikeBuildFactory makeBrake(String brake){
		bike.setBrake(brake);
		return this;
	}

	public BikeBuildFactory makeColor(String color){
		bike.setColor(color);
		return this;
	}

	public Bike build(){
		return bike;
	}
}

public class OfoBuildFactory extends BikeBuildFactory{
	private Bike bike;
	public OfoBuildFactory(){
		bike = new Bike();
	}

	public BikeBuildFactory makeWheel(String wheel){
		bike.setWheel(wheel);
		return this;
	}

	public BikeBuildFactory makeBrake(String brake){
		bike.setBrake(brake);
		return this;
	}

	public BikeBuildFactory makeColor(String color){
		bike.setColor(color);
		return this;
	}

	public Bike build(){
		return bike;
	}
}

public class Worker{
	public Bike buildMobike(){
		return new MobikeBuildFactory()
				.makeWheel("摩拜车轮2个")
                .makeBrake("摩拜刹车2个")
                .makeColor("红色")
                .build();
	}

	public Bike buildOfoBike(){
        return new OfoBuildFactory()
                .makeColor("黄色")
                .makeWheel("ofo车轮2个")
                .makeBrake("ofo刹车4个")
                .build();
    }
}


public static void main(String[] args) {
	Worker Worker = new Worker();
	Bike bike = Worker.buildMobike();
}
