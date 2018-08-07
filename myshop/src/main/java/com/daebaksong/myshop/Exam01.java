package com.daebaksong.myshop;

import java.lang.reflect.Method;

public class Exam01 {
    public static void main(String[] args) throws Exception {
        // Class 타입은 클래스 정보를 가진다.
        Class clazz = Class.forName("com.daebaksong.myshop.MyData");
        Object obj = clazz.newInstance(); //객체 생성

        Method m = clazz.getMethod("print", null);
        m.invoke(obj, null);


    }
}

class MyData {
    static int i;
    static {
        i = 5;
        System.out.println("static!!!");
    }

    public void print(){
        System.out.println("MyData print()");
    }

}
