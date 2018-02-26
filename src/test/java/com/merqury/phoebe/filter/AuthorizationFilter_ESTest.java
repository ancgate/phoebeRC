/*
 * This file was automatically generated by EvoSuite
 * Mon Feb 26 20:59:17 GMT 2018
 */

package com.merqury.phoebe.filter;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.merqury.phoebe.filter.AuthorizationFilter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class AuthorizationFilter_ESTest extends AuthorizationFilter_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      AuthorizationFilter authorizationFilter0 = new AuthorizationFilter();
      FilterChain filterChain0 = mock(FilterChain.class, new ViolatedAssumptionAnswer());
      // Undeclared exception!
      try { 
        authorizationFilter0.doFilter((ServletRequest) null, (ServletResponse) null, filterChain0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.merqury.phoebe.filter.AuthorizationFilter", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      AuthorizationFilter authorizationFilter0 = new AuthorizationFilter();
      HttpServletResponse httpServletResponse0 = mock(HttpServletResponse.class, new ViolatedAssumptionAnswer());
      HttpServletResponseWrapper httpServletResponseWrapper0 = new HttpServletResponseWrapper(httpServletResponse0);
      ServletResponseWrapper servletResponseWrapper0 = new ServletResponseWrapper(httpServletResponseWrapper0);
      // Undeclared exception!
      try { 
        authorizationFilter0.doFilter((ServletRequest) null, servletResponseWrapper0, (FilterChain) null);
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // javax.servlet.ServletResponseWrapper cannot be cast to javax.servlet.http.HttpServletResponse
         //
         verifyException("com.merqury.phoebe.filter.AuthorizationFilter", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      AuthorizationFilter authorizationFilter0 = new AuthorizationFilter();
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      doReturn("/public/").when(httpServletRequest0).getRequestURI();
      doReturn((HttpSession) null).when(httpServletRequest0).getSession(anyBoolean());
      HttpServletRequestWrapper httpServletRequestWrapper0 = new HttpServletRequestWrapper(httpServletRequest0);
      HttpServletResponse httpServletResponse0 = mock(HttpServletResponse.class, new ViolatedAssumptionAnswer());
      HttpServletResponseWrapper httpServletResponseWrapper0 = new HttpServletResponseWrapper(httpServletResponse0);
      FilterChain filterChain0 = mock(FilterChain.class, new ViolatedAssumptionAnswer());
      authorizationFilter0.doFilter(httpServletRequestWrapper0, httpServletResponseWrapper0, filterChain0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      AuthorizationFilter authorizationFilter0 = new AuthorizationFilter();
      HttpSession httpSession0 = mock(HttpSession.class, new ViolatedAssumptionAnswer());
      doReturn((Object) null).when(httpSession0).getAttribute(anyString());
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      doReturn("javax.faces.resource").when(httpServletRequest0).getRequestURI();
      doReturn(httpSession0).when(httpServletRequest0).getSession(anyBoolean());
      HttpServletRequestWrapper httpServletRequestWrapper0 = new HttpServletRequestWrapper(httpServletRequest0);
      HttpServletResponse httpServletResponse0 = mock(HttpServletResponse.class, new ViolatedAssumptionAnswer());
      HttpServletResponseWrapper httpServletResponseWrapper0 = new HttpServletResponseWrapper(httpServletResponse0);
      FilterChain filterChain0 = mock(FilterChain.class, new ViolatedAssumptionAnswer());
      authorizationFilter0.doFilter(httpServletRequestWrapper0, httpServletResponseWrapper0, filterChain0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      AuthorizationFilter authorizationFilter0 = new AuthorizationFilter();
      HttpSession httpSession0 = mock(HttpSession.class, new ViolatedAssumptionAnswer());
      doReturn(authorizationFilter0).when(httpSession0).getAttribute(anyString());
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      doReturn((String) null, (String) null).when(httpServletRequest0).getContextPath();
      doReturn("", "", "", "/login.xhtml").when(httpServletRequest0).getRequestURI();
      doReturn(httpSession0, (HttpSession) null, (HttpSession) null, (HttpSession) null).when(httpServletRequest0).getSession(anyBoolean());
      HttpServletRequestWrapper httpServletRequestWrapper0 = new HttpServletRequestWrapper(httpServletRequest0);
      HttpServletResponse httpServletResponse0 = mock(HttpServletResponse.class, new ViolatedAssumptionAnswer());
      HttpServletResponseWrapper httpServletResponseWrapper0 = new HttpServletResponseWrapper(httpServletResponse0);
      FilterChain filterChain0 = mock(FilterChain.class, new ViolatedAssumptionAnswer());
      authorizationFilter0.doFilter(httpServletRequestWrapper0, httpServletResponseWrapper0, filterChain0);
      FilterChain filterChain1 = mock(FilterChain.class, new ViolatedAssumptionAnswer());
      authorizationFilter0.doFilter(httpServletRequestWrapper0, httpServletResponseWrapper0, filterChain1);
      FilterChain filterChain2 = mock(FilterChain.class, new ViolatedAssumptionAnswer());
      authorizationFilter0.doFilter(httpServletRequestWrapper0, httpServletResponseWrapper0, filterChain2);
      FilterChain filterChain3 = mock(FilterChain.class, new ViolatedAssumptionAnswer());
      authorizationFilter0.doFilter(httpServletRequestWrapper0, httpServletResponseWrapper0, filterChain3);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      AuthorizationFilter authorizationFilter0 = new AuthorizationFilter();
      authorizationFilter0.destroy();
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      AuthorizationFilter authorizationFilter0 = new AuthorizationFilter();
      authorizationFilter0.init((FilterConfig) null);
  }
}