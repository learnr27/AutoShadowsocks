package com.huangkai.autoshadowsocks.entity;

import java.util.Date;

public class Ssr {

    //健康度
    private String health;
    //IP地址
    private String ip;
    //端口号
    private int port;
    //密码
    private String password;
    //加密方式
    private String method;
    //验证时间
    private Date verified;
    //地区
    private String geo;

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
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

    public Date getVerified() {
        return verified;
    }

    public void setVerified(Date verified) {
        this.verified = verified;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }
}
