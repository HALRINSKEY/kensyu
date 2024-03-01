package jv1;

import java.util.Map;
import java.util.TreeMap;

public class CoinCase {
    TreeMap<Integer,Integer> coincase = new TreeMap<Integer,Integer>();
    //HashMap<Integer,Integer> coincase = new HashMap<Integer,Integer>();

    public CoinCase(){
        
        coincase.put(500, 0);
        coincase.put(100, 0);
        coincase.put(50, 0);
        coincase.put(10, 0);
        coincase.put(5, 0);
        coincase.put(1, 0);
    }

    public void AddCoins(int type,int count) {
        if(coincase.containsKey(type)){
            coincase.put(type,coincase.get(Integer.valueOf(type)) + count);
        }
    }

    public int GetCount(int type){
        return coincase.get(type); 
    }

    public int GetAmount(){
        int sum = 0;
        for(Map.Entry<Integer,Integer> s:coincase.entrySet()){
            sum += s.getKey() * s.getValue();
        }
        
        return sum;
    }
}
