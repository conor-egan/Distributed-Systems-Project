package DB_Entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-28T11:30:30")
@StaticMetamodel(Purchases.class)
public class Purchases_ { 

    public static volatile SingularAttribute<Purchases, Integer> purchaseId;
    public static volatile SingularAttribute<Purchases, Integer> customerId;
    public static volatile SingularAttribute<Purchases, Date> time;
    public static volatile SingularAttribute<Purchases, String> customerName;
    public static volatile SingularAttribute<Purchases, Integer> purchaseAmount;

}