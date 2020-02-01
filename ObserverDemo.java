import java.util.*;

class Sender{
    private List<Subscriber> subs=new ArrayList<>();//insertion order is preserved and duplicates are allowed here
    //but this is opposite in case of sets
    private String message;

    public void subscribe(Subscriber s){
        subs.add(s);
    }

    public void unsubscribe(Subscriber s){
        subs.remove(s);
    }

    public void sendMessage(){
        for(Subscriber s:subs){
          //  s.update();
            s.update(this.message);
        }
    }

    public void publishMessage(String message){
        this.message=message;
        sendMessage();
    }

}

/*
Sender ytGaming=new Sender("yt gaming");

Subscriber s1=new Subscriber("A");

s1.subscribeSender();
*/

class Subscriber{
    private String name;
    private Sender sd;//in this ref variable/obj  mai usko rkhenge sender class ka reference hai , iske ander woh obj hoga jisko yeh subscribe krega

    Subscriber(String name){
        this.name=name;
    }

    /*
    public void subscribeSender(Sender sd){
        this.sd=sd;
    }
    */

    public void subscribeSender(Sender sd){
        this.sd=sd;
        this.sd.subscribe(this);
    }

    /*
    public void update(){
        System.out.println(this.name+":Message Published");
    }
    */

    public void update(String message){
        System.out.println(this.name+":Message Published"+message);
    }

}

public class ObserverDemo{
    public static void main(String... x) {
        Sender sd=new Sender();

        Subscriber s1=new Subscriber("A");
        Subscriber s2=new Subscriber("B");
        Subscriber s3=new Subscriber("C");

        sd.subscribe(s1);
        sd.subscribe(s2);
        sd.subscribe(s3);
//here sender ko nhi pata hai subscriber kon hai so this is case of one sided love so he can remove next 3 line swhich will give erroe
//so to overcome we will change the class itself

        /*
        s1.subscribeSender(sd);
        s2.subscribeSender(sd);
        s3.subscribeSender(sd);

        */
        
        sd.publishMessage("Hello World");
        sd.publishMessage("Hello Java");

    }
}
