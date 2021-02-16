package org.example;

import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test(description = "第一个描述",testName ="第一个名字")
    public void shouldAnswerWithTrue(){
        System.out.println("你好");
    }
    @Test(description = "第2个描述",testName ="第2个名字")
    public void shouldAnswerWithTrue2(){
        System.out.println("你好");
    }
}
