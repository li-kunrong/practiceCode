package Sword_to_offer.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Char_Permutation {
    /**
     * 基于回溯法的字母全排列
     * https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return (ArrayList)res;
        helper(str.toCharArray(),0,res);
        Collections.sort(res);
        return (ArrayList)res;

    }
    public  void helper(char[] c,int i, List<String> list) {
        if (i == c.length-1){
            String val = String.valueOf(c);
            if (!list.contains(val)){
                list.add(val);
            }

        }else{
            for (int j = i; j < c.length; j++){
                swap(c,i,j);
                helper(c,i+1,list);
                swap(c,i,j);
            }
        }
    }

    public void swap(char c[],int i,int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
