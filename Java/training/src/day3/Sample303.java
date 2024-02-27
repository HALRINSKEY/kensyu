package day3;

public class Sample303 {
    public static void main(String[] args) {
        //int dice = (int)(Math.random()*7)+1;
        double tmp = Math.random();
        int dice = (int)(tmp * 7) + 1;
        System.out.println(dice);
        if (1 <= dice && dice <= 6){
            if ((dice % 2) == 0){
               System.out.println("丁");
            }else{
                System.out.println("半");
            }
        }else{
            System.out.println("error");
        }
        
    }
}
