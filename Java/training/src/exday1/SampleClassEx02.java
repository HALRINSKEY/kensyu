package exday1;

class Parents1{
    void method(){
        System.out.println("parent");
    }

    void method(String s){
        System.out.println("method" + s);
    }
    
}

class Child extends Parents1{
    void method(){
        System.out.println("child");
    }
}


public class SampleClassEx02 {

    public static void main(String[] args) {
        Parents1 p = new Parents1();
        p.method();
        p.method("parent");
        Child c = new Child();
        c.method();
        c.method("child");
    }
}