package com.huangkai.autoshadowsocks.service;

import com.alibaba.fastjson.JSONObject;
import com.huangkai.autoshadowsocks.entity.Ssr;

import java.util.List;

public interface SsrService {

    public List<Ssr> getSsrFromUrl(String url, int top) throws Exception;

    public JSONObject getGuiConfig(String filepath) throws Exception;
}
