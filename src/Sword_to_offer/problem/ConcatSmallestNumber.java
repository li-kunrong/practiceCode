package Sword_to_offer.problem;

import java.util.Arrays;
import java.util.Comparator;

public class ConcatSmallestNumber {


//    public String PrintMinNumber(int [] numbers) {
//        if(numbers == null || numbers.length == 0) return "";
//        int len = numbers.length;
//        String[] str = new String[len];
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < len; i++){
//            str[i] = String.valueOf(numbers[i]);
//        }
//        Arrays.sort(str,new Comparator<String>(){
//            @Override
//            public int compare(String s1, String s2) {
//                String c1 = s1 + s2;
//                String c2 = s2 + s1;
//                return c1.compareTo(c2);
//            }
//        });
//        for(int i = 0; i < len; i++){
//            sb.append(str[i]);
//        }
//        return sb.toString();
//    }

    public String PrintMinNumberII(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        String []str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        String s = "";
        for (String i : str) {
            s+=i;
        }
        return s;
    }
}
