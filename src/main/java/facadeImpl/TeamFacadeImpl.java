package facadeImpl;

import entity.Team;
import javax.ejb.Stateless;
import facade.TeamFacadeLocal;

@Stateless
public class TeamFacadeImpl extends BaseFacade<Team> implements TeamFacadeLocal {

    public TeamFacadeImpl() {
        super(Team.class);
    }

}
