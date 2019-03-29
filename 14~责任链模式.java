//责任链模式 责任链的不知道下一步是谁 需要调用者指定
public class Account{
    public boolean isRegister;
    public boolean isDeposited;
    public boolean isBlackList;

    public Account(boolean isRegister,boolean isDeposited,boolean isBlackList){
        this.isRegister = isRegister;
        this.isDeposited = isDeposited;
        this.isBlackList = isBlackList;
    }
}

//处理类 很多地方会写成Handler
public abstract class Approver{
    protected Approver approver;

    public void setNextApprover(Approver nextApprover){
        this.approver = nextApprover;
    }

    public abstract boolean check(Account account);
}

public class RegisterApprover extends Approver{
    @Override
    public boolean check(Account account){
        if(!account.isRegister){
            System.out.println("没有注册，流程结束");
            return false;
        }
        if(approver != null){
            //还有下一个approver则交给下一个Approver处理
            approver.check(account);
        }else{
            return true;
        }
    }
}

public class DepositApprover extends Approver{
    @Override
    public boolean check(Account account){
        if(!account.isDeposited){
            System.out.println("没交押金，流程结束");
            return false;
        }
        if(approver != null){
            //还有下一个approver则交给下一个Approver处理
            approver.check(account);
        }else{
            return true;
        }
    }
}

public class BlackListApprover extends Approver{
    @Override
    public boolean check(Account account){
        if(account.isBlackList){
            System.out.println("黑名单用户，流程结束");
            return false;
        }
        if(approver != null){
            //还有下一个approver则交给下一个Approver处理
            approver.check(account);
        }else{
            return true;
        }
    }
}

public static void main(String[] args){
    Approver registerApprover = new RegisterApprover();
    Approver blackListApprover = new BlackListApprover();
    Approver depositApprover = new DepositApprover();

    Account account = new Account(true,true,false);

    registerApprover.setNextApprover(blackListApprover);
    blackListApprover.setNextApprover(depositApprover);

    registerApprover.check(account);
}
