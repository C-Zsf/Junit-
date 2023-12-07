package com.example.project.Work4;

/**
 * 设计实现该接口的实体类EquationCheckerOfRange。它的构造方法是：EquationCheckerOfRange(int min, int max)，
 * min指出操作数及结果的最小值（含），max指出操作数及结果的最大值（含），该类主要实现check方法，限定操作数及结果。
 **/
public class EquationCheckerOfRange implements EquationChecker {
    private int min;//结果最小值
    private int max;//结果最大值

    public EquationCheckerOfRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    //check方法 限定操作数及结果。
    @Override
    public boolean check(IEqualtion equation) {
        //当是加法时
        if (equation instanceof AddEquation) {
            boolean b = equation.calculate() >= max
                    || equation.getNumberOne() >= max || equation.getNumberTwo() >= max
                    || equation.getNumberOne() <= min || equation.getNumberTwo() <= min;
            return b ? false : true;
        }
        //当是减法时
        else {
            boolean b = equation.calculate() < min
                    || equation.getNumberOne() >= max || equation.getNumberTwo() >= max
                    || equation.getNumberOne() <= min || equation.getNumberTwo() <= min;
            return b ? false : true;
        }
    }
}
