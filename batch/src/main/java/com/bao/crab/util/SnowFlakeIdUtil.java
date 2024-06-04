package com.bao.crab.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/5/22 15:21
 */

public class SnowFlakeIdUtil {

    public static void main(String[] args) {
        Snowflake snowflake = IdUtil.createSnowflake(1L,1L);
        System.out.println(snowflake.nextId());
    }
}
