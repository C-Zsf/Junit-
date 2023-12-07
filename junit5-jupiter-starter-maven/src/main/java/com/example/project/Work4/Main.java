package com.example.project.Work4;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 读入数目n，产生（EquationCollection/EquationCheckerOfRange）n个加减法算式（AddEquation/SubEquation），
 * 产生次序随机，且操作数介于0到100（含）。遍历（Iterator）算式，并在终端输出算式。
 * **/
public class Main {
    public static void main(String[] args) {
        Set<IEqualtion> hashSet = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要产生的算式数");
        int n = scanner.nextInt();
        System.out.println("输入结果和数值的最大范围");
        int max = scanner.nextInt();
        System.out.println("输入结果和数值的最小范围");
        int min = scanner.nextInt();
        EquationCollection equationCollection = new EquationCollection();
        equationCollection.generate(n,new EquationCheckerOfRange(min,max));
        Iterator<IEqualtion> iterator = equationCollection.iterator();
        int i=0;
        System.out.println("====================算式=====================");
        while(iterator.hasNext()){

            IEqualtion next = iterator.next();
            //如果是加法对象
            if (next instanceof AddEquation){
                i++;
                System.out.print(next.getNumberOne()+"\t"+next.getSymbol()+"\t"+next.getNumberTwo()+"\t=\t\t");
            }
            //如果是减法对象
            if (next instanceof SubEquation){
                i++;
                System.out.print(next.getNumberOne()+"\t"+next.getSymbol()+"\t"+next.getNumberTwo()+"\t=\t\t");
            }
            //当显示4个后 换行
            if (i%4==0){
                System.out.println();
            }

        }
        System.out.println("\n===========================================");

        System.out.println("\n====================答案=====================");
        //每行显示答案数目
       i =0;
         iterator = equationCollection.iterator();
        while(iterator.hasNext()){
            IEqualtion next = iterator.next();
            i++;
            System.out.print(next.calculate()+"\t");
            //当显示4个后 换行
            if (i%n==0){
                System.out.println();
            }
            if (i%4==0){
                System.out.println();
            }
        }
        System.out.println("\n==========================================");

    }

}
