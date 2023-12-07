package com.example.project.Work4;

/**
 * 设计算式接口IEqualtion，提供了算式两个操作数（short）、操作符（char）的getter及setter抽象方法，
 * 以及calculate抽象方法，它应返回算式的计算结果。
 **/
public interface IEqualtion {

    public short getNumberOne();

    public void setNumberOne(short numberOne);

    public short getNumberTwo();

    public void setNumberTwo(short numberTwo);

    public char getSymbol();

    public void setSymbol(char symbol);

    public short calculate();
}
