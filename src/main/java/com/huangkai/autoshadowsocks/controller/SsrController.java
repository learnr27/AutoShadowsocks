package com.huangkai.autoshadowsocks.controller;

import com.alibaba.fastjson.JSONObject;
import com.huangkai.autoshadowsocks.entity.Ssr;
import com.huangkai.autoshadowsocks.service.SsrService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 定时从URL网址获取账号信息，仅获取前五条。
 */
@Component
public class SsrController {

    private static String URL = "https://ss.weirch.com/";
    private static String filepath = "D:\\ShadowsocksR\\gui-config.json";

    @Resource
    private SsrService ssrService;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 第一次延迟3秒执行，当执行完后1800秒(半小时)再执行
     */
    @Scheduled(initialDelay = 3000, fixedDelay = 1800000)
    public void timerInit() throws Exception {
        System.out.println("当前执行时间 : " + dateFormat.format(new Date()));
        //从网站获取配置信息，前5条
        List<Ssr> ssrList = ssrService.getSsrFromUrl(URL, 5);
        JSONObject jsonObject = ssrService.getGuiConfig(filepath);

    }

}
