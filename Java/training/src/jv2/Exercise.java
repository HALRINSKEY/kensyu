package jv2;

public class Exercise {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        
        cat.Name = "Tom";
        cat.Age = 10;
        dog.Name = "SPIKE";
        dog.Age = 10;


        cat.ShowProfile();
        dog.ShowProfile();

        cat.Sleep();
        dog.Run();

        cat.Speak();
        dog.Speak();
    }
}
