/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.facade;

import com.merqury.phoebe.entity.PrayerRequest;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeffersonbienaime
 */
@Local
public interface PrayerRequestFacadeLocal {

    void create(PrayerRequest prayerRequest);

    void edit(PrayerRequest prayerRequest);

    void remove(PrayerRequest prayerRequest);

    PrayerRequest find(Object id);

    List<PrayerRequest> findAll();

    List<PrayerRequest> findRange(int[] range);

    int count();
    
}
