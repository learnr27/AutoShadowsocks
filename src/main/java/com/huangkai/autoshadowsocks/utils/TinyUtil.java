package com.huangkai.autoshadowsocks.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinyUtil {
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
        String json = new String();
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            FileChannel channel = fin.getChannel();

            int capacity = 932;// 字节
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            while (channel.read(bf) != -1) {
                /*
                 * 注意，读取后，将位置置为0，将limit置为容量, 以备下次读入到字节缓冲中，从0开始存储
                 */
                bf.clear();
                byte[] bytes = bf.array();
                json += new String(bytes, 0, capacity);
            }
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (json != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(json);
            json = m.replaceAll("");
        }
        jsonDate = JSON.parseObject(json);//得到JSONobject对象
        return jsonDate;
    }

}
