package com.belf33.spring.rest.dao;

import com.belf33.spring.rest.dao.EmployeeDAO;
import com.belf33.spring.rest.entity.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployee() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Employee"
                , Employee.class).getResultList();
    }

    @Override
    public void addEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, id);
        session.delete(employee);
    }
}
