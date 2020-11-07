/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.ModuleUser;
import entity.Task;
import entity.TaskUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kutlu
 */
@Local
public interface TaskUserFacadeLocal {
    
    
    void create(TaskUser obj);

    void edit(TaskUser obj);

    void remove(TaskUser obj);

    List<TaskUser> findAll();

    TaskUser find(Object id);

    List<TaskUser> findRange(int[] range);

    List<TaskUser> search(int[] range, String field, String term);

    int searchCount(String field, String term);

    int count();

    TaskUser findByField(String field, String value);
    
    boolean hasRecord(Task ts,ModuleUser mu);
    
    TaskUser haveSeenDate(Task ts);
    
    
}
