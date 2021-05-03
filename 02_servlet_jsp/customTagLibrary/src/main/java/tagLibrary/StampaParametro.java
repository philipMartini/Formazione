package tagLibrary;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class StampaParametro extends TagSupport{

	@Override
	public int doEndTag() throws JspException {
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		JspWriter writer = null;
		if(req.getParameter("utente") != null) {
			writer  = pageContext.getOut();
			
			try {
				writer.println("Ciao "+ req.getParameter("utente"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				writer.print("Ciao clicca qui per accedere!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return super.doEndTag();
	}

}
