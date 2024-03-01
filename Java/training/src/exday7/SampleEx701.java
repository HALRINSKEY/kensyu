package exday7;

public class SampleEx701 {
    public static void main(String[] args) {
        //System.out.println(1/0);

        try{
            for(int i = 3; i >= 0; i--){
                int a = i;
                int b = 5;
                System.out.print(b + " / " + a + " = ");
                System.out.println(b / a);
            }
        }catch(ArithmeticException e){
            System.out.println();
            System.out.println("division zero");
        }finally{
            System.out.println("exit");
        }
    }
}
