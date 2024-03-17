import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,choice,accid,accidf,accidt;
        String id,name;
        Integer balance,amount;
        Account acc,accf,acct;
        System.out.println("Enter the no of accounts you wants to create:");
        n=Integer.parseInt(br.readLine());
        Account []accarr= new Account[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the Id/Accno");
            id=br.readLine();
            System.out.println("Enter the AccHolderName");
            name=br.readLine();
            System.out.println("Enter the AccBalance");
            balance=Integer.parseInt(br.readLine());
            acc=new Account(id,name,balance);
            accarr[i]=acc;
        }
        

        do{
            System.out.println("1.Credit");
            System.out.println("2.Debit");
            System.out.println("3.Transfer");
            System.out.println("Enter your choice:");
            choice=Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.println("Select the Account");
                    display(accarr,n);
                    accid=Integer.parseInt(br.readLine());
                    acc=accarr[accid-1];
                    System.out.println("Enter the amount to be credited");
                    amount=Integer.parseInt(br.readLine());
                    balance=acc.credit(amount);
                    System.out.println(balance);
                    System.out.println(acc.toString());
                    break;
                case 2:
                   System.out.println("Select the Account");
                   display(accarr,n);
                   accid=Integer.parseInt(br.readLine());
                   acc=accarr[accid-1];
                   System.out.println("Enter the amount to be debited");
                   amount=Integer.parseInt(br.readLine());
                   balance=acc.debit(amount);
                   System.out.println(balance);
                   System.out.println(acc.toString());
                   break;
                case 3:
                   System.out.println("Select the Account to transfer from");
                   display(accarr,n);
                   accidf=Integer.parseInt(br.readLine());
                   accf=accarr[accidf-1];
                   System.out.println("Select the Account to transfer to");
                   display(accarr,n);
                   accidt=Integer.parseInt(br.readLine());
                   acct=accarr[accidt-1];
                   System.out.println("Enter the amount to be transfer");
                   amount=Integer.parseInt(br.readLine());
                   balance=accf.transferTo(acct, amount);
                   System.out.println(balance);
                   System.out.println(accf.toString());
                   System.out.println(acct.toString());
                   break;
                default:
                   System.out.println("Done");
                    break;
            }
        }while(choice>=1 && choice<=3);
    }
    

    public static void display(Account []accarr,int size){
        for(int i=0;i<size;i++){
            System.out.print("Acc "+(i+1)+":"+accarr[i].toString());
        }
    }

}