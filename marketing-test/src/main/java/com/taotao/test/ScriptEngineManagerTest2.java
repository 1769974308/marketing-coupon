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
        String expression2 = "'status' === 'fail'";

        boolean o = (boolean)execExpression(expression2, "status","fail");
        System.out.println("o:"+o);

        Map<String,Object> values = new TreeMap<>();
        values.put("status","fail");
        boolean o2 = (boolean)execExpression(expression2, values);
        System.out.println("o2:"+o2);
    }

    public static Object execExpression(String expression, String placeHolder, Object value) throws ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.put(placeHolder, value);
        return engine.eval(expression);

    }

    public static Object execExpression(String expression, Map<String, Object> values) throws ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        values.entrySet().stream()
                .forEach(o -> engine.put(o.getKey(), o.getValue()));
        return engine.eval(expression);

    }
}
