package org.advancia.filippo.restStatelessEjb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("tipoftheday")
@SessionScoped
public class TipOfTheDay implements Serializable{
	
	@EJB
    TipSessionBean tips;

    @GET
    @Produces("text/html")
    public String processGet() {
        return getTip();
    }

    @POST
    @Produces("text/html")
    public String processPost() {
        return getTip();
    }

    private String getTip() {
        return tips.getTip() + " Requests Served On this Session: " + tips.getCounter();
    }
   
}