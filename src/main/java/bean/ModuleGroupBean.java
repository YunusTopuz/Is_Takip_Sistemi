package bean;

import entity.ModuleGroup;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import facade.ModuleGroupFacadeLocal;

@Named
@ViewScoped
public class ModuleGroupBean implements Serializable {

    @EJB
    private ModuleGroupFacadeLocal dao;          

    private ModuleGroup moduleGroup;
    private List<ModuleGroup> moduleGroupList;

    public ModuleGroup getModuleGroup() {
        if (this.moduleGroup == null) {
            this.moduleGroup = new ModuleGroup();
        }
        return moduleGroup;
    }

    public void setModuleGroup(ModuleGroup moduleGroup) {
        this.moduleGroup = moduleGroup;
    }

    public List<ModuleGroup> getModuleGroupList() {
        this.moduleGroupList = dao.findAll();
        return moduleGroupList;
    }

    public void setModuleGroupList(List<ModuleGroup> moduleGroupList) {
        this.moduleGroupList = moduleGroupList;
    }

    public void updateForm(ModuleGroup tm) {
        this.moduleGroup = tm;
    }

    public void create() {
        dao.create(this.moduleGroup);
        
        this.moduleGroup = new ModuleGroup();
    }

    public void update() {
        dao.edit(this.moduleGroup);
        this.moduleGroup = new ModuleGroup();

    }

    public String delete(ModuleGroup tm) {
        dao.remove(tm);
        this.clearForm();
        return "/admin/modulegroup/modulegroup?faces-redirect=true ";

    }

    public int record() {
        return dao.count();
    }

    public void clearForm() {
        this.moduleGroup = new ModuleGroup();
    }

}
