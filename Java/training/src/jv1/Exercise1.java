package jv1;

public class Exercise1 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("秋田犬");
        dog1.SetName("ハチ公");
        dog1.SetAge(11);
        dog1.ShowProfile();

        Dog dog2 = new Dog("ブービエ・デ・フランダース");
        dog2.SetName("パトラッシュ");
        dog2.SetAge(16);
        dog2.ShowProfile();
    }
}
