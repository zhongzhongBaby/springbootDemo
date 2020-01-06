package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.ToString;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

    /** 
    * @Description: 转驼峰
    * @Param: [oldString]
    * @Author: gengyuzhong
    * @Date: 2020/1/6 
    */
    public static  String toHump(String oldString){
        Matcher m = Pattern.compile("_([a-z])").matcher(oldString);
        while(m.find()){
            oldString=oldString.replaceFirst(m.group(0), m.group(1).toUpperCase());
        }
        return oldString;
    }

    /** 
    * @Description:  修改Map的key
    * @Param: 
    * @Author: gengyuzhong
    * @Date: 2020/1/6 
    */
    public static void mapRenameKeyToHump(Map<String,Object> map){
        Set<String> set =map.keySet();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String  c=iterator.next();
            if(c.indexOf("_")!=-1){
                map.put(toHump(c), map.get(c));
                map.remove(c);
            }
        }
    }


    /**
     * 从一个JSON 对象字符格式中得到一个java对象
     * @param jsonString
     * @param beanCalss
     * @return
     */
    public static <T> T jsonToBean(String jsonString, Class<T> beanCalss) {

        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        T bean = (T) JSONObject.toJavaObject(jsonObject, beanCalss);

        return bean;
    }
    /**
     * 连接池等待
     * @param executorService
     */
    public static void shutdown(ExecutorService executorService){
        executorService.shutdown(); //This method does not wait for previously submitted tasks to complete execution.
        //在这儿忙等判断，调用体阻塞在这儿。 应用场景：在调用体之后的代码中，若是需要所有的线程都执行完才能使用正确的数据，例如return response。 但若线程执行的任务与之后的数据无关就不需要阻塞了.
        while (true) {
            if (executorService.isTerminated()) {
                break;
            }
        }
    }








}
