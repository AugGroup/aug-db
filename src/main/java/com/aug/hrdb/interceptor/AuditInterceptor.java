package com.aug.hrdb.interceptor;

import java.io.Serializable;
import java.util.Calendar;
import org.hibernate.type.Type;
import org.hibernate.EmptyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.aug.hrdb.entities.BaseEntity;
import com.aug.hrdb.services.LoginService;

public class AuditInterceptor extends EmptyInterceptor{

	private static final long serialVersionUID = 1L;
	
	@Autowired LoginService loginService;

	private com.aug.hrdb.entities.Login getUser()
	{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return loginService.findByUserName(user.getUsername());
	}
	
	@Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, org.hibernate.type.Type[] types) {
		boolean theReturn = false;
		if (entity instanceof BaseEntity)
	    {
	        for (int i=0; i<propertyNames.length; i++)
	        {
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
