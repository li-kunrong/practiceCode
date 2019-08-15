package com.crc;

import com.crc.aboutTime.IsBelongToDuringTime;

import java.util.Date;

public class ha {
    public static void main(String []args) {
        Date now = new Date();
        IsBelongToDuringTime isBelongToDuringTime = new IsBelongToDuringTime();
        isBelongToDuringTime.isBelong(now);
    }
}
