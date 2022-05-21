
package com.company;
import java.util.*;
import java.util.Scanner;
class BankAccount{
    String name;
    String usrname;
    String pass;
    String accno;
    float bal=100000f;
    int tr=0;
    String trhis="";
    public void register(){
        Scanner in =new Scanner(System.in);
        System.out.println("\nEnter Name: ");
        this.name=in.nextLine();
        System.out.println("\nEnter Username: ");
        this.usrname=in.nextLine();
        System.out.println("\nEnter password: ");
        this.pass=in.nextLine();
        System.out.println("\nEnter your account number: ");
        this.accno=in.nextLine();
        System.out.println("\nRegistration Successful");

    }
    public boolean login(){
        boolean islogin=false;
        Scanner in =new Scanner(System.in);
        while(!islogin){
            System.out.println("\nEnter username: ");
            String username=in.nextLine();
            if (username.equals(usrname)){
                while (!islogin){
                    System.out.println("\nEnter password");
                    String pass1=in.nextLine();
                    if (pass1.equals(pass)){
                        System.out.println("\nLogin Successful");
                        islogin=true;
                    }
                    else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            }
            else {
                System.out.println("\nIncorrect Username");
            }
        }
        return islogin;
    }
    public void withdraw(){
        System.out.println("\nEnter amount to withdraw");
        Scanner in =new Scanner(System.in);
        float amt=in.nextFloat();
        try{
            if(bal>=amt){
                tr++;
                bal-=amt;
                System.out.println("\nWithdraw successful");
                String str=amt+" /- Withdrawed";
                trhis=trhis.concat(str);
            }
            else {
                System.out.println("\n Insufficient Balance");
            }

        }
        catch (Exception e){

        }
    }
    public void deposit(){
        System.out.println("\n Enter amount to deposit");
        Scanner in =new Scanner(System.in);
        float amt=in.nextFloat();
        try{
            if(amt<=100000f){
                tr++;
                bal+=amt;
                System.out.println("\nDeposited Successfully");
                String str=amt+" /- deposited";
                trhis=trhis.concat(str);
            }
            else {
                System.out.println("Limit is 100000");
            }
        }
        catch (Exception e){

        }
    }
    public void transfer(){
        Scanner in =new Scanner(System.in);
        System.out.println("\nEnter Recipent's name: ");
        String rec=in.nextLine();
        System.out.println("\n Enter amount to transfer: ");
        float amt=in.nextFloat();
        try{
            if(bal>=amt) {
                if (amt <= 50000f) {

                    tr++;
                    bal -= amt;
                    System.out.println("\nTransfered Successfully");
                    String str = amt + " transfered to " + rec;
                    trhis = trhis.concat(str);
                } else {
                    System.out.println("\nLimit is 50000");
                }
            }
            else {
                System.out.println("\nInsufficient balance");
            }
        }
        catch (Exception e){

        }
    }
    public void checkBal(){
        System.out.println(bal+"/-\n");
    }
    public void transHis(){
        if(tr==0){
            System.out.println("\nNo Transaction History");
        }
        else{
            System.out.println("\n"+trhis);
        }
    }
}
public class ATM{
    public static int takeIntInp(int lmt){
        int inp=0;
        boolean f=false;
        while(!f){
            try{
                Scanner in =new Scanner(System.in);
                inp=in.nextInt();
                f=true;
                if(f && inp>lmt||inp<1){
                    System.out.println("Chose number between 1 to "+lmt);
                    f=false;
                }
            }
            catch (Exception e){
                System.out.println("Enter integer only");
                f=false;
            }
        };
        return inp;
    }
    public static void main(String[] args) {
        System.out.println("------ATM INTERFACE------");
        System.out.println("1.Register\n2.Exit");
        System.out.println("Enter choice: ");
        int c=takeIntInp(2);
        if(c==1){
            BankAccount b=new BankAccount();
            b.register();
            while (true){
                System.out.println("1.Login\n2.Exit");
                System.out.println("Enter choice: ");
                int ch=takeIntInp(2);
                if(ch==1){
                    if(b.login()){
                        System.out.println("-----Welcome"+b.name+"-----");
                        boolean isdone=false;
                        while (!isdone){
                            System.out.println("\n1.Withdraw\n2.Deposit\n3.Transfer\n4.Checkbalance\n5.TransactionHistory");
                            System.out.println("Enter your choice: ");
                            int n=takeIntInp(6);
                            switch (n){
                                case 1:
                                    b.withdraw();break;
                                case 2:
                                    b.deposit();break;
                                case 3:
                                    b.transfer();break;
                                case 4:
                                    b.checkBal();break;
                                case 5:
                                    b.transHis();break;
                                case 6:
                                    isdone=true;break;
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }

}
