/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;

/**
 *
 * @author kutlu
 */
@Entity
public class Task implements Serializable {

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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "task_user", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<ModuleUser> moduleUsers;

    public List<ModuleUser> getModuleUsers() {
        return moduleUsers;
    }

    public void setModuleUsers(List<ModuleUser> moduleUsers) {
        this.moduleUsers = moduleUsers;
    }
    

  
    
    

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "task_team", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    private String taskName;
    private String description;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date startingDate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date endDate;
    
    
    @OneToOne
    private ModuleUser user;
    
    @PrePersist
    public void setCreated(){
        this.setUser((ModuleUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("valid_user")) ;        
    }
                     

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ModuleUser getUser() {
        return user;
    }

    public void setUser(ModuleUser user) {
        this.user = user;
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
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.taskName;
    }

}
