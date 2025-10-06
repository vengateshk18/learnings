package SOLID_PRINCIPLES;


interface SocialMedia{ // It will not follow the Liskov substutuitional principle
    public void sendMesage();
    public void makeCall();
    public void makePost();
    public void makeStatus();
}

interface Messenger {
    public void sendMesage();
}

interface Call{
    public void makeCall();
}

interface Post{
    public void makePost();
}

interface Status{
    public void makeStatus();
}


class WhatsApp implements Messenger,Call,Status{

    @Override
    public void makeStatus() {
        System.out.println("Status Created");
    }

    @Override
    public void makeCall() {
        System.out.println("Calling...");
    }

    @Override
    public void sendMesage() {
        System.out.println("Message Send..");
    }
    
}


class Instagram implements Messenger,Call,Post,Status{

    @Override
    public void makeStatus() {
        System.out.println("Status Created");
    }

    @Override
    public void makePost() {
        System.out.println("Post Created");
    }

    @Override
    public void makeCall() {
        System.out.println("Calling...");
    }

    @Override
    public void sendMesage() {
        System.out.println("Message sended");
    }
    
}
public class LiskovSubstituitionalPrinciple {
    public static void main(String[] args) {
        WhatsApp app=new WhatsApp();
        app.sendMesage();
        app.makeCall();
        app.makeStatus();

        Instagram sm=new Instagram();
        sm.makeCall();
        sm.makeStatus();
        sm.sendMesage();
        sm.makePost();
    }
}
