//享元模式
//单车部件
public class BikeComponent {
    public String name;
}

//刹车部件
public class Brake extends BikeComponent {
    public String name = "刹车";
}

//凳子
public class Seat extends BikeComponent {
    public String name = "凳子";
}

//车轮
public class Wheel extends BikeComponent {
    public String name = "车轮";
}

//这个简单工厂不算享元模式的部分，就为了生成零件方便
public class BikeComponentFactory{
    public static BikeComponent create(String name){
        if("刹车".equals(name)){
            return new Brake();
        }else if("凳子".equals(name)){
            return new  Seat();
        }else if("车轮".equals(name)){
            return new Wheel();
        }else{
            return null;
        }
    }
}

public class BikeRepairFactory{
    private static final HashMap<String, BikeComponet> oldComponent = new HashMap();

    public static void repair(BikeComponent badComponent){
        BikeComponent goodComponent = oldComponent.get(badComponent.name);
        if(goodComponent == null){
            goodComponent = BikeComponentFactory.create(badComponent.name);
            oldComponent.put(badComponent.name, badComponent);
            System.out.println("没有旧的修好的零件，需要生成新的零件: " + goodComponent.name);
        }else{
            System.out.println("旧的修好的零件，直接换: " + goodComponent.name + " 不用生产节约成本");
        }
    }
}

public static void main(String[] args){
    BikeComponent badBrakeComponet = new Brake();
    BikeRepairFactory.repair(badBrakeComponet);

    BikeComponent badBrakeComponent2 = new Brake();
    BikeRepairFactory.repair(badBrakeComponent2);
}
