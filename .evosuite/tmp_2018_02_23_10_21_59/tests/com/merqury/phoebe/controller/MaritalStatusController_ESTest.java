/*
 * This file was automatically generated by EvoSuite
 * Fri Feb 23 15:39:14 GMT 2018
 */

package com.merqury.phoebe.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.merqury.phoebe.controller.MaritalStatusController;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class MaritalStatusController_ESTest extends MaritalStatusController_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MaritalStatusController maritalStatusController0 = null;
      try {
        maritalStatusController0 = new MaritalStatusController();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.merqury.phoebe.controller.AbstractController", e);
      }
  }
}
