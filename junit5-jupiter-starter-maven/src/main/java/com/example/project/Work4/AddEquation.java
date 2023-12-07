package com.example.project.Work4;

/**
 * 加法类
 * 继承AbstractEquation，并实现calculate方法。
 * **/
public class AddEquation extends AbstractEquation {

    private static final char SYMBOL = '+';  //加号
    public AddEquation(short numberOne, short numberTwo) {
        super(numberOne, numberTwo, SYMBOL);
    }
    public AddEquation(){
    }

    //重写了父类的方法
    public short calculate(){
        return (short) (getNumberOne()+getNumberTwo());

    }

    @Override
    public String toString() {

        return "number0ne: "+getNumberOne()+"numberTwo: "+getNumberTwo()+" SYMBOL: "+SYMBOL;
    }
}
