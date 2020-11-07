package bean;

import entity.ModuleGroup;
import entity.ModuleUser;
import facade.ModuleUserFacadeLocal;
import facade.PermissionFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    @EJB
    private ModuleUserFacadeLocal dao;
    
    @EJB
    private PermissionFacadeLocal perDao;


    private ModuleUser moduleUser;

    private List<ModuleGroup> mgList;
    

    private ModuleGroup selectedGroup;

    private ModuleUser user;

    public ModuleUser getUser() {
        this.user = dao.login(this.moduleUser.getMail(), this.moduleUser.getPassword());
        return this.user;
    }

    public void setUser(ModuleUser user) {
        this.user = user;
    }

    public boolean hasPermission(String module, String process){
        return this.perDao.hasPerm(getSelectedGroup(), module, process);
    }

    public ModuleGroup getSelectedGroup() {
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("selected_group", this.selectedGroup);///////////////////
        
        return this.selectedGroup;
    }

    public void setSelectedGroup(ModuleGroup selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public String redirect() {
        return "/admin/announcement/announcement.xhtml";
    }

    public String login() {
        ModuleUser user = dao.login(this.moduleUser.getMail(), this.moduleUser.getPassword());
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", user);
            return "/selectRank.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı Mail veya Şifre!"));
            return "/index2.xhtml";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.moduleUser=null;
        return "/index2.xhtml";
    }

    public ModuleUser getModuleUser() {
        if (this.moduleUser == null) {
            this.moduleUser = new ModuleUser();
        }
        return moduleUser;
    }

    public void setModuleUser(ModuleUser moduleUser) {
        this.moduleUser = moduleUser;
    }

    public List<ModuleGroup> getMgList() {
        this.mgList = dao.login(this.moduleUser.getMail(), this.moduleUser.getPassword()).getModuleGroups();
        return mgList;
    }

    public void setMgList(List<ModuleGroup> mgList) {
        this.mgList = mgList;
    }


    

}
