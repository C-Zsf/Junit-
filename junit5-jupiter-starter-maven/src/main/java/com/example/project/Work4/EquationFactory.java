package com.example.project.Work4;

import java.util.Random;

/**
 * 它有方法IEqualtion getEquation(String type)，IEqualtion getEquationRandom()。
 * 根据type（“Add”/“Sub”）返回AddEquation，或者SubEquation；或者随机返回算式。
 * **/
public class EquationFactory {
    //根据穿进来的类型，返回需要的算式对象
    public IEqualtion getEquation(String type,short one,short two){
        if(type.equals("Add")){
            return new AddEquation(one,two);
        }
        else {
            return new SubEquation(one,two);
        }
    }
    //随机返回需要的算式对象
    public IEqualtion getEquationRandom(short one,short two){
        Random random = new Random();
        boolean bool = random.nextBoolean();
        if (bool){
            return new AddEquation(one,two);
        }
        else {
            return new SubEquation(one,two);
        }

    }
}
