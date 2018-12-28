package com.program.util.uuid;

import java.util.UUID;

/**
 * @description 主键生成器
 */
public class KeyGenerator {

    /**
     * 获得一个UUID
     *
     * @return String UUID
     */
    public static String getKey() {
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }
}
