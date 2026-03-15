package com.klu.hibercrud4;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HQLDemo {

public static void main(String[] args) {

Session session = HibernateUtil.getSessionFactory().openSession();

System.out.println("Sort by price ascending");

Query q1 = session.createQuery("from Product order by price asc");
List<Product> list1 = q1.list();

for(Product p:list1)
System.out.println(p.getName()+" "+p.getPrice());

System.out.println("Sort by price descending");

Query q2 = session.createQuery("from Product order by price desc");
List<Product> list2 = q2.list();

for(Product p:list2)
System.out.println(p.getName()+" "+p.getPrice());

System.out.println("Total products");

Query q3 = session.createQuery("select count(*) from Product");
System.out.println(q3.uniqueResult());

session.close();

}
}