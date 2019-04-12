package Sword_to_offer.problem;

public class TwoNumAppearOnce {
    /**
     * 背景知识：一个数异或本身等于0，任何数与0异或得到本身。
     * 异或得到一个数，是两个不同的数异或的结果，找到其中为1的位，分成两组继续异或，叨叨结果
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 0){
            return;
        }
        if (array.length==2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        int bit = 0;
        for (int i : array){
            bit^=i;
        }
        int index = findFirst(bit);
        for (int i: array){
            if (isSame(i,index)){
                num1[0]^=i;
            }else{
                num2[0]^=i;
            }
        }
    }

    int findFirst(int bit){
        int index = 0;
        while ((bit&1)==0 && index<32 ){
            bit>>=1;
            index++;
        }
        return index;
    }

    boolean isSame(int arr,int index){
        return ((arr>>index)&1)==1?true:false;
    }
}
