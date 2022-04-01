package com.tang.modernjavainaction.chap17;


import lombok.Getter;
import lombok.ToString;

import java.util.Random;

/**
 * @Title: TempInfo
 * @Description:
 * @author: tangyao
 * @date: 2022/3/29 10:20
 * @Version: 1.0
 */
@ToString
public class TempInfo {
    public static final Random random = new Random();
    @Getter
    private final String town;
    @Getter
    private final int temp;

    public TempInfo(String town, int temp) {
        this.town = town;
        this.temp = temp;
    }

    public static TempInfo fetch(String town) {
        if (random.nextInt(10) == 0) {
            throw new RuntimeException("Error");
        }
        return new TempInfo(town, random.nextInt(100));
    }


}