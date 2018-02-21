/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.facade;

import com.merqury.phoebe.entity.NoteType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeffersonbienaime
 */
@Local
public interface NoteTypeFacadeLocal {

    void create(NoteType noteType);

    void edit(NoteType noteType);

    void remove(NoteType noteType);

    NoteType find(Object id);

    List<NoteType> findAll();

    List<NoteType> findRange(int[] range);

    int count();
    
}
