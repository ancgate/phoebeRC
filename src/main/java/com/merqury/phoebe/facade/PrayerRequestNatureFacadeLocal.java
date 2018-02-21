/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.facade;

import com.merqury.phoebe.entity.PrayerRequestNature;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeffersonbienaime
 */
@Local
public interface PrayerRequestNatureFacadeLocal {

    void create(PrayerRequestNature prayerRequestNature);

    void edit(PrayerRequestNature prayerRequestNature);

    void remove(PrayerRequestNature prayerRequestNature);

    PrayerRequestNature find(Object id);

    List<PrayerRequestNature> findAll();

    List<PrayerRequestNature> findRange(int[] range);

    int count();
    
}
