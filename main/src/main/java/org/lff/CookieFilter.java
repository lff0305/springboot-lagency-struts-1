package org.lff;

import org.lff.action.TestAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Feifei Liu
 * @datetime Jul 12 2017 15:28
 */
@WebFilter(filterName="cookieFilter",urlPatterns="/*", asyncSupported = true)
public class CookieFilter implements Filter{

    private Logger logger = LoggerFactory.getLogger(CookieFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Filter " + this.getClass().getName() + " inited.");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
            Cookie[] cookies = httpServletRequest.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    c.setSecure(true);
                }
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
