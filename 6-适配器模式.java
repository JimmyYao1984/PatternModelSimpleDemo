//适配器模式
public abstract class Bike{
	public void drive();
}

public class OfoBike extends Bike{
	public void drive(){
		System.out.println("骑小黄车")；
	}
}


//扫码骑摩拜
public interface ScanMobi{
	void scanMobi();
}

//黑客通过摩拜APP扫码骑其他公司的车
public class HackerAdapter implements ScanMobi{
	void scanMobi(Bike bike){
		bike.drive();
	}
}

public static void main(String[] args){
	HackerAdapter hacker = new HackerAdapter();
	OfoBike bike = new OfoBike();
	//只有摩拜app的扫码接口，照样可以骑小黄车
	hacker.scanMobi(bike);
}
