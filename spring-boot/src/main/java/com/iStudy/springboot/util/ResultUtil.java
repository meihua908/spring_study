package com.iStudy.springboot.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iStudy.springboot.model.PageRusult;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * 返回封装工具
 */
public class ResultUtil {


    /**
     * 获得指定success、message和data 默认code200 正常
     *
     * @param success 返回码
     * @param message 给前端展示提示框的文本信息
     * @param data    数据
     */
    public static Map<String, Object> getMessageAndData(Boolean success, String message, Object data) {
        Map<String, Object> map = new LinkedHashMap<String, Object>(4);
        map.put("code", 200);
        map.put("success", success);
        map.put("message", message);
        map.put("data", data);
        return map;
    }

    /**
     * 获得指定success、message和data 默认code200 正常
     *
     * @param success 返回码
     * @param message 给前端展示提示框的文本信息
     * @param data    数据
     * @param code    状态码
     */
    public static Map<String, Object> getMessageAndData(Boolean success, String message, Object data, int code) {
        Map<String, Object> map = new LinkedHashMap<String, Object>(4);
        map.put("code", code);
        map.put("success", success);
        map.put("message", message);
        map.put("data", data);
        return map;
    }
    
    public static Map<String, Object> getMessageAndDataStr(Boolean success, String message, Object data){
        Map<String, Object> map = new LinkedHashMap<String, Object>(4);
        map.put("success", success);
        map.put("message", message);
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        map.put("data", om.convertValue(data,Object.class));
        return map;
    }
    
    public static Map<String, Object> getSuccess(Map<String, Object> map, Boolean lean) {
        Map<String, Object> m = new TreeMap<>();
        m.put("success", lean);
        m.put("data", map);
        return m;
    }
    
    public static Map<String, Object> getResult(Boolean lean, Object obj) {
        Map<String, Object> map = new LinkedHashMap<>(5);
        map.put("model", obj);
        return getSuccess(map, lean);
    }
    
    public static Map<String, Object> getResultList(Boolean lean, PageRusult pageRusult, Integer length) {
        Map<String, Object> map = new LinkedHashMap<>(8);
        map.put("rows", pageRusult.getList());
        map.put("total", pageRusult.getTotal());
        map.put("totalPage", (pageRusult.getTotal() / length) + 1);
        return getSuccess(map, lean);
    }

}
