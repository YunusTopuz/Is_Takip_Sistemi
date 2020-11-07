/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.HaveSeen;
import facade.HaveSeenFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author kutlu
 */
@Named
@ViewScoped
public class HaveSeenBean implements Serializable{
    
    @EJB
    private HaveSeenFacadeLocal dao;
    private HaveSeen haveSeen;
    private List<HaveSeen> haveSeenList;

    public HaveSeen getHaveSeen() {
        if(this.haveSeen==null){
           this.haveSeen=new HaveSeen();
        }
        return haveSeen;
    }

    public void setHaveSeen(HaveSeen haveSeen) {
        this.haveSeen = haveSeen;
    }

    public List<HaveSeen> getHaveSeenList() {
        if(this.haveSeenList==null){
        this.haveSeenList=dao.findAll();
        }
        return haveSeenList;
    }

    public void setHaveSeenList(List<HaveSeen> haveSeenList) {
        this.haveSeenList = haveSeenList;
    }
    
    

     
    public void updateForm(HaveSeen tm) {
        this.haveSeen = tm;
    }

    public void create() {
        dao.create(this.haveSeen);
        this.haveSeen = new HaveSeen();
    }

    public void update() {
        dao.edit(this.haveSeen);
        this.haveSeen = new HaveSeen();

    }

    public String delete(HaveSeen tm) {
        dao.remove(tm);
        this.clearForm();
        return "/admin/haveseenforteam/haveseenforteam?faces-redirect=true ";

    }

    public int record() {
        return dao.count();
    }


    
    public void clearForm() {
        this.haveSeen = new HaveSeen();
    }


    
    
}
