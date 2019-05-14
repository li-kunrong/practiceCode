package interview.byterun;

import java.util.*;

/**
 * @author kunrong
 * @description
 * @date 2019/5/5 15:10
 */

/**
 * 时间限制：1秒
 *
 * 空间限制：32768K
 *
 * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 *
 * 如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
 *
 *
 *
 *
 * 输入描述:
 * 第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
 * 对于 50%的数据,  1 <= N <= 10000;
 * 对于 100%的数据, 1 <= N <= 500000;
 *
 * 输出描述:
 * 输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。
 *
 * 输入例子1:
 * 5
 * 1 2
 * 5 3
 * 4 6
 * 7 5
 * 9 0
 *
 * 输出例子1:
 * 4 6
 * 7 5
 * 9 0
 */
public class BigestNum {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int x = 0;
        int y = 0;
        Mark []m = new Mark[n];
        for (int i = 0; i < n; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            m[i] = new Mark(x,y);
        }

        Arrays.sort(m, (o1, o2) -> o1.getX()==o2.getX()?o1.getY()-o2.getY():o1.getX()-o2.getX());

        int maxY = m[m.length-1].getY();
        List<Mark> marks = new ArrayList<>();
        marks.add(m[n-1]);
        for (int i = n-2; i>=0; i--){
            //System.out.println(m[i].toString());
            if (m[i].getY()>maxY) {
                marks.add(m[i]);
            }
            maxY = Math.max(m[i].getY(), maxY);
        }

        for (int i = marks.size()-1 ; i>=0; i--) {
            System.out.println(marks.get(i).getX() + " " + marks.get(i).getY());
        }


    }





}


class Mark {
    private int x;
    private int y;

    public Mark(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}