package interview.nowcode2019.shangtang;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/15 14:27
 * @Description:
 * 反向思考：先消除海洋，剩下的就是陆地啦和岛屿，再把湖泊变成陆地，
 * bfs陆地，就可以得到结果。
 **/
public class LudiHehaiyang {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] map = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = in.nextInt();
            }
        }
        int count=0;
        for(int j = 0; j < n; j++){
            count+=dfs(map,0,j,0,-1);
        }
        for(int i = 0; i < m; i++){
            count+=dfs(map,i,0,0,-1);
            count+=dfs(map,i,n-1,0,-1);
        }
        int res=0;
        for(int j = n-2; j>=1; j--){
            for(int i = m-2; i >= 1; i--){
                if(map[i][j]==0){
                    map[i][j]=1;
                }
            }
        }
        res=dfs(map,m-1,0,1,2);
        System.out.println(res);
    }
    public static int dfs(int[][] map,int i,int j,int s,int t){
        LinkedList<Node> list=new LinkedList<Node>();
        if(map[i][j]==s){
            list.addLast(new Node(i,j));
        }
        int count=0;
        while(!list.isEmpty()){
            Node tmp=list.pollLast();
            i=tmp.x;
            j=tmp.y;
            if(map[i][j]==s){
                count++;
                map[i][j]=t;
            }
            if(j>0 && map[i][j-1]==s) {
                list.addLast(new Node(i,j-1));
            }
            if(j<map[0].length-1 && map[i][j+1]==s)
                list.addLast(new Node(i,j+1));
            if(i>0 && map[i-1][j]==s)
                list.addLast(new Node(i-1,j));
            if(i<map.length-1 && map[i+1][j]==s)
                list.addLast(new Node(i+1,j));
        }
        return count;
    }



}

class Node{
    int x;
    int y;
    public Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}
