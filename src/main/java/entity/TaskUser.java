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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author kutlu
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"task_id", "user_id"}))
public class TaskUser implements Serializable {

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

    
    public ModuleUser getUser() {
   
        return this.user;
    }
    
    public void setUser(ModuleUser user) {
        this.user = user;
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
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
        if (!(object instanceof TaskUser)) {
            return false;
        }
        TaskUser other = (TaskUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TaskUser[ id=" + id + " ]";
    }

}
