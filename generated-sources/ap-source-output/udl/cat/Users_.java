package udl.cat;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import udl.cat.Content;
import udl.cat.Node;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-17T18:32:11")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> nameUser;
    public static volatile SingularAttribute<Users, Content> idContent;
    public static volatile SingularAttribute<Users, Node> idNode;

}