package entity;

import entity.ModuleUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-05T20:48:23")
@StaticMetamodel(DayOff.class)
public class DayOff_ { 

    public static volatile SingularAttribute<DayOff, Date> endDate;
    public static volatile SingularAttribute<DayOff, Long> id;
    public static volatile SingularAttribute<DayOff, Date> startingDate;
    public static volatile SingularAttribute<DayOff, ModuleUser> user;

}