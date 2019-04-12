package Sword_to_offer.problem;

public class LeftRotateString {
    /**
     * 求模取中间
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateStringI(String str,int n) {
        if (str == null || n < 0)
            return null;
        int len = str.length();
        if (len == 0)
            return "";
        int index = n%len;
        str +=str;
        return str.substring(index,index+len);

    }
}
