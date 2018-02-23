/*
 * This file was automatically generated by EvoSuite
 * Wed Feb 21 18:49:20 GMT 2018
 */

package com.merqury.phoebe.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.merqury.phoebe.controller.RolesController;
import com.merqury.phoebe.entity.Permissions;
import com.merqury.phoebe.entity.Roles;
import com.merqury.phoebe.facade.PermissionsFacadeLocal;
import com.merqury.phoebe.facade.RolesFacadeLocal;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class RolesController_ESTest extends RolesController_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn((List) null).when(permissionsFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      RolesFacadeLocal rolesFacadeLocal0 = mock(RolesFacadeLocal.class, new ViolatedAssumptionAnswer());
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "roleFacade", (Object) rolesFacadeLocal0);
      Injector.validateBean(rolesController0, (Class<?>) RolesController.class);
      // Undeclared exception!
      try { 
        Injector.executePostConstruct((Object) rolesController0, (Class<?>) RolesController.class);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Failed to execute @PostConstructor in com.merqury.phoebe.controller.RolesController
         //
         verifyException("org.evosuite.runtime.javaee.injection.Injector", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      LinkedList<Permissions> linkedList0 = new LinkedList<Permissions>();
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(permissionsFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      RolesFacadeLocal rolesFacadeLocal0 = mock(RolesFacadeLocal.class, new ViolatedAssumptionAnswer());
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "roleFacade", (Object) rolesFacadeLocal0);
      Injector.validateBean(rolesController0, (Class<?>) RolesController.class);
      Injector.executePostConstruct((Object) rolesController0, (Class<?>) RolesController.class);
      List<Roles> list0 = rolesController0.getSelectedRoles();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      LinkedList<Permissions> linkedList0 = new LinkedList<Permissions>();
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(permissionsFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      LinkedList<Roles> linkedList1 = new LinkedList<Roles>();
      Roles roles0 = new Roles();
      linkedList1.add(roles0);
      RolesFacadeLocal rolesFacadeLocal0 = mock(RolesFacadeLocal.class, new ViolatedAssumptionAnswer());
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "roleFacade", (Object) rolesFacadeLocal0);
      Injector.validateBean(rolesController0, (Class<?>) RolesController.class);
      Injector.executePostConstruct((Object) rolesController0, (Class<?>) RolesController.class);
      rolesController0.setSelectedRoles(linkedList1);
      List<Roles> list0 = rolesController0.getSelectedRoles();
      assertFalse(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      LinkedList<Permissions> linkedList0 = new LinkedList<Permissions>();
      Permissions permissions0 = new Permissions();
      linkedList0.offer(permissions0);
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(permissionsFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      RolesFacadeLocal rolesFacadeLocal0 = mock(RolesFacadeLocal.class, new ViolatedAssumptionAnswer());
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "roleFacade", (Object) rolesFacadeLocal0);
      Injector.validateBean(rolesController0, (Class<?>) RolesController.class);
      Injector.executePostConstruct((Object) rolesController0, (Class<?>) RolesController.class);
      List<Permissions> list0 = rolesController0.getPermissions();
      assertFalse(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      LinkedList<Permissions> linkedList0 = new LinkedList<Permissions>();
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(permissionsFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      RolesFacadeLocal rolesFacadeLocal0 = mock(RolesFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn((List) null).when(rolesFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "roleFacade", (Object) rolesFacadeLocal0);
      Injector.validateBean(rolesController0, (Class<?>) RolesController.class);
      Injector.executePostConstruct((Object) rolesController0, (Class<?>) RolesController.class);
      List<Roles> list0 = rolesController0.findAll();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      LinkedList<Permissions> linkedList0 = new LinkedList<Permissions>();
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(permissionsFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      LinkedList<Roles> linkedList1 = new LinkedList<Roles>();
      Roles roles0 = new Roles();
      linkedList1.add(roles0);
      RolesFacadeLocal rolesFacadeLocal0 = mock(RolesFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList1).when(rolesFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "roleFacade", (Object) rolesFacadeLocal0);
      Injector.validateBean(rolesController0, (Class<?>) RolesController.class);
      Injector.executePostConstruct((Object) rolesController0, (Class<?>) RolesController.class);
      List<Roles> list0 = rolesController0.findAll();
      assertFalse(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      LinkedList<Permissions> linkedList0 = new LinkedList<Permissions>();
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(permissionsFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      RolesFacadeLocal rolesFacadeLocal0 = mock(RolesFacadeLocal.class, new ViolatedAssumptionAnswer());
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "roleFacade", (Object) rolesFacadeLocal0);
      Injector.validateBean(rolesController0, (Class<?>) RolesController.class);
      Injector.executePostConstruct((Object) rolesController0, (Class<?>) RolesController.class);
      // Undeclared exception!
      try { 
        rolesController0.update();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Arrays", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      LinkedList<Permissions> linkedList0 = new LinkedList<Permissions>();
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0, (List<Permissions>) null).when(permissionsFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      RolesFacadeLocal rolesFacadeLocal0 = mock(RolesFacadeLocal.class, new ViolatedAssumptionAnswer());
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "roleFacade", (Object) rolesFacadeLocal0);
      Injector.validateBean(rolesController0, (Class<?>) RolesController.class);
      Injector.executePostConstruct((Object) rolesController0, (Class<?>) RolesController.class);
      // Undeclared exception!
      try { 
        rolesController0.init();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      // Undeclared exception!
      try { 
        rolesController0.findAll();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.merqury.phoebe.controller.RolesController", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      LinkedList<Permissions> linkedList0 = new LinkedList<Permissions>();
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      doReturn(linkedList0).when(permissionsFacadeLocal0).findAll();
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      RolesFacadeLocal rolesFacadeLocal0 = mock(RolesFacadeLocal.class, new ViolatedAssumptionAnswer());
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "roleFacade", (Object) rolesFacadeLocal0);
      Injector.validateBean(rolesController0, (Class<?>) RolesController.class);
      Injector.executePostConstruct((Object) rolesController0, (Class<?>) RolesController.class);
      // Undeclared exception!
      try { 
        rolesController0.insert();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Arrays", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      RolesController rolesController0 = new RolesController();
      PermissionsFacadeLocal permissionsFacadeLocal0 = mock(PermissionsFacadeLocal.class, new ViolatedAssumptionAnswer());
      Injector.inject(rolesController0, (Class<?>) RolesController.class, "permissionFacade", (Object) permissionsFacadeLocal0);
      List<Permissions> list0 = rolesController0.getPermissions();
      assertNull(list0);
  }
}
