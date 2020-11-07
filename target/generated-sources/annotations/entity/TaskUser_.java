package entity;

import entity.ModuleUser;
import entity.Task;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-05T20:48:23")
@StaticMetamodel(TaskUser.class)
public class TaskUser_ { 

    public static volatile SingularAttribute<TaskUser, Date> viewedDate;
    public static volatile SingularAttribute<TaskUser, Task> task;
    public static volatile SingularAttribute<TaskUser, Long> id;
    public static volatile SingularAttribute<TaskUser, ModuleUser> user;

}