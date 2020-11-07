/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.ModulePrivileges;
import facade.ModulePrivilegesFacadeLocal;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ModulePriviligesBean implements Serializable {

    @EJB
    private ModulePrivilegesFacadeLocal dao;

    private ModulePrivileges modulePrivileges;
    private List<ModulePrivileges> modulePrivilegesList;

    public ModulePrivileges getModulePrivileges() {
        if (this.modulePrivileges == null) {
            this.modulePrivileges = new ModulePrivileges();
        }
        return modulePrivileges;
    }

    public void setModulePrivileges(ModulePrivileges modulePrivileges) {
        this.modulePrivileges = modulePrivileges;
    }

    public List<ModulePrivileges> getModulePrivilegesList() {
        this.modulePrivilegesList = dao.findAll();
        return modulePrivilegesList;
    }

    public void setModulePrivilegesList(List<ModulePrivileges> modulePrivilegesList) {
        this.modulePrivilegesList = modulePrivilegesList;
    }

    public void updateForm(ModulePrivileges tm) {
        this.modulePrivileges = tm;
    }

    public void create() {
        dao.create(this.modulePrivileges);
        this.modulePrivileges = new ModulePrivileges();
    }

    public void update() {
        dao.edit(this.modulePrivileges);
        this.modulePrivileges = new ModulePrivileges();

    }

    public String delete(ModulePrivileges tm) {
        dao.remove(tm);
        this.clearForm();
        return "/admin/moduleprivileges/moduleprivileges?faces-redirect=true ";

    }

    public int record() {
        return dao.count();
    }

    public void clearForm() {
        this.modulePrivileges = new ModulePrivileges();
    }

}
