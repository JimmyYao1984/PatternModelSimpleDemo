//组合模式 部分-整体 树形结构
public abstract class BikeStuff {
    public String name;
    public String region;

    public void add(BikeStuff stuff) {
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void remove(BikeStuff stuff) {
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public void report() {
        throw new UnsupportedOperationException("不支持汇报操作");
    }
}

//修理人员
public class BikeRepairer extends BikeStuff {
    public BikeRepairer(String name, String region) {
        this.name = name;
        this.region = region;
    }

    @Override
    public void report() {
        System.out.println("负责" + region + "的修理运营");
    }
}

//运营经理
public class BikeManager extends BikeStuff {
    private List<BikeStuff> members = new ArrayList<BikeStuff>();
    public Integer level;

    public BikeManager(String name, String region, Integer level) {
        this.name = name;
        this.region = region;
    }

    public void add(BikeStuff stuff) {
        members.add(stuff);
    }

    public void remove(BikeStuff stuff) {
        members.remove(stuff);
    }

    public void report() {
        System.out.println(this.name + "负责" + this.region + "的管理和运营");
        for (BikeStuff stuff : members) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.println(" ");
                }
            }
            stuff.report();
        }
    }
}

    public static void main(String[] args) {
        BikeStuff xiaozhang = new BikeRepairer("xiaozhang", "徐泾");
        BikeStuff xiaozhao = new BikeRepairer("xiaozhao", "赵巷");
        BikeStuff laoWang = new BikeManager("laowang", "青浦", 2);
        laoWang.add(xiaozhao);
        laoWang.add(xiaozhang);

        BikeStuff xiaoli = new BikeRepairer("xiaoli", "北蔡");
        BikeStuff xiaotao = new BikeRepairer("xiaotao", "塘桥");
        BikeStuff laozheng = new BikeManager("laozheng", "浦东", 2);
        laozheng.add(xiaoli);
        laozheng.add(xiaotao);

        BikeStuff laoxu = new BikeManager("laoxu", "上海", 1);
        laoxu.add(laoWang);
        laoxu.add(laozheng);

        laoxu.report();
    }
