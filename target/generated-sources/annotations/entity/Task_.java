package entity;

import entity.ModuleUser;
import entity.Team;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-05T20:48:23")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile ListAttribute<Task, Team> teams;
    public static volatile SingularAttribute<Task, Date> endDate;
    public static volatile ListAttribute<Task, ModuleUser> moduleUsers;
    public static volatile SingularAttribute<Task, String> description;
    public static volatile SingularAttribute<Task, String> taskName;
    public static volatile SingularAttribute<Task, Long> id;
    public static volatile SingularAttribute<Task, Date> startingDate;
    public static volatile SingularAttribute<Task, ModuleUser> user;

}