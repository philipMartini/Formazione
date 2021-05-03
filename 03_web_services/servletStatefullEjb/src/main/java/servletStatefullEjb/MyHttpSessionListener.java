package servletStatefullEjb;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session Is being Destroyed......SAVING DATA");
    }

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

    // ...
}