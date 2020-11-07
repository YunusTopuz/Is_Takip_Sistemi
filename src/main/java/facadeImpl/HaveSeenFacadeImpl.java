/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeImpl;

import entity.HaveSeen;
import entity.ModuleUser;
import entity.Task;
import javax.ejb.Stateless;
import facade.HaveSeenFacadeLocal;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author kutlu
 */
@Stateless
public class HaveSeenFacadeImpl extends BaseFacade<HaveSeen> implements HaveSeenFacadeLocal {

    public HaveSeenFacadeImpl() {
        super(HaveSeen.class);
    }

    public boolean hasRecord(Task ts, ModuleUser mu) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<HaveSeen> rt = cq.from(HaveSeen.class);
        cq.select(rt);
        cq.where(cb.and(cb.equal(rt.get("task"), ts), cb.equal(rt.get("user"), mu)));
        Query q = getEntityManager().createQuery(cq);
        if (q.getResultList().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
