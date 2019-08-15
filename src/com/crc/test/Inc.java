package com.crc.test;

/**
 * @Author: kunrong
 * @Date: 2019/8/7 15:12
 * @Description:
 **/
public class Inc {

        public static void main(String[] args) {
            Inc inc = new Inc();
            int i = 0;
            inc.fermin(i);
            i= i++;
            System.out.println(i);

        }
        void fermin(int i){
            i++;
        }

}
