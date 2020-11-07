/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author kutlu
 */
@Entity
public class ModulePrivileges implements Serializable {

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
    @JoinTable(name = "privileges_group", joinColumns = @JoinColumn(name = "privileges_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<ModuleGroup> moduleGroups;

    public List<ModuleGroup> getModuleGroups() {
        return moduleGroups;
    }

    public void setModuleGroups(List<ModuleGroup> moduleGroups) {
        this.moduleGroups = moduleGroups;
    }

    @OneToOne
    private ModuleGroup group;
        
    private boolean C;
    private boolean R;
    private boolean U;
    private boolean D;
    
   private String module;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
   
   


    public ModuleGroup getGroup() {
        return group;
    }

    public void setGroup(ModuleGroup group) {
        this.group = group;
    }

    public boolean isC() {
        return C;
    }

    public void setC(boolean C) {
        this.C = C;
    }

    public boolean isR() {
        return R;
    }

    public void setR(boolean R) {
        this.R = R;
    }

    public boolean isU() {
        return U;
    }

    public void setU(boolean U) {
        this.U = U;
    }

    public boolean isD() {
        return D;
    }

    public void setD(boolean D) {
        this.D = D;
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
        if (!(object instanceof ModulePrivileges)) {
            return false;
        }
        ModulePrivileges other = (ModulePrivileges) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Privileges[ id=" + id + " ]";
    }

}
