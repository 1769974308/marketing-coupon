package com.taotao.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ASUS
 * @date 2022/7/8
 */
public class ScriptEngineManagerTest2 {

    public static void main(String[] args) throws ScriptException {
        String expression1 = "'status' === 'fail' && 'remark'.indexOf('失败') >-1";


        Map<String,Object> values = new TreeMap<>();
        values.put("status","fail");
        values.put("remark","失败");
        Object o = execExpression(expression1, values);
        System.out.println("o2:"+o);
    }



    public static Object execExpression(String expression, Map<String, Object> values) throws ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        values.entrySet().stream()
                .forEach(o -> engine.put(o.getKey(), o.getValue()));
        return engine.eval(expression);

    }
}
