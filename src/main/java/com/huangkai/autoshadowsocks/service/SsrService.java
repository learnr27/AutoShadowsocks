package com.huangkai.autoshadowsocks.service;

import com.huangkai.autoshadowsocks.entity.GuiConfig;
import com.huangkai.autoshadowsocks.entity.Ssr;

import java.util.List;

public interface SsrService {

    public List<Ssr> getSsrFromUrl(String url, int top) throws Exception;

    public GuiConfig getGuiConfig(String filepath) throws Exception;

    public boolean saveGuiConfig(String url, List<Ssr> ssrList, String filepath) throws Exception;
}
