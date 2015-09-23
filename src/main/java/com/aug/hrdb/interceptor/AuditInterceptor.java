package com.aug.hrdb.interceptor;

import java.io.Serializable;
import java.util.Calendar;




import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.hibernate.Criteria;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.aug.hrdb.entities.BaseEntity;
import com.aug.hrdb.entities.Login;
import com.aug.hrdb.repositories.LoginRepository;

@Component
public class AuditInterceptor extends EmptyInterceptor{

	private static final long serialVersionUID = 1L;
	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();


	private Login getUser()
	{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Session session = factory.openSession();
        Criteria c = session.createCriteria(Login.class);
        c.add(Restrictions.eq("username", user.getUsername()));  
        Login login = (Login) c.uniqueResult();
        session.close();
		return  login;
	}



	@Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, org.hibernate.type.Type[] types) {
		boolean theReturn = false;
		if (entity instanceof BaseEntity)
	    {
	        for (int i=0; i<propertyNames.length; i++)
	        {
	        	if ("auditFlag".equals(propertyNames[i]))
	            {
	                currentState[i] = "U";
	                theReturn = true;
	            }
	            if ("updatedTimeStamp".equals(propertyNames[i]))
	            {
	                currentState[i] = Calendar.getInstance().getTime();
	                theReturn = true;
	            }
	            if ("updatedBy".equals(propertyNames[i]))
	            {
	                currentState[i] = getUser().getId();
	                theReturn = true;
	            }
	        }
	    }
		System.out.println("onFlushDirty");
		return theReturn;
    }
	
	@Override
    public boolean onSave(Object entity, Serializable id, Object[] state,
            String[] propertyNames, Type[] types) {
		boolean theReturn = false;
		if (entity instanceof BaseEntity)
	    {
	        for (int i=0; i<propertyNames.length; i++)
	        {
	        	if ("auditFlag".equals(propertyNames[i]))
	            {
	                state[i] = "C";
	                theReturn = true;
	            }
				if ("createdTimeStamp".equals(propertyNames[i]))
	            {
	                state[i] = Calendar.getInstance().getTime();
	                theReturn = true;
	            }
	            if ("createdBy".equals(propertyNames[i]))
	            {
	                state[i] = getUser().getId();
	                theReturn = true;
	            }
	        }
	    }
		
		System.out.println("onDelete");
		return theReturn;
    }
	
	
}
