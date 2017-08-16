package com.example;

import static jdk.nashorn.internal.objects.NativeString.indexOf;

/**
 * Created by longxiaofeng on 17/4/27.
 */

public class taozunTest {
    public static void main(String[] args) {

//        String regexStr = "123E-mail：zixun@jbxedu.com35你好";
//        String regex = regexStr.replaceAll("E.*com","");
//        System.out.println(regex.length()+"");

        String feedToolids = "{\"1\",\"2\",\"3\"}";
        int index = feedToolids.indexOf("1");
        if(index==2){
           String str= feedToolids.replace("\"1\"","\"4\",\"1\"");

            System.out.println("" + index+"  feedToolids="+str);
        }

        System.out.println("" + index);
    }
}
