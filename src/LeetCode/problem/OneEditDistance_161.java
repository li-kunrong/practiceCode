package LeetCode.problem;
/**Given two strings S and T, determine if they are both one edit distance apart.*/
public class OneEditDistance_161 {

    public static void main(String... strings) {
        String s = "abccdfg";
        String t = "abcdefg";
        System.out.println(isOneEditDistance(s, t));
    }

    public static boolean isOneEditDistance(String s, String t) {
        char []schar = s.toCharArray();
        char []tchar = t.toCharArray();
        if (Math.abs(s.length() - t.length()) == 1) {
            char[] longer = (s.length() > t.length()) ? schar : tchar;
            char[] shorter = (longer == schar) ? tchar : schar;

            int dirren =0;
            int i = 0;
            int j = 0;
            for (; i < shorter.length&&j < longer.length; ){
                if (shorter[i] != longer[j]) {
                    dirren++;
                    j++;
                }else{
                    i++;
                    j++;
                }
                return dirren==0 || dirren ==1;
            }
        }else if (s.length() == t.length()){
            int dirren = 0;
            for (int i = 0; i<s.length(); i++) {
                if (schar[i] != tchar[i]) {
                    dirren++;
                }
                if (dirren>1){
                    return false;
                }
            }
            return  dirren == 1;
        }
        return false;
    }
}
