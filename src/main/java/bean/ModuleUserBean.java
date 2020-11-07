package bean;

import entity.ModuleUser;
import facade.ModuleUserFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class ModuleUserBean implements Serializable {

    @EJB
    private ModuleUserFacadeLocal dao;

    private ModuleUser moduleUser;
    private List<ModuleUser> moduleUserList;
    private ModuleUser moduleUserTwo;

    public ModuleUser getModuleUserTwo() {
        if (this.moduleUserTwo == null) {
            this.moduleUserTwo = new ModuleUser();
        }
        return moduleUserTwo;
    }

    public void setModuleUserTwo(ModuleUser moduleUserTwo) {
        this.moduleUserTwo = moduleUserTwo;
    }

    //bunu izinli kullanıcılar için oluştrdum
    private List<ModuleUser> dayoffUserList;

    public List<ModuleUser> getDayoffUserList() {
        this.dayoffUserList = dao.findAll();
        //kullanıcının izinde olup olmadıgını burada kontrol et
        return dayoffUserList;
    }

    public void setDayoffUserList(List<ModuleUser> dayoffUserList) {
        this.dayoffUserList = dayoffUserList;
    }

    public ModuleUser getModuleUser() {
        if (this.moduleUser == null){
            this.moduleUser = new ModuleUser();
        }
        return moduleUser;
    }

    public void setModuleUser(ModuleUser moduleUser) {
        this.moduleUser = moduleUser;
    }

    public List<ModuleUser> getModuleUserList() {
        this.moduleUserList = dao.findAll();
        return moduleUserList;
    }

    public void setModuleUserList(List<ModuleUser> moduleUserList) {
        this.moduleUserList = moduleUserList;
    }

    public void updateForm(ModuleUser tm) {
        this.moduleUser = tm;
    }

    public String updateFormTwo(ModuleUser tm) {
        this.moduleUserTwo = tm;
        return "/admin/moduleuser/profil?faces-redirect=true ";
    }

    public void create() {
        dao.create(this.moduleUser);
        this.moduleUser = new ModuleUser();
    }

    public void update() {
        dao.edit(this.moduleUser);
        this.moduleUser = new ModuleUser();

    }

    public String delete(ModuleUser tm) {
        dao.remove(tm);
        this.clearForm();
        return "/admin/moduleuser/moduleuser?faces-redirect=true ";

    }

    public int record() {
        return dao.count();
    }

    public void clearForm() {
        this.moduleUser = new ModuleUser();
    }

    public String back() {
        return "/admin/moduleuser/moduleuser?faces-redirect=true ";
    }

}
