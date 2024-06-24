package com.sameer.myprojects;

import junit.framework.TestCase;

public class calculateTest extends TestCase {
    Calculate calculate;


    //onstart


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        calculate = new Calculate();

    }

    //testcase
    public void testAdd() {
        int expected = 30;
        int actual = calculate.add(10,20);
        assertEquals(expected,actual);

    }
    //ondestr
    // oy

    @Override
    protected void tearDown()throws Exception{
        super.tearDown();
    }
}