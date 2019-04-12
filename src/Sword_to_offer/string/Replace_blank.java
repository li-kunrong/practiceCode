package Sword_to_offer.string;

/**
 * @author kunrong
 * @date 2019/2/26 18:21
 */
public class Replace_blank {

    public static void main(String[] args){
     String string = "we are happy";
     String my= string.replaceAll(" ","%20");
        System.out.println(my);
    }
    public String replaceSpace(StringBuffer str) {
        int len = str.length()-1;
        int spaceNum = 0;
        for (int i = 0; i <= len ; i++){
            if (str.charAt(i) == ' ')
                spaceNum++;
        }
        int total = len+spaceNum*2;
        int newIndex = total;
        str.setLength(total+1);
        for (; len>=0 && len<total; len--){
            if (str.charAt(len) == ' '){
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }else{
                str.setCharAt(newIndex--, str.charAt(len));
            }

        }
        return str.toString();
    }
}
