package com.huangkai.autoshadowsocks.utils.analyzer.impl;

import com.huangkai.autoshadowsocks.utils.analyzer.DocumentAnalyzer;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DocumentAnalyzerImpl implements DocumentAnalyzer {

    @Override
    public List<Map<String, Object>> forListMap(Document document, int top) {
        List<Map<String, Object>> results = new ArrayList<>();
        if (ObjectUtils.isEmpty(document)) {

        } else {
            Elements elements = document.body().getElementById("ss").getElementsByTag("tbody").get(0).children();
            for (int i = 0; i < (elements.size() > top ? top : elements.size()); i++) {
                Element element = elements.get(i);
                Map<String, Object> result = new HashMap<>();
                //result.put("health", element.getElementsByTag("tr").get(0).getElementsByTag("td").get(0).text());
                result.put("server", element.getElementsByTag("tr").get(0).getElementsByTag("td").get(1).text());
                result.put("server_port", Integer.valueOf(element.getElementsByTag("tr").get(0).getElementsByTag("td").get(2).text()).intValue());
                result.put("password", element.getElementsByTag("tr").get(0).getElementsByTag("td").get(3).text());
                result.put("method", element.getElementsByTag("tr").get(0).getElementsByTag("td").get(4).text());
                //result.put("verifield", element.getElementsByTag("tr").get(0).getElementsByTag("td").get(5).text());
                result.put("remarks", element.getElementsByTag("tr").get(0).getElementsByTag("td").get(6).text());
                results.add(result);
            }
        }
        return results;
    }

}
