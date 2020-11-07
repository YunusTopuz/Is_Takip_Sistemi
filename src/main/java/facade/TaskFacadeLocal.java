/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.ModuleUser;
import entity.Task;
import entity.Team;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kutlu
 */
@Local
public interface TaskFacadeLocal {

    void create(Task obj);

    void edit(Task obj);

    void remove(Task obj);

    List<Task> findAll();

    Task find(Object id);

    List<Task> findRange(int[] range);

    List<Task> search(int[] range, String field, String term);

    int searchCount(String field, String term);

    int count();

    Task findByField(String field, String value);


    List<Task> findByTeam(List<Team> tm);
    List<Task> taskForUser(ModuleUser mu);

}
