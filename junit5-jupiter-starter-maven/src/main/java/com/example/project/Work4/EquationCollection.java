package com.example.project.Work4;

import com.sun.jndi.ldap.Connection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * 它有产生算式的方法：void generate(int n, EquationChecker checker)，
 * 使用EquationFactory产生n个，无重复的（内部使用HashSet），受约束（checker实例检查）的算式。
 * 产生时操作数要随机，加减法算式要随机。EquationCollection，需要将产生的算式暴露出来，
 * 它实现了接口java.util.Iterable，这样我们可以使用java.util.Iterator迭代器来遍历这些产生的算式
 **/
public class EquationCollection implements Iterable<IEqualtion> {
    private Set<IEqualtion> hashSet;

    //产生算式的方法
    public void generate(int n, EquationChecker checker) {
        EquationFactory equationFactory = new EquationFactory();
        //新建hashSet集合
        hashSet = new HashSet<>();
        //数据数对象
        Random random = new Random();
        short one;
        short two;
        while (true) {
            //根据随机数 生成随机数字 和符号
            one = (short) random.nextInt(101);
            two = (short) random.nextInt(101);
            IEqualtion iEqualtion = equationFactory.getEquationRandom(one, two);
            if (checker.check(iEqualtion)) {
                hashSet.add(iEqualtion);
            }
            //如果存入的算式对象到达 指定值则退出循环
            if (hashSet.size() == n) {
                break;
            }

        }

    }
    //重写迭代器方法，返回hashset的迭代器
    @Override
    public Iterator<IEqualtion> iterator() {
        return hashSet.iterator();
    }
}

