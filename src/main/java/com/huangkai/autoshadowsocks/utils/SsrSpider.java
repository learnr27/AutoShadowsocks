package com.huangkai.autoshadowsocks.utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.huangkai.autoshadowsocks.utils.analyzer.DocumentAnalyzer;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class SsrSpider {

    private static final Logger log = LoggerFactory.getLogger(SsrSpider.class);

    public static <T> List<T> forEntityList(String url, int top, DocumentAnalyzer docAnalyzer, Class<T> type) throws Exception {
        log.info("Spider SSR:" + url);
        List<T> results = new ArrayList<>();
        //构造一个webClient 模拟Chrome 浏览器
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //屏蔽日志信息
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        //支持JavaScript
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(5000);
        HtmlPage rootPage = webClient.getPage(url);
        //设置一个运行JavaScript的时间
        webClient.waitForBackgroundJavaScript(5000);
        String html = rootPage.asXml();
        Document document = Jsoup.parse(html);
        docAnalyzer.forListMap(document, top).forEach(map -> {
            try {
                results.add(TinyUtils.mapToBean(map, type));
            } catch (Exception ignored) {
                System.out.println(ignored);
            }
        });
        return results;
    }

}
