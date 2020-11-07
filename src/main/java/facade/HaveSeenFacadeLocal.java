/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.HaveSeen;
import entity.ModuleUser;
import entity.Task;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kutlu
 */
@Local
public interface HaveSeenFacadeLocal {

    void create(HaveSeen obj);

    void edit(HaveSeen obj);

    void remove(HaveSeen obj);

    List<HaveSeen> findAll();

    HaveSeen find(Object id);

    List<HaveSeen> findRange(int[] range);

    List<HaveSeen> search(int[] range, String field, String term);

    int searchCount(String field, String term);

    int count();

    HaveSeen findByField(String field, String value);

    boolean hasRecord(Task ts, ModuleUser mu);

}
