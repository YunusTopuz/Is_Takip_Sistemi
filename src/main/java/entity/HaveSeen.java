/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;

/**
 *
 * @author kutlu
 */
@Entity
public class HaveSeen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    private Task task;

    @OneToOne
    private ModuleUser user;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date viewedDate;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public ModuleUser getUser() {
        return user;
    }

    public void setUser(ModuleUser user) {
        this.user = user;
    }

    @PrePersist
    public Date getViewedDate() {
        if(this.viewedDate==null){
        this.setViewedDate(new Date());}
        return this.viewedDate;
    }

    public void setViewedDate(Date viewedDate) {
        this.viewedDate = viewedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HaveSeen)) {
            return false;
        }
        HaveSeen other = (HaveSeen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.HaveSeen[ id=" + id + " ]";
    }

}
