package jv1;

class Dog {
    private String Name;
    private int Age;
    private String Type;

    public Dog(String ty){
        this.Type = ty;
    }
    
    public void SetName(String nm){
        Name = nm;
    }

    public void ShowProfile(){
        System.out.println("犬種は" + Type + "です");
        System.out.println("名前は" + Name + "です");
        System.out.println("年齢は" + Age + "歳です");
    }

    public void SetAge(int ag){
        Age = ag;
    }

    
}
