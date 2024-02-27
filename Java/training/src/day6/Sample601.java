package day6;

public class Sample601 {
    public static void main(String[] args) {
        SampleClass01 s = new SampleClass01();
        s.n = 100;
        s.s = "Hello";
        int ans = s.add(1,2);
        String str = s.add("world");
        System.out.println(ans);
        System.out.println(str);
        s.showNum();


        System.out.println();

        
        SampleClass01 s1,s2;
        s1 = new SampleClass01();
        s2 = new SampleClass01();

        s1.n = 100;
        s2.n = 200;

        s1.s = "ABC";
        s2.s = "あいう";

        System.out.println(s1.add("DEF"));
        System.out.println(s2.add("えお"));
        s1.showNum();
        s2.showNum();
        
    }
}
