package facadeImpl;

import entity.Announcement;
import facade.AnnouncementFacadeLocal;
import javax.ejb.Stateless;

@Stateless
public class AnnouncementFacadeImpl extends BaseFacade<Announcement> implements AnnouncementFacadeLocal {

    public AnnouncementFacadeImpl() {
        super(Announcement.class);
    }

}
