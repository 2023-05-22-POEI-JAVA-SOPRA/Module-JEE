package fr.m2i.crud.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/disabled")
public class UserFilter extends HttpFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		
		switch (httpRequest.getMethod()) {
			case "POST":
				if ( stringExists(httpRequest, response, "name") && 
					 stringExists(httpRequest, response, "login")&&
					 passwordExists(httpRequest, response, "password") &&
					 emailExists(httpRequest, response, "email")&&
					 intExists(httpRequest, response, "age")) {
					chain.doFilter(request, response);
				}
				break;
			case "PUT":
				if ( stringExists(httpRequest, response, "name") && 
						 stringExists(httpRequest, response, "login")&&
						 passwordExists(httpRequest, response, "password") &&
						 emailExists(httpRequest, response, "email")&&
						 intExists(httpRequest, response, "age") &&
						 intExists(httpRequest, response, "id")) {
						chain.doFilter(request, response);
					}
				break;
			case "DELETE":
				if (intExists(httpRequest, response, "id")) {
					chain.doFilter(request, response);
				}
				break;
			case "GET":
				chain.doFilter(request, response);
				break;
		}
	}

	public void destroy() {
	}

	public boolean stringExists(HttpServletRequest request, ServletResponse response, String name) throws IOException {
		String value = request.getParameter(name);

		if (value == null) {
			response.getWriter().print("filed :" + name + " was null");
			return false;
		} else if (value.equals("")) {
			response.getWriter().print("filed :" + name + " was empty");
			return false;
		}

		return true;
	}

	public boolean intExists(HttpServletRequest request, ServletResponse response, String name) throws IOException {

		if (stringExists(request, response, name)) {
			String value = request.getParameter(name);
			try {
				Integer.parseInt(value);
				return true;
			} catch (NumberFormatException e) {
				response.getWriter().print("filed :" + name + " has a bad type");
				return false;
			}
		}
		return false;
	}

	public boolean emailExists(HttpServletRequest request, ServletResponse response, String name) throws IOException {
		if (stringExists(request, response, name)) {
			String value = request.getParameter(name);
			Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(value);

			if (matcher.matches()) {
				return true;
			} else {
				response.getWriter().print("filed :" + name + " has not an email");
				return false;
			}

		}
		return false;
	}

	public boolean passwordExists(HttpServletRequest request, ServletResponse response, String name)
			throws IOException {

		if (stringExists(request, response, name)) {
			String value = request.getParameter(name);

			if (value.length() >= 8) {
				return true;
			} else {
				response.getWriter().print("filed :" + name + " require minimum of 8 chars");
				return false;
			}

		}
		return false;
	}

}
