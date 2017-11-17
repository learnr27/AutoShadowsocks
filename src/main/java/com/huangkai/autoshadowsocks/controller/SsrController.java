package com.huangkai.autoshadowsocks.controller;

import com.huangkai.autoshadowsocks.entity.Ssr;
import com.huangkai.autoshadowsocks.service.SsrService;
import com.huangkai.autoshadowsocks.utils.TinyUtils;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${ShadowsocksR.Website}")
    private String URL;

    @Value("${ShadowsocksR.Top}")
    private int TOP;

    @Value("${ShadowsocksR.RootPath}")
    private String ROOT_PATH;

    @Resource
    private SsrService ssrService;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 第一次延迟3秒执行，当执行完后1800秒(半小时)再执行
     */
    @Scheduled(initialDelay = 3000, fixedDelay = 1800000)
    public void timerInit() throws Exception {
        System.out.println("Start Time:" + dateFormat.format(new Date()));
        //从网站获取配置信息，前10条
        List<Ssr> ssrList = ssrService.getSsrFromUrl(URL, TOP);
        //把ssrList保存至配置文件中
        boolean isSuccess = ssrService.saveGuiConfig(URL, ssrList, ROOT_PATH + "\\gui-config.json");
        //启动ShadowsocksR-dotnet4.0.exe
        TinyUtils.startProgram(ROOT_PATH, "ShadowsocksR-dotnet4.0.exe");
        System.out.println("End Time:" + dateFormat.format(new Date()));
    }

}
