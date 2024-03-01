package jv2;

class Animal{
    public String Name;
    public int Age;

    public void ShowProfile()
    {
        System.out.println( "名前は、" + Name + "、" + Age + "歳です。" );
    }

    public void Speak()
    {
    System.out.println( "......" );
    }

}

class Cat extends Animal{

    public void Sleep(){
        System.out.println("zzzz");
    }

    public void Speak(){
        System.out.println("meowmeow");
    }

}

class Dog extends Animal{

    public void Run(){
        System.out.println("Daaaaa");
    }
    
    public void Speak(){
        System.out.println("bowbow");
    }
}
