package exday7;

public class SampleEx702 {
    public static void main(String[] args) {
        try{
            for(int i = 0; i <= 5; i++){
                int a = getNum(i);
                int b = 5;
                System.out.print(a + " / " + b + " = ");
                System.out.println(calc(a, b));
            }
        }catch(ArithmeticException e){
            System.out.println();
            System.out.println("division zero");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("accsees to out of array");
        }finally{
            System.out.println("exit");
        }
    }

    private static int calc(int a, int b) throws ArithmeticException{
        return a / b;
    }

    public static int getNum(int index) throws ArrayIndexOutOfBoundsException{
        int[] num = {1,2,3,4};
        return num[index];
    }
}
