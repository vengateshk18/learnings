package BankApplication;

import BankApplication.models.XYZBANK;

public class Main {
    public static void main(String[] args) {
        XYZBANK bank=new XYZBANK();
        System.out.println(bank.createAccount(1, "venky","venky@gmail.com", "pass", 1500));
        System.out.println("balance->"+bank.getBalance("venky@gmail.com"));
        bank.createCard("venky@gmail.com", 16, 1144);
        System.err.println(bank.withdrawAmount(16,1));
        System.err.println(bank.withdrawAmount(16,10));
        bank.deposit("venky@gmail.com",100);
        bank.deposit("venky@gmail.com",100);
        System.out.println("Balance->"+bank.getBalance(16));
        System.out.println(bank.sweepCard(16,100));
        System.out.println("Balance->"+bank.getBalance(16));

    }
}
