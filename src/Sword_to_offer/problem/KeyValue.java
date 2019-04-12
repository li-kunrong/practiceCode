package Sword_to_offer.problem;

public class KeyValue {
    /**
     * key-value 题目
     *
     */
    //Insert one char from stringstream
    int []table = new int[256];
    String s = new String();
    public void Insert(char ch)
    {
        if (table[ch] == 0)
            table[ch] = 1;
        else
            table[ch]+=1;
        s+=ch;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char c[] = s.toCharArray();
        for (char a : c){
            if (table[a] == 1){
                return a;
            }
        }
        return '#';
    }
}
