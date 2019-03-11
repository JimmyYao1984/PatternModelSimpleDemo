//组合模式 部分-整体 树形结构
public abstract class BikeStuff{
	public String name;
	public String region;

	public void add(BikeStuff stuff){
		throw new UnsupportedOperationException("不支持添加操作");
	}

	public void remove(BikeStuff stuff){
        	throw new UnsupportedOperationException("不支持删除操作");
    	}

	public void report(){
        	throw new UnsupportedOperationException("不支持汇报操作");
    	}
}

//修理人员
public class BikeRepairer extends BikeStuff{
	public BikeRepairer(String name,String region){
		this.name = name;
		this.region = region;
	}

	@Override
	public void report(){
		System.out.println("负责" + region + "的修理运营");
	}
}

//运营经理
public class BikeManager extends BikeStuff{
	private List<BikeStuff> members = new ArrayList<BikeStuff>();
	public Integer level;

	public BikeManager(String name,String region,Integer level){
		this.name = name;
		this.region = region;
	}

	public void add(BikeStuff stuff){
		members.add(stuff);	
	}

	public void remove(BikeStuff stuff){
       	members.remove(stuff);
    }

	public void report(){
		System.out.println(this.name + "负责" + this.region + "的管理和运营");
        for(BikeStuff stuff : members){
            if(this.level != null){
                for(int  i = 0; i < this.level; i++){
                    System.out.print("  ");
                }
            }
            stuff.report();
        }
    }
}

public static void main(String[] args){
	BikeStuff xiaoZhang = new BikeRepairer("xiaoZhang","徐泾");
	BikeStuff xiaoZhao = new BikeRepairer("xiaoZhao","赵巷");
	BikeStuff laoWang = new BikeManager("laoWang","青浦",2);
	laoWang.add(xiaoZhao);
	laoWang.add(xiaoZhang);

	BikeStuff xiaoLi = new BikeRepairer("xiaoLi","北蔡");
	BikeStuff xiaoTao = new BikeRepairer("xiaoZhao","塘桥");
	BikeStuff laoZheng = new BikeManager("laoWang","浦东",2);
	laoZheng.add(xiaoLi);
	laoZheng.add(xiaoTao);

	BikeStuff laoXu = new BikeManager("laoXu","上海",1);
	laoXu.add(laoWang);
	laoXu.add(laoZheng);

	laoXu.report();
}
