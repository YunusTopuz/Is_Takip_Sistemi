package facadeImpl;

import entity.DayOff;
import entity.ModuleUser;
import javax.ejb.Stateless;
import facade.DayOffFacadeLocal;
import java.sql.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class DayOffFacadeImpl extends BaseFacade<DayOff> implements DayOffFacadeLocal {

    public DayOffFacadeImpl() {
        super(DayOff.class);
    }

    @Override
    public boolean isPermUser(List<ModuleUser> mu) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<DayOff> rt = cq.from(DayOff.class);
        cq.select(rt);

//      cq.where(cb.and(cb.equal(rt.get("mail"), .), cb.equal(rt.get("password"), password)));
        cq.where(rt.get("user").in(mu));

        Query q = getEntityManager().createQuery(cq);
        if (q.getResultList().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isOffUser(ModuleUser mu, Date date) {
//        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
//        CriteriaQuery cq = cb.createQuery();
//        Root<DayOff> rt = cq.from(DayOff.class);
//        cq.select(rt);
//        cq.where(
//                cb.and(
//                        cb.equal(rt.get("user"), mu),
//                        cb.equal(date.after(rt.get("startingDate"))),
//                        cb.equal(date.before(rt.get("endDate")))
//                      
//                )
//        );
//        Query q = getEntityManager().createQuery(cq);
//        if (q.getResultList().isEmpty()) {
//            return false;
//        } else {
//            return true;
//        }
        return true;
    }
}
