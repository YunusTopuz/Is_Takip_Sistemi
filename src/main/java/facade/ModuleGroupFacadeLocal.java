package facade;

import entity.ModuleGroup;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ModuleGroupFacadeLocal {

    
    void create(ModuleGroup obj);

    void edit(ModuleGroup obj);

    void remove(ModuleGroup obj);

    List<ModuleGroup> findAll();

    ModuleGroup find(Object id);

    List<ModuleGroup> findRange(int[] range);

    List<ModuleGroup> search(int[] range, String field, String term);

    int searchCount(String field, String term);

    int count();

    ModuleGroup findByField(String field, String value);

}
