//模板方法模式
public abstract class ABike{
    protected final void makeBike(){
        this.makeBody();
        this.makeSeat();
        this.makeBrake();
        this.makeWheel();
        this.makeColor();
    }

    final void makeBody(){
        System.out.println("制造车架");
    }

    final void makeSeat(){
        System.out.println("制造凳子");
    }

    final void makeBrake(){
        System.out.println("制造刹车系统");
    }

    abstract void makeColor();
}

public class Mobike extends ABike{
    @Override
    void makeColor(){
        System.out.prinltn("喷上迷人的红色");
    }
}

public class OfoBike extends ABike{
    @Override
    void makeColor(){
        System.out.println("碰骚气的红色")
    }
}
