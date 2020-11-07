package facade;

import entity.Announcement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AnnouncementFacadeLocal {
   
    void create(Announcement obj);

    void edit(Announcement obj);

    void remove(Announcement obj);

    List<Announcement> findAll();

    Announcement find(Object id);

    List<Announcement> findRange(int[] range);

    List<Announcement> search(int[] range, String field, String term);

    int searchCount(String field, String term);

    int count();

    Announcement findByField(String field, String value);
}
