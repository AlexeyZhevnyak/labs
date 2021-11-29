package com.example.lab7;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", servletNames = {"contentServlet"})
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String refferer = httpRequest.getHeader("referer");
        if (refferer == null) {
            final String contextPath = httpRequest.getContextPath();
            httpResponse.sendRedirect(contextPath);
            return;
        }
        chain.doFilter(request, response);
    }
}
