//abstract class Animal{//if class is abstract then it is not compulsory that there is abstract method 
    //but if method is abstract then we have to make class abstract

/*class Animal{
    void show(){
        //System.out.println("Hello World");
        System.out.println("show method");
    }
}*/
interface Animal{ //we had made class as interface here
    void show();
}
class Dog implements Animal{
    public void show(){
        System.out.println("display method");
    }
}
/*
class Dog extends Animal{
    public void display(){
        System.out.println("display method");
    }
}
*/
public class Demo{
 public static void main(String... x) {
       // Dog d=new Dog();
       // d.show();

       Animal a=new Dog();//parent class ke ander child reference can be called
      // a.show(); //here we go to reference to a then a to show after this show reference will go to obj to print
       a.display(); //this will give error our refernce does not have display's reference it is with the object

/*
        Dog d=new Animal(); //child ke reference mai parent ka obj ko call nhi kr skte this will give error
        d.show();
*/
    }
}
