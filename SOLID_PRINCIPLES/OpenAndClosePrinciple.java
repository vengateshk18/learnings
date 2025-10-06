package SOLID_PRINCIPLES;


class BankAccount{
    public int account_number;
    public int balance;

    BankAccount(int acn){
        this.account_number=acn;
        this.balance=0;
    }
}

interface NotificationService{
    public void sendText(Account acc);
}

class EmailNotification implements NotificationService{
    public void sendText(Account acc){
        System.out.println("Notification sended");
    }
}

class SMSNotification implements NotificationService{
    public void sendText(Account acc){
        System.out.println("Notification sended");
    }
}

public class OpenAndClosePrinciple {
    public static void main(String[] args) {
        Account acc=new Account(10);
        NotificationService notify=new EmailNotification();
        notify.sendText(acc);
        NotificationService notify1=new SMSNotification();
        notify.sendText(acc);
    }
}
