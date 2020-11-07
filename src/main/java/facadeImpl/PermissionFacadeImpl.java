/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeImpl;

import entity.ModuleGroup;
import entity.ModulePrivileges;
import javax.ejb.Stateless;
import facade.PermissionFacadeLocal;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author kutlu
 */
@Stateless
public class PermissionFacadeImpl extends BaseFacade<ModulePrivileges> implements PermissionFacadeLocal {

    public PermissionFacadeImpl() {
        super(ModulePrivileges.class);
    }

    public boolean hasPerm(ModuleGroup mg, String module, String process) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<ModulePrivileges> rt = cq.from(ModulePrivileges.class);
        cq.select(rt);
        cq.where(cb.and(cb.equal(rt.get("module"), module),
                cb.equal(rt.get(process), true),
                cb.equal(rt.get("group"), mg)));
        Query q = getEntityManager().createQuery(cq);
        if (q.getResultList().isEmpty()) {
            return false;
        }
        return true;

    }

}
