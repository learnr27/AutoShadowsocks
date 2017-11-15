package com.huangkai.autoshadowsocks.utils.analyzer;

import org.jsoup.nodes.Document;

import java.util.List;
import java.util.Map;

public interface DocumentAnalyzer {

    List<Map<String, Object>> forListMap(Document document, int top);

}
