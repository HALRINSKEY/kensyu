package day4;

public class Sample405 {
    public static void main(String[] args) {
        while (true) {
            int dice = (int)(Math.random()*1000) + 1;
            System.out.println(dice);
            if(dice == 6){
                break;
            }
        }
    }
}
