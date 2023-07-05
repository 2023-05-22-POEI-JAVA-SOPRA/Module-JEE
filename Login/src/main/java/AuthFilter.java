

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


@WebFilter( urlPatterns = {"/TimeSheet", "/DashBoard"})
public class AuthFilter extends HttpFilter implements Filter {
       
	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = httpRequest.getHeader("token");
		
		
		if ("fehoahHDFZUADHZL".equals(token)) {
			chain.doFilter(request, response);			
		}
	}
	public void destroy() {	}
}
