/*
 * This file was automatically generated by EvoSuite
 * Wed Feb 21 18:55:11 GMT 2018
 */

package com.merqury.phoebe.beans;

import org.junit.Test;
import static org.junit.Assert.*;
import com.merqury.phoebe.beans.MaritalStatusFacade;
import javax.persistence.EntityManager;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class MaritalStatusFacade_ESTest extends MaritalStatusFacade_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MaritalStatusFacade maritalStatusFacade0 = new MaritalStatusFacade();
      Injector.injectEntityManager(maritalStatusFacade0, (Class<?>) MaritalStatusFacade.class);
      Injector.validateBean(maritalStatusFacade0, (Class<?>) MaritalStatusFacade.class);
      EntityManager entityManager0 = maritalStatusFacade0.getEntityManager();
      assertNotNull(entityManager0);
  }
}