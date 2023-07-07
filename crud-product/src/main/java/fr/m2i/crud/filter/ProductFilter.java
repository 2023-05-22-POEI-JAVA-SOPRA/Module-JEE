package fr.m2i.crud.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import fr.m2i.crud.entity.Product;

@WebFilter("/Product")
public class ProductFilter extends HttpFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		if (httpRequest.getMethod().equals("POST") && stringExists(httpRequest, response, "name")
				&& stringExists(httpRequest, response, "description") && floatEsists(httpRequest, response, "price")
				&& intExists(httpRequest, response, "quantity")) {
			chain.doFilter(request, response);

		} else if (httpRequest.getMethod().equals("DELETE") && intExists(httpRequest, response, "id")) {
			chain.doFilter(request, response);
		} else if (httpRequest.getMethod().equals("PUT") && intExists(httpRequest, response, "id")
				&& stringExists(httpRequest, response, "name") && stringExists(httpRequest, response, "description")
				&& floatEsists(httpRequest, response, "price") && intExists(httpRequest, response, "quantity")) {
			chain.doFilter(request, response);
		} else if (httpRequest.getMethod().equals("GET")) {
			chain.doFilter(request, response);
		}
	}

	private boolean intExists(HttpServletRequest httpRequest, ServletResponse response, String string)
			throws IOException {
		if (stringExists(httpRequest, response, string)) {
			try {
				Integer.parseInt(httpRequest.getParameter(string));
				return true;
			} catch (Exception e) {
				response.getWriter().append("The request parameters where present but has bad type");
				return false;
			}
		}
		return false;
	}

	public boolean stringExists(HttpServletRequest request, ServletResponse response, String name) throws IOException {
		String str = request.getParameter(name);
		if (str == null) {
			response.getWriter().append("The request parameters where not present");
			return false;
		} else if (str.equals("")) {
			response.getWriter().append("The request parameters where present but has no value");
			return false;
		}
		return true;
	}

	public boolean floatEsists(HttpServletRequest request, ServletResponse response, String name) throws IOException {
		if (stringExists(request, response, name)) {
			try {
				Float.parseFloat(request.getParameter(name));
				return true;
			} catch (Exception e) {
				response.getWriter().append("The request parameters where present but has bad type");
				return false;
			}
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
