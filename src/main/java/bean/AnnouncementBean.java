package bean;

import entity.Announcement;
import facade.AnnouncementFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AnnouncementBean implements Serializable {

    @EJB
    private AnnouncementFacadeLocal dao;
  
    private Announcement announcement;
    private List<Announcement> announcementList;

    public Announcement getAnnouncement() {
        if (this.announcement == null) {
            this.announcement = new Announcement();
        }
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public List<Announcement> getAnnouncementList() {
        this.announcementList = dao.findAll();
        return announcementList;
    }

    public void setAnnouncementList(List<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    public void updateForm(Announcement tm) {
        this.announcement = tm;
    }

    public void create() {
        dao.create(this.announcement);
        this.announcement = new Announcement();
    }

    public void update() {
        dao.edit(this.announcement);
        this.announcement = new Announcement();

    }

    public String delete(Announcement tm) {
        dao.remove(tm);
        this.clearForm();
        return "/admin/announcement/announcement?faces-redirect=true ";

    }

    public int record() {
        return dao.count();
    }

    public void clearForm() {
        this.announcement = new Announcement();
    }

}
