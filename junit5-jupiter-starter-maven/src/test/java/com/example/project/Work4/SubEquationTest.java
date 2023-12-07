package com.example.project.Work4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SubEquationTest {
    private SubEquation subEquation ;
    @BeforeEach
    void init() {
        subEquation = new SubEquation();
        System.out.println("SubEquation测试开始：");
    }

    @AfterEach
    void tearDown() {
        System.out.println("SubEquation测试结束：");
    }

    @Test
    @DisplayName("测试1")
    void calculate() {
        subEquation.setNumberOne((short) 3);
        subEquation.setNumberTwo((short) 2);
        assertEquals(1, subEquation.calculate(), "出现错误：3-2应该等于1");
    }
    //  @ParameterizedTest 表示参数化测试
    @ParameterizedTest(name = "使用@CsvSource测试")
    //  @CsvSource 可以注入指定 一组数据，
    //  用每个逗号分隔的值来匹配一个测试方法对应的参数，
    @CsvSource({
            "5,2,3",
            "6,2,4",
            "9,3,6"})
    void UseCsvSourceText(int one, int two, int result) {
        subEquation.setNumberOne((short) one);
        subEquation.setNumberTwo((short) two);
        assertEquals(result, subEquation.calculate(), () -> "出现错误：" + one + "-" + two + "应该等于" + result);

    }

    @ParameterizedTest(name = "使用@ValueSource测试")
    // @ValueSource 里每个参数都会运行目标方法，
    @ValueSource(ints = {10, 20, 30})
    void UesValueSource(int a) {
        assertTrue(a <= 100 && a >= 0);
    }

    //重复性测试  value 为重复次数 getCurrentRepetition()为当前是第几次
    //getTotalRepetitions()为总次数
    @RepeatedTest(value = 10, name = "使用@RepeatedTest测试")
    void UseRepeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("第" + repetitionInfo.getCurrentRepetition() + "次  " + "共" + repetitionInfo.getTotalRepetitions() + "次");
        subEquation.setNumberOne((short) 5);
        subEquation.setNumberTwo((short) 2);
        assertEquals(3, subEquation.calculate(), "出现错误：5-2应该等于3");
    }

    @ParameterizedTest(name = "使用@MethodSource测试")

    //  指定一个返回的可迭代对象 的方法作为数据源
    @MethodSource("dataSet")
    void UseMethodSourceTest(data data){
        subEquation.setNumberOne(data.one);
        subEquation.setNumberTwo(data.two);
        assertEquals(data.result,subEquation.calculate(),"出现错误："+data.one+"-"+data.two+"应该等于"+data.result);

    }

    //创建一个静态数据类
    public static class data{
        public short one;
        public short two;
        public short result;

        public data(short one, short two, short result) {
            this.one = one;
            this.two = two;
            this.result = result;
        }
    }
    //创建一个返回数据集合的静态方法
    public static Set<data> dataSet(){
        Set<data> datas =new HashSet<data>();
        datas.add(new data((short)5,(short)2,(short)3));
        datas.add(new data((short)8,(short)3,(short)5));
        datas.add(new data((short)5,(short)1,(short)4));
        datas.add(new data((short)4,(short)1,(short)3));
        return datas;
    }


}