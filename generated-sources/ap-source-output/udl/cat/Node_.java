package udl.cat;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import udl.cat.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-17T18:32:11")
@StaticMetamodel(Node.class)
public class Node_ { 

    public static volatile SingularAttribute<Node, Integer> id;
    public static volatile CollectionAttribute<Node, Users> usersCollection;
    public static volatile SingularAttribute<Node, String> nameNode;

}