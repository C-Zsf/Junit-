package com.example.project.Work4;

/**
 * 减法类
 * 继承AbstractEquation，并实现calculate方法。
 * **/
public class SubEquation extends AbstractEquation {
    private static final char SYMBOL = '-';  //减号
    public SubEquation(short numberOne, short numberTwo) {
        super(numberOne, numberTwo, SYMBOL);
    }
    public SubEquation(){}
    //重写了父类的方法
    public short calculate(){
        return (short) (getNumberOne()-getNumberTwo());

    }
}
