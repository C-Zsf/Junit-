/*
 * Copyright 2015-2022 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import java.util.Set;
import java.util.HashSet;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

// https://assertj.github.io/doc/
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTests {
    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
//        System.out.println("init annotatted with @BeforeEach");
        System.out.println("开始 @BeforeEach");
        System.out.println();
    }

    @Test
//    @DisplayName("A basic assert")
    @DisplayName("测试1")
    void useCodedValue() {
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    //	@ParameterizedTest 作为参数化测试的必要注解，替代了 @Test 注解。
    //	任何一个参数化测试方法都需要标记上该注解。
    //  @CsvSource 可以注入指定 CSV 格式 (comma-separated-values) 的一组数据，
    //  用每个逗号分隔的值来匹配一个测试方法对应的参数，
    @ParameterizedTest(name = "using CsvSource")
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3",
            "2, 2, 4"
    })
    void useCsvSource(int first, int second, int expectedResult) {
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    // @ValueSource 里每个参数都会运行目标方法，
    @ParameterizedTest(name = "using ValueSource")
    @ValueSource(ints = {1, 2, 3})
    void useValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }

    //重复性测试  value 为重复次数   currentRepetition 变量表示已经重复的次数，
    // totalRepetitions 变量表示总共要重复的次数，
    @RepeatedTest(value = 5, name = "using RepeatedTest")
    void useRepeatedTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("useRepeatedTest -> " + repetitionInfo.getCurrentRepetition());
        Assertions.assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "using MethodSource")
    //  指定一个返回的 Stream / Array / 可迭代对象 的方法作为数据源
    @MethodSource("equationProvider")
    void useMethodSource(SimpleTriplet triplet) {
        assertEquals(triplet.result, calculator.add(triplet.op1, triplet.op2), "should equal");
    }

    public static class SimpleTriplet {
        public int op1;
        public int op2;
        public int result;

        public SimpleTriplet(int op1, int op2, int result) {
            this.op1 = op1;
            this.op2 = op2;
            this.result = result;
        }
    }

    public static Set<SimpleTriplet> equationProvider() {
        Set<SimpleTriplet> set = new HashSet<SimpleTriplet>();
        set.add(new SimpleTriplet(0, 0, 0));
        set.add(new SimpleTriplet(0, 1, 1));
        set.add(new SimpleTriplet(0, 2, 2));
        return set;
    }

    @Test
    @DisplayName("using assert*** methods")
    void useAssert() {
        assertAll("testAssertAll",
                () -> assertEquals(1, 1),
                () -> assertEquals(2, 2));

        assertTimeout(java.time.Duration.ofMillis(10), () -> {
            Thread.currentThread().sleep(1);
        });

        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                throw new RuntimeException();
            }
        });
    }

    @Test
    @DisplayName("using assertJ methods")
    void useAssertJ() {
        assertThat("www.ncwu.edu.cn").isNotNull()
                .startsWith("www")
                .contains("ncwu")
                .endsWith("cn");
    }

    @Disabled
    @Test
    public void useDisabled() {
        assertTrue(true);
    }

    @AfterEach
    void tearDown() {
//        System.out.println("tearDown annotatted with @AfterEach");
        System.out.println("结束 @AfterEach");
    }
}
