//状态模式
//上锁 被扫码了 解锁
public abstract class State{
    protected Bike bike;
    public abstract void locked();
    public abstract void scan();
    public abstract void unlock();
    public void setBike(Bike bike){
        this.bike = bike;
    }
}

public class LockState extends State{
    public void locked(){
        System.out.println("车已上锁");
    }

    public void scan(){
        this.bike.setState(Bike.SCAN_STATE);
    }

    public void unlock(){
        System.out.println("ERRROR 上锁的车需要扫码后才能骑");
    }

    public String toString(){
        return "上锁状态";
    }
}

public class ScanState extends State{
    public void locked(){
        this.bike.setState(Bike.LOCK_STATE);
    }

    public void scan(){
        System.out.println("正在扫码");
    }

    public void unlock(){
        this.bike.setState(Bike.UNLOCK_STATE);
    }

    public String toString(){
        return "扫码状态";
    }
}

public class UnLockState extends State{
    public void locked(){
        this.bike.setState(Bike.LOCK_STATE);
    }

    public void scan(){
        System.out.println("ERROR 已解锁的车扫码无效");
    }

    public void unlock(){
        System.out.println("车已解锁");
    }

    public String toString(){
        return "解锁状态";
    }
}

public class Bike{
    private State state;
    public final static LOCK_STATE = new LockState();
    public final static SCAN_STATE = new ScanState();
    public final static UNLOCK_STATE = new UnLockState();

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
        this.state.setBike(this);
    }

    public void locked(){
        this.state.locked();
    }

    public void scan(){
        this.state.scan();
    }

    public void unlock(){
        this.state.unlock();
    }
}

public static void main(String[] args){
    Bike bike = new Bike();
    bike.setState(Bike.LOCK_STATE);
    System.out.println("当前车的状态：" + bike.getState());
    bike.scan();
    System.out.println("当前车的状态：" + bike.getState());
    bike.unlock();
    System.out.println("当前车的状态：" + bike.getState());
    bike.scan();
    System.out.println("当前车的状态：" + bike.getState());

}
