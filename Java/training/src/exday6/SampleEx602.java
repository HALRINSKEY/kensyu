package exday6;

public class SampleEx602 {
    public static void main(String[] args) {
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";
        String s3 = new String("ABCDEF");

        if(s1.equals(s2)){
            System.out.println("string s1 == s2");
        }else{
            System.out.println("string s1 != s2");
        }

        if (s1.equals(s3)) {
            System.out.println("string s1 == s3");
        }else{
            System.out.println("string s1 != s3");
        }

        if (s1 == s2) {
            System.out.println("object s1 == s3");
        }else{
            System.out.println("object s1 != s3");
        }

        if (s1 == s3) {
            System.out.println("object s1 == s3");
        }else{
            System.out.println("object s1 != s3");
        }

    }
}
