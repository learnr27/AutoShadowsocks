package com.huangkai.autoshadowsocks.entity;

import java.util.List;

public class GuiConfig {

    private List<Ssr> configs;

    private int index = 3;
    private boolean random = false;
    private int sysProxyMode = 2;
    private boolean shareOverLan = true;
    private boolean bypassWhiteList = false;
    private int localPort = 1080;
    private String localAuthPassword = "w4J5Dfl-ziuZTFFBCLcv";
    private String dns_server = "";
    private int reconnectTimes = 2;
    private int randomAlgorithm = 0;
    private boolean randomInGroup = false;
    private int TTL = 0;
    private int connect_timeout = 5;
    private int proxyRuleMode = 0;
    private boolean proxyEnable = false;
    private boolean pacDirectGoProxy = false;
    private int proxyType = 0;
    private String proxyHost = "";
    private int proxyPort = 0;
    private String proxyAuthUser = "";
    private String proxyAuthPass = "";
    private String proxyUserAgent = "";
    private String authUser = "";
    private String authPass = "";
    private boolean autoBan = false;
    private boolean sameHostForSameTarget = false;
    private int keepVisitTime = 180;
    private boolean isHideTips = false;
    private Object token = new Object();
    private Object portMap = new Object();

    public List<Ssr> getConfigs() {
        return configs;
    }

    public void setConfigs(List<Ssr> configs) {
        this.configs = configs;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isRandom() {
        return random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public int getSysProxyMode() {
        return sysProxyMode;
    }

    public void setSysProxyMode(int sysProxyMode) {
        this.sysProxyMode = sysProxyMode;
    }

    public boolean isShareOverLan() {
        return shareOverLan;
    }

    public void setShareOverLan(boolean shareOverLan) {
        this.shareOverLan = shareOverLan;
    }

    public boolean isBypassWhiteList() {
        return bypassWhiteList;
    }

    public void setBypassWhiteList(boolean bypassWhiteList) {
        this.bypassWhiteList = bypassWhiteList;
    }

    public int getLocalPort() {
        return localPort;
    }

    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }

    public String getLocalAuthPassword() {
        return localAuthPassword;
    }

    public void setLocalAuthPassword(String localAuthPassword) {
        this.localAuthPassword = localAuthPassword;
    }

    public String getDns_server() {
        return dns_server;
    }

    public void setDns_server(String dns_server) {
        this.dns_server = dns_server;
    }

    public int getReconnectTimes() {
        return reconnectTimes;
    }

    public void setReconnectTimes(int reconnectTimes) {
        this.reconnectTimes = reconnectTimes;
    }

    public int getRandomAlgorithm() {
        return randomAlgorithm;
    }

    public void setRandomAlgorithm(int randomAlgorithm) {
        this.randomAlgorithm = randomAlgorithm;
    }

    public boolean isRandomInGroup() {
        return randomInGroup;
    }

    public void setRandomInGroup(boolean randomInGroup) {
        this.randomInGroup = randomInGroup;
    }

    public int getTTL() {
        return TTL;
    }

    public void setTTL(int TTL) {
        this.TTL = TTL;
    }

    public int getConnect_timeout() {
        return connect_timeout;
    }

    public void setConnect_timeout(int connect_timeout) {
        this.connect_timeout = connect_timeout;
    }

    public int getProxyRuleMode() {
        return proxyRuleMode;
    }

    public void setProxyRuleMode(int proxyRuleMode) {
        this.proxyRuleMode = proxyRuleMode;
    }

    public boolean isProxyEnable() {
        return proxyEnable;
    }

    public void setProxyEnable(boolean proxyEnable) {
        this.proxyEnable = proxyEnable;
    }

    public boolean isPacDirectGoProxy() {
        return pacDirectGoProxy;
    }

    public void setPacDirectGoProxy(boolean pacDirectGoProxy) {
        this.pacDirectGoProxy = pacDirectGoProxy;
    }

    public int getProxyType() {
        return proxyType;
    }

    public void setProxyType(int proxyType) {
        this.proxyType = proxyType;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyAuthUser() {
        return proxyAuthUser;
    }

    public void setProxyAuthUser(String proxyAuthUser) {
        this.proxyAuthUser = proxyAuthUser;
    }

    public String getProxyAuthPass() {
        return proxyAuthPass;
    }

    public void setProxyAuthPass(String proxyAuthPass) {
        this.proxyAuthPass = proxyAuthPass;
    }

    public String getProxyUserAgent() {
        return proxyUserAgent;
    }

    public void setProxyUserAgent(String proxyUserAgent) {
        this.proxyUserAgent = proxyUserAgent;
    }

    public String getAuthUser() {
        return authUser;
    }

    public void setAuthUser(String authUser) {
        this.authUser = authUser;
    }

    public String getAuthPass() {
        return authPass;
    }

    public void setAuthPass(String authPass) {
        this.authPass = authPass;
    }

    public boolean isAutoBan() {
        return autoBan;
    }

    public void setAutoBan(boolean autoBan) {
        this.autoBan = autoBan;
    }

    public boolean isSameHostForSameTarget() {
        return sameHostForSameTarget;
    }

    public void setSameHostForSameTarget(boolean sameHostForSameTarget) {
        this.sameHostForSameTarget = sameHostForSameTarget;
    }

    public int getKeepVisitTime() {
        return keepVisitTime;
    }

    public void setKeepVisitTime(int keepVisitTime) {
        this.keepVisitTime = keepVisitTime;
    }

    public boolean isHideTips() {
        return isHideTips;
    }

    public void setHideTips(boolean hideTips) {
        isHideTips = hideTips;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public Object getPortMap() {
        return portMap;
    }

    public void setPortMap(Object portMap) {
        this.portMap = portMap;
    }
}
