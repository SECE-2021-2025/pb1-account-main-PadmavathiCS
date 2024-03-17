public class Account {
    private String id;
    private String name;
    private Integer balance;

    Account(String id,String name){
        this.id=id;
        this.name=name;
    }

    Account(String id,String name,Integer balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Integer getBalance(){
        return this.balance;
    }

    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setBalance(Integer balance){
        this.balance=balance;
    }

    public Integer credit(Integer amount){
        this.balance+=amount;
        return this.balance;
    }
    public Integer debit(Integer amount){
        if(this.balance>=amount){
            this.balance-=amount;
            return this.balance;
        }
        else{
            System.out.println("Amount Exceeded the balance");
            return this.balance;
        }
    }
    public Integer transferTo(Account acc,Integer amount){
        if(amount<=this.balance){
            acc.setBalance(acc.getBalance()+amount);
            this.balance-=amount;
        }
        else{
            System.out.println("Amount Exceeded");
        }
        return this.balance;
    }

    @Override
    public String toString(){
        return "Account[id= "+this.id+" ,name= "+this.name+" ,balance= "+this.balance+"]";
    }
}