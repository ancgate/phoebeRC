/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.facade;

import com.merqury.phoebe.entity.UserLoginHistory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeffersonbienaime
 */
@Local
public interface UserLoginHistoryFacadeLocal {

    void create(UserLoginHistory userLoginHistory);

    void edit(UserLoginHistory userLoginHistory);

    void remove(UserLoginHistory userLoginHistory);

    UserLoginHistory find(Object id);

    List<UserLoginHistory> findAll();

    List<UserLoginHistory> findRange(int[] range);

    int count();
    
}
