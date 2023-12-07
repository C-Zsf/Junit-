package com.example.project.Work4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 * 根据类名字符串“AddEquation”，查询其字段和方法，并根据其无参构造方法产生实例。
 * **/
public class FsMain {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //声明class对象
        Class c =null;
        //实例化class对象
        c = Class.forName("Software_construction.Work4.AddEquation");
        //获取本类的全部属性
        Field[] fields = c.getDeclaredFields();
        //遍历全部属性
        for (int i = 0; i < fields.length; i++) {
            //获取属性的权限修饰符
            int modifiers = fields[i].getModifiers();
            //获取属性的的类型
            Class<?> type = fields[i].getType();
            //还原权限修饰符
            String string = Modifier.toString(modifiers);
            //打印属性信息
            System.out.println("属性："+string+" "+type.getName()+" "+fields[i].getName());
        }
        //获取本类的所有方法（包括继承父类的方法和实现接口的方法）
        Method[] methods = c.getMethods();
        //遍历方法
        for (int i = 0; i < methods.length; i++) {
            //获取方法的返回值类型
            Class<?> returnType = methods[i].getReturnType();
            //获取方法的所有参数类型
            Class<?>[] parameterTypes = methods[i].getParameterTypes();
            //获取方法的权限修饰符
            int modifiers = methods[i].getModifiers();
            //还原方法的权限修饰符
            String string = Modifier.toString(modifiers);
            //打印方法信息
            System.out.print("方法："+string+" "+returnType.getName()+" "
            +methods[i].getName()+"(");
            //遍历方法的所有参数
            for (int j = 0; j < parameterTypes.length; j++) {
                //打印参数的类型
                System.out.print(parameterTypes[j].getName()+" "+"arg"+j);
                if (j<parameterTypes.length-1)
                    System.out.print(",");

            }
            System.out.println(")");
        }
        //通过无参构造方法 产生AddEquation实例
       AddEquation addEquation= (AddEquation)c.newInstance();
        addEquation.setNumberOne((short) 1);
        addEquation.setNumberTwo((short) 1);
        System.out.print("通过无参构造方法 产生AddEquation实例: ");
        System.out.println(addEquation);



    }
}
