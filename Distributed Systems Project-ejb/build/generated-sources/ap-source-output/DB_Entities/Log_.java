package DB_Entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-28T11:30:31")
@StaticMetamodel(Log.class)
public class Log_ { 

    public static volatile SingularAttribute<Log, Integer> messageId;
    public static volatile SingularAttribute<Log, Date> time;
    public static volatile SingularAttribute<Log, String> message;
    public static volatile SingularAttribute<Log, String> username;

}