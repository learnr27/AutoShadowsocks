package com.huangkai.autoshadowsocks.entity;

public class Ssr {

    //备注
    private String remarks;
    //ID
    private String id;
    //IP地址
    private String server;
    //端口号
    private int server_port;
    private int server_udp_port = 0;
    //密码
    private String password;
    //加密方式
    private String method;
    private String protocol = "origin";
    private String protocolparam = "";
    private String obfs = "plain";
    private String obfsparam = "";
    //备注（BASE6加密）
    private String remarks_base64;
    //分组
    private String group;
    private boolean enable = true;
    private boolean udp_over_tcp = false;
    

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getServer_port() {
        return server_port;
    }

    public void setServer_port(int server_port) {
        this.server_port = server_port;
    }

    public int getServer_udp_port() {
        return server_udp_port;
    }

    public void setServer_udp_port(int server_udp_port) {
        this.server_udp_port = server_udp_port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocolparam() {
        return protocolparam;
    }

    public void setProtocolparam(String protocolparam) {
        this.protocolparam = protocolparam;
    }

    public String getObfs() {
        return obfs;
    }

    public void setObfs(String obfs) {
        this.obfs = obfs;
    }

    public String getObfsparam() {
        return obfsparam;
    }

    public void setObfsparam(String obfsparam) {
        this.obfsparam = obfsparam;
    }

    public String getRemarks_base64() {
        return remarks_base64;
    }

    public void setRemarks_base64(String remarks_base64) {
        this.remarks_base64 = remarks_base64;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isUdp_over_tcp() {
        return udp_over_tcp;
    }

    public void setUdp_over_tcp(boolean udp_over_tcp) {
        this.udp_over_tcp = udp_over_tcp;
    }
}
