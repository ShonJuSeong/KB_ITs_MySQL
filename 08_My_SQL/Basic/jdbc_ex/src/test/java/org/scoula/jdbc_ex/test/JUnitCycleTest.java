package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
public class JUnitCycleTest{
    @BeforeAll // 전체테스트시작전1회실행, static 선언
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }
    @BeforeEach// 테스트케이스를시작하기전마다실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }
    @Test
    public void test1() {
        System.out.println("test1");
    }
    @Test
    public void test2() {
        System.out.println("test2");
    }
    @Test
    public void test3() {
        System.out.println("test3");
    }
    @AfterEach// 테스트케이스를종료하기전마다실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }
    @AfterAll // 전체테스트를마지고종료하기전1회. static 선언
    static void afterAll() {
        System.out.println("@AfterAll");
    }
}