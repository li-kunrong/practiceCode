package com.crc.bijiao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: kunrong
 * @Date: 2019/8/21 11:39
 * @Description:
 **/
public class Zhuceshijian {
    static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {
        Fuwu fuwu1 = new Fuwu("10010001","0001","2019-12-20");
        Fuwu fuwu2 = new Fuwu("10010002","0002","2018-12-20");
        Fuwu fuwu3 = new Fuwu("10010003","0003","2017-12-20");
        Fuwu fuwu4 = new Fuwu("10010004","0004","2016-12-20");
        Fuwu fuwu5 = new Fuwu("10010005","0005","2019-11-20");

        Fuwu fuwu16 = new Fuwu("10010006","0006","2010-11-20");


        Fuwu fuwu6 = new Fuwu("10010001","0001","2019-10-20");
        Fuwu fuwu7 = new Fuwu("10010002","0002","2019-09-20");
        Fuwu fuwu8 = new Fuwu("10010003","0003","2019-08-20");
        Fuwu fuwu9 = new Fuwu("10010004","0004","2019-12-11");
        Fuwu fuwu10 = new Fuwu("10010005","0005","2019-12-12");

        Fuwu fuwu17 = new Fuwu("10010007","0007","2019-02-09");


        Fuwu fuwu11 = new Fuwu("10010001","0001","2019-01-13");
        Fuwu fuwu12 = new Fuwu("10010002","0002","2013-09-20");
        Fuwu fuwu13 = new Fuwu("10010003","0003","2019-04-20");
        Fuwu fuwu14 = new Fuwu("10010004","0004","2019-10-11");
        Fuwu fuwu15 = new Fuwu("10010005","0005","2019-01-12");

        Fuwu fuwu18 = new Fuwu("10010008","0008","2014-10-10");

        ArrayList<Fuwu> sit = new ArrayList<>();
        ArrayList<Fuwu> uat = new ArrayList<>();
        List<Fuwu> prod = new ArrayList<>();



        sit.add(fuwu1);
        sit.add(fuwu2);
        sit.add(fuwu3);
        sit.add(fuwu4);
        sit.add(fuwu5);
        sit.add(fuwu16);

        uat.add(fuwu6);
        uat.add(fuwu7);
        uat.add(fuwu8);
        uat.add(fuwu9);
        uat.add(fuwu10);
        uat.add(fuwu17);

        prod.add(fuwu11);
        prod.add(fuwu12);
        prod.add(fuwu13);
        prod.add(fuwu14);
        prod.add(fuwu15);
        prod.add(fuwu18);

        List<Fuwu> res = find(sit,uat);

       res= find(res,prod);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }

    }

    static List<Fuwu> find(List<Fuwu> sit, List<Fuwu> uat) throws ParseException {
        List<Fuwu> res = new ArrayList<>();
        for (int i = 0; i <sit.size(); i++) {
            int j = 0;
            for (; j<uat.size(); j++) {
                if (sit.get(i).getServId().equals(uat.get(j).getServId())&& sit.get(i).getAppsysId().equals(uat.get(j).getAppsysId()) ) {
                    Date date1 = sdf.parse(sit.get(i).getRegisterTime());
                    Date date2 = sdf.parse(uat.get(j).getRegisterTime());
                    if (date1.before(date2)) {
                        res.add(sit.get(i));
                    }else {
                        res.add(uat.get(j));
                    }
                    break;
                }

            }
            if (j>=uat.size()) {
                res.add(sit.get(i));//到库里找
            }
        }

        for (int i = 0; i < uat.size(); i++) {
            int j =0 ;
            boolean flag = false;
            for ( ; j< res.size(); j++) {
                if (uat.get(i).getServId().equals(res.get(j).getServId())&&uat.get(i).getAppsysId().equals(res.get(j).getAppsysId())) {
                    flag = true;
                    continue;
                }
            }
            if (!flag) {
                res.add(uat.get(i));//到库里找
            }
        }
        return res;

    }
}
