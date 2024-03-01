package exday6;

import java.util.*;

public class SampleEx601 {

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        String n[] = {"明治","大正","昭和","平成"};
        map.put(n[0],1868);
        map.put(n[1],1912);
        map.put(n[2],1926);
        map.put(n[3],1989);
        for(String s:n){
            System.out.println(s+"元号は西暦"+map.get(s));
        }

        System.out.println();

        HashSet<String> map2 = new HashSet<String>();
        map2.add("yamada");
        map2.add("yamada");
        map2.add("saito");
        map2.add("tanaka");
        for(String s:map2){
            System.out.println(s);
        }

    }
}