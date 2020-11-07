/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.DayOff;
import facade.DayOffFacadeLocal;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.Temporal;

/**
 *
 * @author kutlu
 */
@Named
@ViewScoped
public class DayOffBean implements Serializable {

    @EJB
    private DayOffFacadeLocal dao;

    private DayOff dayOff;
    private List<DayOff> dayOffList;

    public DayOff getDayOff() {
        if (this.dayOff == null) {
            this.dayOff = new DayOff();
        }
        return dayOff;
    }

    public void setDayOff(DayOff dayOff) {
        this.dayOff = dayOff;
    }    
    
    
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private final Date date=new Date(0000);
      
    public List<DayOff> getDayOffList() {        
      //  dao.removeTwo(dao.deleteOldRecord(date));
       //System.out.println(dao.deleteOldRecord(date));
       this.dayOffList = this.dao.findAll();            
       return dayOffList;
    }

    public void setDayOffList(List<DayOff> dayOffList) {
        this.dayOffList = dayOffList;
    }

    public void updateForm(DayOff dof) {
        this.dayOff = dof;
    }

    public void create() {
        dao.create(this.dayOff);
        this.dayOff = new DayOff();
    }

    public void update() {
        dao.edit(this.dayOff);
        this.dayOff = new DayOff();
    }

    public String delete(DayOff dof) {
        dao.remove(dof);
        this.clearForm();
        return "/admin/dayoff/dayoff?faces-redirect=true ";

    }

    public int record() {
        return dao.count();
    }

    public void clearForm() {
        this.dayOff = new DayOff();
    }

}
