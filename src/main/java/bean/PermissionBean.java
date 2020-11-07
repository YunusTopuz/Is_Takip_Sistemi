/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.ModuleGroup;
import entity.ModuleUser;
import facade.ModuleUserFacadeLocal;
import facade.PermissionFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author kutlu
 */
@Named
@SessionScoped
public class PermissionBean implements Serializable {

    @EJB
    private PermissionFacadeLocal dao;


    private ModuleGroup mg;
    

    
    
    
    public ModuleGroup getMg() {
        return this.mg;
    }
    public void setMg(ModuleGroup mg) {
        this.mg = mg;
    }

}
