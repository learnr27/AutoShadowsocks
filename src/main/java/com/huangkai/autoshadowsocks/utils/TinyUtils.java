package com.huangkai.autoshadowsocks.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinyUtils {

    /**
     * map转对象
     *
     * @param map  map
     * @param type 类型
     * @param <T>  泛型
     * @return 对象
     * @throws Exception 反射异常
     */
    static <T> T mapToBean(Map<String, Object> map, Class<T> type) throws Exception {
        if (map == null) {
            return null;
        }
        Set<Map.Entry<String, Object>> sets = map.entrySet();
        T entity = type.newInstance();
        Method[] methods = type.getDeclaredMethods();
        for (Map.Entry<String, Object> entry : sets) {
            String str = entry.getKey();
            String setMethod = "set" + str.substring(0, 1).toUpperCase() + str.substring(1);
            for (Method method : methods) {
                if (method.getName().equals(setMethod)) {
                    method.invoke(entity, entry.getValue());
                }
            }
        }
        return entity;
    }

    public static JSONObject jsonData(File file) {
        JSONObject jsonDate = null;
        String json = null;
        try {
            json = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (json != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(json);
            json = m.replaceAll("");
        }
        jsonDate = JSON.parseObject(json);//得到JSONobject对象
        return jsonDate;
    }

    public static boolean backupFile(File srcFile) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            String currentDate = df.format(new Date());// new Date()为获取当前系统时间
            File destFile = new File(srcFile.getAbsoluteFile() + "." + currentDate);
            FileUtils.copyFile(srcFile, destFile);
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static void startProgram(String programPath, String programName) throws IOException {
        if (StringUtils.isNotBlank(programPath)) {
            try {
                Runtime.getRuntime().exec("taskkill /f /im " + programName);
                Thread.currentThread().sleep(2000);
                Runtime.getRuntime().exec(programPath + "\\" + programName);
            } catch (Exception e) {
                System.out.println("Error exec!" + e);
            }
        }
    }

}
