package com.ssdi.app.junit.homepage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Example {
	
   @Test
   public void testAdd() {
      String str= "Junit is working fine";
      assertEquals("Junit is working fine",str);
   }
}