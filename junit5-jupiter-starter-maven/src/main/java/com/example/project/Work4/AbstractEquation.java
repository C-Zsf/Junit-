package com.example.project.Work4;

import java.util.Objects;

/**
 * 设计算式抽象类AbstractEquation，它实现了IEquation的部分方法，包括getter、setter，
 * 它还覆盖实现equals、hashCode方法。AbstractEquation还提供了三个参数的构造方法。
 **/
public abstract class AbstractEquation implements IEqualtion {
    //第一个运算数
    private short numberOne;
    //第二个运算数
    private short numberTwo;
    //运算符
    private char symbol;

    //构造方法
    public AbstractEquation(short numberOne, short numberTwo, char symbol) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.symbol = symbol;
    }
    public AbstractEquation(){}

    public short getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(short numberOne) {
        this.numberOne = numberOne;
    }

    public short getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(short numberTwo) {
        this.numberTwo = numberTwo;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEquation)) return false;
        AbstractEquation that = (AbstractEquation) o;
        return getNumberOne() == that.getNumberOne() && getNumberTwo() == that.getNumberTwo() && getSymbol() == that.getSymbol();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOne(), getNumberTwo(), getSymbol());
    }

    //抽象方法 返回计算结果
    public abstract short calculate();

}
