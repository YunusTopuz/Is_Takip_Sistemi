package entity;

import entity.ModuleUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-05T20:48:23")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, ModuleUser> getterBy;
    public static volatile ListAttribute<Message, ModuleUser> moduleUsers;
    public static volatile SingularAttribute<Message, String> topic;
    public static volatile SingularAttribute<Message, Long> id;
    public static volatile SingularAttribute<Message, String> text;
    public static volatile SingularAttribute<Message, ModuleUser> sendedBy;

}