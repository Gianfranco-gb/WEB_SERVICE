package udl.cat;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import udl.cat.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-17T18:32:11")
@StaticMetamodel(Content.class)
public class Content_ { 

    public static volatile SingularAttribute<Content, String> node;
    public static volatile SingularAttribute<Content, String> description;
    public static volatile SingularAttribute<Content, Integer> id;
    public static volatile SingularAttribute<Content, String> title;
    public static volatile CollectionAttribute<Content, Users> usersCollection;

}