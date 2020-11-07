package facade;

import entity.Team;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TeamFacadeLocal {

    void create(Team obj);

    void edit(Team obj);

    void remove(Team obj);

    List<Team> findAll();

    Team find(Object id);

    List<Team> findRange(int[] range);

    List<Team> search(int[] range, String field, String term);

    int searchCount(String field, String term);

    int count();

    Team findByField(String field, String value);
}
