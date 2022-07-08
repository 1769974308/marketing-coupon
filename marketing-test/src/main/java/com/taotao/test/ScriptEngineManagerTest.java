package com.taotao.test;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** 利用ScriptEngineManager实现简单的规则运算
 * @author ASUS
 * @date 2022/7/8
 */
public class ScriptEngineManagerTest {

    public static void main(String[] args) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine js = manager.getEngineByName("js");
        //构建原始数据
        JSONObject jsonObject1 = JSONObject.parseObject("{'status':'success', 'remark':'下单成功'}");
        JSONObject jsonObject2 = JSONObject.parseObject("{'status':'fail', 'remark':'下单失败，余额不足'}");
        JSONObject jsonObject3 = JSONObject.parseObject("{'status':'success', 'remark':'下单成功'}");

        List<JSONObject> list = new ArrayList<>();
        list.add(jsonObject3);
        list.add(jsonObject2);
        list.add(jsonObject1);

        // 构建规则参数
        Map<String,String> filter = new TreeMap<>();
        filter.put("val1","status");
        filter.put("val2","remark");

        String rule = "'status' === 'fail' && 'remark'.indexOf('失败') >-1";

        List<JSONObject> result = new ArrayList<>();

        for (JSONObject map: list){
            //构建参数实际值
            List<String> listValue = new ArrayList<>();
            filter.forEach((key,val)->{
                String s = map.get(val).toString();
                listValue.add(s);
            });
            String[] array = new String[listValue.size()];
            array = listValue.toArray(array);

            //需要执行的实际规则
            String evalRule = StringUtils.replaceEach(rule, new String[]{"status","remark"}, array);
            boolean a = false;
            try {
                //规则执行
                a = (boolean) js.eval(evalRule);
                if (a){
                    result.add(map);
                }
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);
    }

}
