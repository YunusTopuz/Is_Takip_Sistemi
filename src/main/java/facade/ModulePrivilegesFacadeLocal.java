/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.ModulePrivileges;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kutlu
 */
@Local
public interface ModulePrivilegesFacadeLocal {
        
    void create(ModulePrivileges obj);

    void edit(ModulePrivileges obj);

    void remove(ModulePrivileges obj);

    List<ModulePrivileges> findAll();

    ModulePrivileges find(Object id);

    List<ModulePrivileges> findRange(int[] range);

    List<ModulePrivileges> search(int[] range, String field, String term);

    int searchCount(String field, String term);

    int count();

    ModulePrivileges findByField(String field, String value);
    
}
