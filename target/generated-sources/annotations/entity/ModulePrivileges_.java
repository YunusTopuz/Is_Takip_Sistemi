package entity;

import entity.ModuleGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-05T20:48:23")
@StaticMetamodel(ModulePrivileges.class)
public class ModulePrivileges_ { 

    public static volatile SingularAttribute<ModulePrivileges, Boolean> R;
    public static volatile SingularAttribute<ModulePrivileges, Boolean> C;
    public static volatile SingularAttribute<ModulePrivileges, Boolean> D;
    public static volatile SingularAttribute<ModulePrivileges, Boolean> U;
    public static volatile SingularAttribute<ModulePrivileges, String> module;
    public static volatile ListAttribute<ModulePrivileges, ModuleGroup> moduleGroups;
    public static volatile SingularAttribute<ModulePrivileges, Long> id;
    public static volatile SingularAttribute<ModulePrivileges, ModuleGroup> group;

}