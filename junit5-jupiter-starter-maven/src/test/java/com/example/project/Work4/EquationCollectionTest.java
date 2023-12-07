package com.example.project.Work4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EquationCollectionTest {
    private EquationCollection equationCollection;

    @BeforeEach
    void init() {
        equationCollection = new EquationCollection();
        System.out.println("equationCollection测试开始：");
    }

    @AfterEach
    void tearDown() {
        System.out.println("equationCollection测试结束：");
    }

    @Test
    void generate() {
        int i = 0;
        equationCollection.generate(5, new EquationCheckerOfRange(0, 100));
        Iterator<IEqualtion> iterator = equationCollection.iterator();
        while (iterator.hasNext()) {
            IEqualtion next = iterator.next();
            i++;
        }
        assertEquals(5, i, "出现错误：结果应为5");
    }

    @ParameterizedTest(name = "使用@ValueSource测试")
    // @ValueSource 里每个参数都会运行目标方法，
    @ValueSource(ints = {10, 20, 30})
    void UesValueSource(int a) {
        int i = 0;
        equationCollection.generate(a, new EquationCheckerOfRange(0, 100));
        Iterator<IEqualtion> iterator = equationCollection.iterator();
        while (iterator.hasNext()) {
            IEqualtion next = iterator.next();
            i++;
        }
        assertEquals(a, i, "出现错误：结果应为"+a);
    }

    //重复性测试  value 为重复次数 getCurrentRepetition()为当前是第几次
    //getTotalRepetitions()为总次数
    @RepeatedTest(value = 6, name = "使用@RepeatedTest测试")
    void UseRepeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("第" + repetitionInfo.getCurrentRepetition() + "次  " + "共" + repetitionInfo.getTotalRepetitions() + "次");
        equationCollection.generate(5, new EquationCheckerOfRange(0, 100));
        Iterator<IEqualtion> iterator = equationCollection.iterator();
        //判断是否超时
        assertTimeout(java.time.Duration.ofMillis(2), () -> {
            int i = 0;
            while (iterator.hasNext()) {
                IEqualtion next = iterator.next();
                i++;
            }
            assertEquals(5, i, "出现错误：结果应为5");
        });
    }
}