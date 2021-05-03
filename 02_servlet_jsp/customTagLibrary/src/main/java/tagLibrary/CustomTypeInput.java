package tagLibrary;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomTypeInput extends TagSupport {
	
	private String nomeInput;
	private String valoreInput;
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter writer = null;
		String inputMarkup = "<input type=\"text\" name=\""+this.getNomeInput()+"\"  "
				+ "value=\""+this.getValoreInput()+ " \"  class=\"mycss\"/>";
		
			try {
				writer.println(inputMarkup);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return super.doEndTag();
		}

	public String getNomeInput() {
		return nomeInput;
	}

	public void setNomeInput(String nomeInput) {
		this.nomeInput = nomeInput;
	}

	public String getValoreInput() {
		return valoreInput;
	}

	public void setValoreInput(String valoreInput) {
		this.valoreInput = valoreInput;
	}
	
	
		
		
		
	}
