package com.huangkai.autoshadowsocks.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.huangkai.autoshadowsocks.entity.Ssr;
import com.huangkai.autoshadowsocks.service.SsrService;
import com.huangkai.autoshadowsocks.utils.SsrSpider;
import com.huangkai.autoshadowsocks.utils.TinyUtil;
import com.huangkai.autoshadowsocks.utils.analyzer.DocumentAnalyzer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Service
public class SsrServiceImpl implements SsrService {

    @Resource
    private DocumentAnalyzer analyzer;

    @Override
    public List<Ssr> getSsrFromUrl(String url, int top) throws Exception {
        return SsrSpider.forEntityList(url, top, analyzer, Ssr.class);
    }

    @Override
    public JSONObject getGuiConfig(String filepath) throws Exception {
        return TinyUtil.jsonData(new File(filepath));
    }

}
