//单例模式
public class BikeFactory{
	private static class InnerClass{
    	private static BikeFactory innerBuilder = new BikeFactory();
    }
    public static BikeFactory getInstance(){
        return InnerClass.innerBuilder;
    }
    private BikeFactory(){
        if(InnerClass.innerBuilder != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }
}

