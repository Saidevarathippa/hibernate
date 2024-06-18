package xyz.hibernate.basichiberante;

/**
 * Hello world!
 *
 */
import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta =  new MetadataSources(ssr).getMetadataBuilder().build();
    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    System.out.println("factory:"+ factory);
       Session session= factory.openSession();
       Transaction tx = session.beginTransaction();
       Employee emp=(Employee)session.get(Employee.class, 1);
       System.out.println(emp.getName()+"\t"+emp.getAddress()+"\t"+emp.getRole());
       System.out.println(emp.getName()+"\t"+emp.getAddress()+"\t"+emp.getRole());
         tx.commit();
         
    }
}
