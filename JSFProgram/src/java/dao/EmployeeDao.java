package dao;

import entity.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EmployeeDao {

    public boolean saveEmployee(Employee e) {

        Transaction t = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            
            t = session.beginTransaction();

            session.saveOrUpdate(e);
            t.commit();
            
            return true;
        } catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        } finally{
            session.close();
        }
        return false;

    }
    public boolean deleteEmployee(int id){
        
        Transaction t = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        
        try {
            t = s.beginTransaction();
            
            Employee e =(Employee) s.load(Employee.class, new Integer(id));
            s.delete(e);
            t.commit();
            
            return true;
            
        } catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        } finally{
            s.close();
        }
        return false;
    }
    public List<Employee> viewAll(){
    
        SessionFactory factory = HibernateUtil.getSessionFactory();
        
        Session s = factory.openSession();
        
        List<Employee> eList =s.createQuery("from Employee").list();
        
        eList.toString();
        
        return eList;
        
    }
    public void updateEmployee(Employee e){
    
        Transaction t = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            
            t = session.beginTransaction();

            session.update(e);
            t.commit();
            
            
        } catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        } finally{
            session.close();
        }
        
    }
    public Employee getEmployeeById(int id){
    
        System.out.println("Get employee by Id = " +id+ "\n..................");
        
        Session s =null;
        Employee e = null;
        
        try {
            
            s = HibernateUtil.getSessionFactory().openSession();
            e = (Employee) s.get(Employee.class, id);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
            s.close();
        }
        return e;
    }
}
