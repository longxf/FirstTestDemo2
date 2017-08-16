package com.example;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test_YINYONG {
    public static void main(String[] args) {


        ArrayList<TestBean> testBeens = new ArrayList<TestBean>();

        testBeens.add(new TestBean("0", "name0"));
        testBeens.add(new TestBean("1", "name1"));
        testBeens.add(new TestBean("2", "name2"));
        testBeens.add(new TestBean("3", "name3"));
        testBeens.add(new TestBean("4", "name4"));
        testBeens.add(new TestBean("-1", "name-1"));


        testBeens.get(1).otherTestBean = testBeens.get(5);

        for (int i = 0; i < testBeens.size(); i++) {
            System.out.println(testBeens.get(i).toString());
        }

        TestBean testNew = new TestBean("new", "new");
        System.out.println("修改");
        TestBean temp = testBeens.get(1).otherTestBean;
        temp=testNew;
        testBeens.get(1).otherTestBean=temp;
//        testBeens.get(1).otherTestBean = aa;
//        testBeens.get(1).otherTestBean.id = "new";
//        testBeens.get(1).otherTestBean.name = "new";

        for (int i = 0; i < testBeens.size(); i++) {
            System.out.println(testBeens.get(i).toString());
        }
    }

}
