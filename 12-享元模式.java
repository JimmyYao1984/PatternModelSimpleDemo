//享元模式 
//单车部件
public class BikeComponent{
	public String name;
}


//刹车部件
public class Brake extends BikeComponent{
	public String name = "刹车";
}

//凳子
public class Seat extends BikeComponent{
	public String name = "凳子";
}

//车轮
public class Wheel extends BikeComponent{
	public String name = "车轮";
}

//这个简单工厂不算享元模式的部分，就为了生成零件方便
public class BikeComponentFactory{
	public static BikeComponent create(String name){
		if("刹车".equals(name)){
			return new Brake();
		}else if("凳子".equals(name)){
			return new Seat();
		}else if("车轮".equals(name)){
			return new Wheel();
		}else{
			return null;
		}
	}
}

public class BikeRepairFactory{
	private static final HashMap<String,BikeComponent> oldComponents = new HashMap();

	public static void repair(BikeComponent badComponent){
		BikeComponent goodComponet = oldComponents.get(badComponent.name);
		if(goodComponet == null){
			goodComponet = BikeComponentFactory.create(badComponent.name);
			oldComponents.put(badComponent.name, badComponent);
			System.out.print("没有旧的修好的零件，需要生产新的零件:"+goodComponet.name);
		}else{
			System.out.print("旧的修好的零件，直接换:"+goodComponet.name + "不用生产节约成本");
		}
	}
}

public static void main(Stirng[] args){
	BikeComponent badBrakeCommponent = new Brake();
	BikeRepairFactory.repair(badComponent);

	BikeComponent badBrakeCommponent2 = new Brake();
	BikeRepairFactory.repair(badComponent);
}
