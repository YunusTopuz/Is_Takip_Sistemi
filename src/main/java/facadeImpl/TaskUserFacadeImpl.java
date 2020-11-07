package facadeImpl;

import entity.ModuleUser;
import entity.Task;
import entity.TaskUser;
import javax.ejb.Stateless;
import facade.TaskUserFacadeLocal;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class TaskUserFacadeImpl extends BaseFacade<TaskUser> implements TaskUserFacadeLocal {

    public TaskUserFacadeImpl() {
        super(TaskUser.class);
    }

    public boolean hasRecord(Task ts, ModuleUser mu) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<TaskUser> rt = cq.from(TaskUser.class);
        cq.select(rt);
        cq.where(cb.and(cb.equal(rt.get("task"), ts), cb.equal(rt.get("user"), mu)));
        Query q = getEntityManager().createQuery(cq);
        if (q.getResultList().isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    public TaskUser haveSeenDate(Task ts) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<TaskUser> rt = cq.from(TaskUser.class);
        cq.select(rt);
        cq.where(cb.equal(rt.get("task"), ts));
        Query q = getEntityManager().createQuery(cq);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            return (TaskUser) q.getResultList().get(0);
        }

    }

}
