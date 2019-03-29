//中介者模式
public abstract class Job{
    protected Mediator mediator;
    protected String name;
    public Job(String name,Mediator mediator){
        this.mediator = mediator;
        this.name = name;
    }

    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }

    protected abstract void sendJobMessage(String msg);
    protected abstract void getJobMessage(String msg);
}

public class Worker extends Job{
    public Worker(String name,Mediator mediator){
        super(name,mediator);
    }

    @Override
    protected void sendJobMessage(String msg){
        mediator.operation(this,msg);
    }

    @Override
    protected void getJobMessage(String msg){
        System.out.println("求职者[" + name + "]收到" + mediator.mediatorName + "发来的消息："+msg);
    }
}


public class Manager extends Job{
    public Manager(String name,Mediator mediator){
        super(name, mediator);
    }

    @Override
    protected void sendJobMessage(String msg){
        mediator.operation(this,msg);
    }

    @Override
    protected void getJobMessage(String msg){
        System.out.println("供职者[" + name + "]收到" + mediator.mediatorName + "发来的消息：" + msg);
    }
}

public abstract class Mediator{
    protected List<Job> managers = new ArrayList<Job>();
    protected List<Job> workers = new ArrayList<Job>();
    public String mediatorName;

    public Mediator(String name){
        this.mediatorName = name;
    }

    public void registerManager(Job manager){
        managers.add(manager);
    }

    public void registerWorker(Job worker){
        workers.add(worker);
    }

    public abstract void operation(Job job,String message);
}

public class LaGouMediator extends Mediator{
    public LaGouMediator(String name){
        super(name);
    }

    @Override
    public void operation(Job job,String msg){
        if(job instanceof Worker){
            for(Job manager: managers){
                manager.getJobMessage(msg);
            }
        }else if(job instanceof Manager){
            for(Job worker : workers){
                worker.getJobMessage(msg);
            }
        }
    }
}

public static void main(String[] args){
    Mediator mediator = new LaGouMediator("拉勾");

    Job worker1 = new Worker("小强");
    Job worker2 = new Worker("小明");
    Job manager = new Manager("摩拜单车公司");

    mediator.registerWorker(worker1);
    mediator.registerWorker(worker2);

    mediator.registerManager(manager);

    manager.sendJobMessage("招Android搞基开发");
    worker1.sendJobMessage("会Android开发");
    worker2.sendJobMessage("会后端Java开发");
}


