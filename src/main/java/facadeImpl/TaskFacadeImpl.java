package facadeImpl;

import entity.ModuleUser;
import entity.Task;
import entity.Team;
import javax.ejb.Stateless;
import facade.TaskFacadeLocal;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class TaskFacadeImpl extends BaseFacade<Task> implements TaskFacadeLocal {

    public TaskFacadeImpl() {
        super(Task.class);
    }

    @Override
    public List<Task> taskForUser(ModuleUser mu) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createTupleQuery();
        Root<Task> rt = cq.from(Task.class);
        cq.select(rt);

        cq.where(rt.get("moduleUsers").in(mu));

        //cq.where(rt.get("teams").get("moduleUsers").in(mu));

        cq.orderBy(cb.desc(rt.get("id")));
        TypedQuery q = getEntityManager().createQuery(cq);
        return q.getResultList();

    }

    @Override
    public List<Task> findByTeam(List<Team> tm) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Task> rt = cq.from(Task.class);
        cq.select(rt);

        cq.where(rt.get("teams").in(tm));
        cq.orderBy(cb.desc(rt.get("id")));
        Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }

}
