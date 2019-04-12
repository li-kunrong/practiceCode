package Sword_to_offer.problem;

public class TheMoveAreaOfRobot {
    public int movingCount(int threshold, int rows, int cols)
    {
        int flag[][] = new int[rows][cols];
        return helper(0,0,threshold,rows,cols,flag);
    }
    public int helper(int i,int j, int k, int rows,int cols, int[][]flag){
        if (i <0 || j<0 || i >= rows|| j >= cols || flag[i][j]!=0 || (cal(i)+cal(j) > k)){
            return 0;
        }
        flag[i][j] = 1;
        return helper(i++,j,k,rows,cols,flag)
                +helper(i--,j,k,rows,cols,flag)
                +helper(i,j++,k,rows,cols,flag)
                +helper(i,j--,k,rows,cols,flag)
                +1;
    }

    public int cal(int num){
        int res = 0;
        while(num!=0){
            res+=num%10;
            num/=10;
        }
        return res;
    }
}
