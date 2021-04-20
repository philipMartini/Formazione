package org.advancia.filippo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
        	sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static final ThreadLocal session = new ThreadLocal();

    public static Session currentSession()
    {
		Session s = (Session) session.get();
		if (s == null)
		{
		    s = sessionFactory.openSession();
		    session.set(s);
		}
		return s;
    }

    public static void closeSession()
    {
		Session s = (Session) session.get();
		if (s != null)
		    s.close();
		session.set(null);
    }
}
