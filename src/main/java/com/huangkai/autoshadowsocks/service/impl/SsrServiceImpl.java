package com.huangkai.autoshadowsocks.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huangkai.autoshadowsocks.entity.GuiConfig;
import com.huangkai.autoshadowsocks.entity.Ssr;
import com.huangkai.autoshadowsocks.service.SsrService;
import com.huangkai.autoshadowsocks.utils.SsrSpider;
import com.huangkai.autoshadowsocks.utils.TinyUtils;
import com.huangkai.autoshadowsocks.utils.analyzer.DocumentAnalyzer;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

import static org.apache.commons.codec.CharEncoding.UTF_8;

@Service
public class SsrServiceImpl implements SsrService {

    @Resource
    private DocumentAnalyzer analyzer;

    @Override
    public List<Ssr> getSsrFromUrl(String url, int top) throws Exception {
        return SsrSpider.forEntityList(url, top, analyzer, Ssr.class);
    }

    @Override
    public GuiConfig getGuiConfig(String filepath) throws Exception {
        JSONObject jsonObject = TinyUtils.jsonData(new File(filepath));
        GuiConfig guiConfig = new GuiConfig();
        if (jsonObject != null) {
            guiConfig = JSON.parseObject(jsonObject.toJSONString(), GuiConfig.class);
        }
        return guiConfig;
    }

    @Override
    public boolean saveGuiConfig(String url, List<Ssr> webSsrList, String filepath) throws Exception {
        //备份原配置文件
        boolean isBackup = TinyUtils.backupFile(new File(filepath));

        //获取配置文件
        GuiConfig guiConfig = this.getGuiConfig(filepath);
        for (int i = 0; i < webSsrList.size(); i++) {
            Ssr ssr = webSsrList.get(i);
            ssr.setId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
            ssr.setRemarks_base64(Base64.encodeBase64URLSafeString(ssr.getRemarks().getBytes()));
            ssr.setGroup(url);
            webSsrList.set(i, ssr);
        }
        guiConfig.setConfigs(webSsrList);

        //保存新的配置文件
        FileUtils.writeStringToFile(new File(filepath), JSON.toJSONString(guiConfig), UTF_8, false);

        return true;
    }

}
