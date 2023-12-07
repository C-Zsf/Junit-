package com.example.project.Work4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EquationCheckerOfRangeTest {
    private EquationCheckerOfRange equationCheckerOfRange;
    private IEqualtion addEquation;
    private IEqualtion subEquation;

    @BeforeEach
    void init() {
        equationCheckerOfRange = new EquationCheckerOfRange(0, 100);
        System.out.println("EquationCheckerOfRange测试开始：");
    }

    @AfterEach
    void tearDown() {
        System.out.println("EquationCheckerOfRange测试结束：");
    }

    @Test
    void check() {
        addEquation = new AddEquation((short) 2, (short) 6);
        subEquation = new SubEquation((short) 6, (short) 2);
        assertEquals(true, equationCheckerOfRange.check(addEquation), "出现错误：结果应为True");
        assertEquals(true, equationCheckerOfRange.check(subEquation), "出现错误：结果应为True");
    }
    //  @ParameterizedTest 表示参数化测试
    @ParameterizedTest(name = "使用@MethodSource测试")
    //  指定一个返回的可迭代对象 的方法作为数据源
    @MethodSource("dataSet")
    void UseMethodSourceTest(IEqualtion data){
        assertEquals(true, equationCheckerOfRange.check(data), "出现错误：结果应为True");
    }

    //重复性测试  value 为重复次数 getCurrentRepetition()为当前是第几次
    //getTotalRepetitions()为总次数
    @RepeatedTest(value = 5, name = "使用@RepeatedTest测试")
    void UseRepeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("第" + repetitionInfo.getCurrentRepetition() + "次  " + "共" + repetitionInfo.getTotalRepetitions() + "次");
        addEquation = new AddEquation((short) 20, (short) 60);
        subEquation = new SubEquation((short) 66, (short) 2);
        assertEquals(true, equationCheckerOfRange.check(addEquation), "出现错误：结果应为True");
        assertEquals(true, equationCheckerOfRange.check(subEquation), "出现错误：结果应为True");

    }

    //创建一个返回数据集合的静态方法
    public static Set<IEqualtion> dataSet() {
        Set<IEqualtion> datas = new HashSet<IEqualtion>();
        datas.add(new AddEquation((short) 50, (short) 20));
        datas.add(new SubEquation((short) 80, (short) 30));
        datas.add(new AddEquation((short) 50, (short) 10));
        datas.add(new SubEquation((short) 40, (short) 10));
        return datas;
    }


}