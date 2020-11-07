/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.DayOff;
import entity.ModuleUser;
import java.sql.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kutlu
 */
@Local
public interface DayOffFacadeLocal {
    
    void create(DayOff obj);

    void edit(DayOff obj);

    void remove(DayOff obj);

    List<DayOff> findAll();

    DayOff find(Object id);

    List<DayOff> findRange(int[] range);

    List<DayOff> search(int[] range, String field, String term);

    int searchCount(String field, String term);

    int count();

    DayOff findByField(String field, String value);
    
    boolean isPermUser(List<ModuleUser> mu);
    
    boolean isOffUser(ModuleUser mu,Date date); 
    
}
