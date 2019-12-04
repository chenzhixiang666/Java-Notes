package com.practice.study;

import java.util.function.Function;

import static java.lang.String.*;
import static java.lang.String.valueOf;

/**
 * author:v_zxianchen
 * Date:2019/12/4 15:29
 */
public class FunctionTest {
    public static void main(String[] args) {

        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.compute(5, value -> valueOf(value * 2)));
        System.out.println(functionTest.compute1(3,value -> value*3,value -> 4 +value));

    }


    public String compute(int a, Function<Integer,String> function){
        String result = function.apply(a);
        return result;
    }
    public int compute1(int a ,Function<Integer,Integer> function,Function<Integer,Integer> function2){

        //compose()方法源码         return (V v) -> apply(before.apply(v));
        //compose()方法  是先执行括号里面的函数  (V v)指的是 function.compose(function2).apply(a);后面compose调用的apply()里面的a
        //(V v)意思就是  调用compose()方法的函数的传入值  调用compose()的是function,function的传入值是apply(a)  所以a就是v

        /*看源码 apply(before.apply(v)); 是一个整体代表的就是function.compose(function2)  所以源码里面(V v) -> apply(before.apply(v))
        传入的(V v) 就是调用完compose()方法的函数的传入值 */

        return function.compose(function2).apply(a);
    }
}



