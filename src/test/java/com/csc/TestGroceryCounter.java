package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

  GroceryCounter counter;

  @BeforeEach
  void setUp() {;
    counter = new GroceryCounter();
  }

  // Put your tests here!

  @Test
  void testZero() {
    counter.ones();
    assertEquals("$1.00", counter.getTotal());
  }
  @Test
  void testOne() {
    for(int i = 0; i < 5; i++){
        counter.tens();
    }
    assertEquals("$50.00", counter.getTotal());
  }

  @Test
  void testTwo() {
    for(int i = 0; i < 10; i++){
        counter.tens();
    }
    assertEquals("$0.00", counter.getTotal());
  }

  @Test
  void testThree() {
    for(int i = 0; i < 10; i++){
        counter.ones();
    }
    assertEquals("$10.00", counter.getTotal());
  }

  @Test
  void testFour() {
    for(int i = 0; i < 20; i++){
        counter.tens();
    }
    int overloads = counter.number_of_overloads();
    assertEquals(2, overloads);
    assertEquals("$0.00", counter.getTotal());
  }
  @Test
  void testFive() {
    for(int i = 0; i < 21; i++){
        counter.tens();
    }
    counter.ones();
    counter.tenths();
    counter.hundredths(); //"should be $11.11 and 2 overloads"
    counter.clear();
    assertEquals(0, counter.number_of_overloads());
    assertEquals("$0.00", counter.getTotal());
  }
  @Test
  void testSix() {
    for(int i = 0; i < 9; i++){
        counter.tens();
    }
    for(int i = 0; i < 10; i++){
        counter.ones();
    }
    for(int i = 0; i < 9; i++){
        counter.hundredths();
    }
    for(int i = 0; i < 9; i++){
        counter.tenths();
    }
    assertEquals("$0.99", counter.getTotal());
  }
}
