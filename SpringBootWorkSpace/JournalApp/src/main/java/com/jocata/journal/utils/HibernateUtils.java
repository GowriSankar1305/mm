package com.jocata.journal.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
public class HibernateUtils {
	
	Logger logger = LoggerFactory.getLogger(HibernateUtils.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession()	{
		
		Session session = null;
		try	{
			session = sessionFactory.getCurrentSession();	
		}
		catch(Exception e)	{
			logger.error("(:) Error in getCurrentSession method(:)");
		}
		return session;
	}
	
	public Session getNewSession()	{
		Session session = null;
		session = sessionFactory.openSession();
		return session;
	}
	
	public void closeSession(Session session)	{
		if (session != null)
			session.close();
	}
	
	public <T> T saveEntity(T entity)	{
		logger.info("saveEntity(): Entity class ->> "+entity.getClass());
		Session session = null;
		try	{
			session = getCurrentSession();
			session.save(entity);
			return entity;
		}
		catch(Exception e)	{
			logger.error("(:) Error in saveEntity method (:)",e);
		}
		return null;
	}
	
	public <T> T loadEntityByUniqueStringProperty(Class<T> entityClass,String propertyName,String propertyvalue)	{
		
		logger.info("loadEntityByUniqueStringProperty() : ->> "+entityClass.getClass()+" propertyName: "+propertyName+" propertyvalue: "+propertyvalue);
		
		Session session = null;
		try	{
			session = getNewSession();
			T entity = (T) session.createCriteria(entityClass).add(Restrictions.eq(propertyName, propertyvalue)).uniqueResult();
			return entity;
		}
		catch(Exception e)	{
			logger.error("(:) Error in loadEntityByUniqueStringProperty method (:)",e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
}
