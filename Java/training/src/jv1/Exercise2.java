package jv1;

public class Exercise2 {

    public static void main(String[] args) {
        CoinCase c = new CoinCase();
        c.AddCoins(10000, 10);
        c.AddCoins(500, 10);
        c.AddCoins(100, 10);
        c.AddCoins(50, 10);
        c.AddCoins(10, 10);
        c.AddCoins(5, 10);
        c.AddCoins(1, 10);
        c.AddCoins(500, 10);
        c.AddCoins(500, 10);
        c.AddCoins(500, 10);
        c.AddCoins(500, 10);

        for(Integer s:c.coincase.keySet()){
            System.out.println(s + ":" + c.GetCount(s));
        }

        System.out.println("計：" + c.GetAmount());
    }
}