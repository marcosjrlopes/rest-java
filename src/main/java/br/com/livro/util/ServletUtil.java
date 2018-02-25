package br.com.livro.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ServletUtil {
	
	public static void writeXML(HttpServletResponse resp, String xml) throws IOException{
		if(xml != null) {
			PrintWriter write = resp.getWriter();
			resp.setContentType("application/xml;charset=UTF-8");
			write.write(xml);
			write.close();
		}
	}
	
	public static void writeJSON(HttpServletResponse resp, String json) throws IOException{
		if(json != null) {
			PrintWriter write = resp.getWriter();
			resp.setContentType("application/json;charset=UTF-8");
			write.write(json);
			write.close();
		}
	}
	
}
