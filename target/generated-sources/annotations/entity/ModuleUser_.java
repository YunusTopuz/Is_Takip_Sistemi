package entity;

import entity.ModuleGroup;
import entity.Team;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-05T20:48:23")
@StaticMetamodel(ModuleUser.class)
public class ModuleUser_ { 

    public static volatile SingularAttribute<ModuleUser, String> password;
    public static volatile ListAttribute<ModuleUser, Team> teams;
    public static volatile SingularAttribute<ModuleUser, String> mail;
    public static volatile SingularAttribute<ModuleUser, String> surname;
    public static volatile SingularAttribute<ModuleUser, String> name;
    public static volatile ListAttribute<ModuleUser, ModuleGroup> moduleGroups;
    public static volatile SingularAttribute<ModuleUser, Long> id;

}