package LeetCode.string;

/**
 * @Desecription:两个字符串的数相乘
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 * Note:
 The length of both num1 and num2 is < 110.
 Both num1 and num2 contain only digits 0-9.
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    /**
     * temp1记录每一个数与整个数相乘后的结果，再与temp2相加
     * 然后temp2记录的是，被截取后的结果，因为是字符串，只能截取后再相加
     * tail记录的是被截取的尾部
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if(num1.length() == 1 && num1.equals("0") || num2.length() ==1 && num2.equals("0")) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            return multiply(num2,num1);
        }
        String temp2 = "";
        String tail = "";
        int carry =0;
        for (int i = 0;i < num1.length(); i++){
            temp2+="0";
        }
        for (int i = num1.length()-1;i >= 0; i--) {
            String temp1 = "";
            for (int j = num2.length()-1; j >=0; j--) {
                int pro = Integer.parseInt(String.valueOf(num1.charAt(i))) * Integer.parseInt(String.valueOf(num2.charAt(j)));
                pro+=carry;
                carry = pro/10;
                temp1 = pro%10+temp1;

            }
            if (carry > 0) {
                temp1 = String.valueOf(carry) + temp1;
                carry = 0;
            }
            String result = add(temp1,temp2);
            temp2 = result.substring(0,result.length() -1);
            tail = result.substring(result.length()-1, result.length()) + tail;

        }
        return temp2+tail;
    }

    /**
     * 计算两个数相加
     * @param n
     * @param m
     * @return
     */
    private String add(String n, String m) {
        String result = "";
        int carry = 0;
        int i = n.length()-1;
        int j = m.length()-1;
        for (; i >= 0 || j >= 0; j--,i--){
            int l = (i >= 0)?Integer.parseInt(String.valueOf(n.charAt(i))):0;
            int r = (j >= 0)?Integer.parseInt(String.valueOf(m.charAt(j))):0;
            int sum = l +r +carry;
            carry = sum/10;
            result = sum%10+result;
        }
        if (carry>0) {
            result = carry+result;
        }
        return result;
    }

    public static void main(String[] args) {
//        int sum = 1;
//        String r = "123";
//        r = sum+r;
//        System.out.println(r);
        String s1 = "123";
        String s2 = "456";
        System.out.println( new MultiplyStrings().multiply(s1,s2));

    }
}
