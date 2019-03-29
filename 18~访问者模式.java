//访问者模式 数据结构与数据操作分离
public abstract class Bike{
    public abstract void accept(IVisitor visitor);
}

public Mobike extends Bike{
    @Override
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }
}

public MobikeLite extends Bike{
    @Override
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }
}

public interface IVisitor{
    void visit(Mobike mobike);
    void visit(MobikeLite mobikelite);
}

//普通用户
public class Customer implements IVisitor{
    @Override
    public void visit(Mobike mobike){
        System.out.println("普通用户只能骑单车，每次1元");
    }

    @Override
    public void visit(MobikeLite litebike){
        System.out.println("普通用户只能骑单车，每次5角");
    }
}

//修理人员
public class Repairer implements IVisitor{
    @Override
    public void visit(Mobike mobike){
        System.out.println("修理这种车比较耗时");
    }

    @Override
    public void visit(MobikeLite litebike){
        System.out.println("修理这种车比较费力");
    }
}

public static void main(String[] args){
    List<Bike> bikes = new ArrayList<Bike>();
    bikes.add(new Mobike());
    bikes.add(new MobikeLite());

    //创建普通用户访问者
    Customer customer = new Customer();
    for(Bike bike : bikes){
        bike.accept(customer);
    }

    //创建修理工访问者
    Repairer worker = new Repairer();
    for(Bike bike : bikes){
        bike.accept(bike);
    }
}
