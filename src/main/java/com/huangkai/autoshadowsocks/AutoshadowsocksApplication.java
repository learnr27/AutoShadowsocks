package com.huangkai.autoshadowsocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 应用启动类
 */
@SpringBootApplication
@EnableScheduling
public class AutoshadowsocksApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoshadowsocksApplication.class, args);
    }
}
