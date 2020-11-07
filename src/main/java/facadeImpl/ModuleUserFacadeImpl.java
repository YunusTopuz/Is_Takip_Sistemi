package facadeImpl;

import entity.ModuleUser;
import javax.ejb.Stateless;
import facade.ModuleUserFacadeLocal;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class ModuleUserFacadeImpl extends BaseFacade<ModuleUser> implements ModuleUserFacadeLocal {

    public ModuleUserFacadeImpl() {
        super(ModuleUser.class);
    }

    public ModuleUser login(String mail, String password) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<ModuleUser> rt = cq.from(ModuleUser.class);
        cq.select(rt);
        cq.where(cb.and(cb.equal(rt.get("mail"), mail), cb.equal(rt.get("password"), password)));
        Query q = getEntityManager().createQuery(cq);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            return (ModuleUser) q.getResultList().get(0);
        }
    }

}
