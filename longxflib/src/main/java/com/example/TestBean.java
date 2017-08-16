package com.example;

/**
 * Created by longxiaofeng on 17/4/14.
 */

public class TestBean {

    public String id;
    public String name;
    public TestBean otherTestBean;

    public TestBean(String id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("id+name=" + id + "--" + name);

        String temp = otherTestBean != null ? " |otherTestBean id+name=" + otherTestBean.id + "--" + otherTestBean
                .name : "";
        sb.append(temp);
        return sb.toString();
    }
}
