package com.wangby.filter;

import com.wangby.constant.AccountConstant;
import com.wangby.entity.Account;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*")
public class AccountFilter implements Filter {

    private static final String[] IGNORE_URI = {"/css", "/images", "/js", "/index", "/account/login", "/account/validataAccount"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String uri = request.getRequestURI();
        System.out.println(uri);

        boolean pass = canPassIgnore(uri);
        if (pass) {
            filterChain.doFilter(request, response);
            return;
        } else {
            Account account = (Account) request.getSession().getAttribute(AccountConstant.ACCOUNT);
            if (account == null) {
                response.sendRedirect("/account/login");
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean canPassIgnore(String uri) {
        for (int i = 0; i < IGNORE_URI.length; i++) {
            if (uri.startsWith(IGNORE_URI[i])) {
                return true;
            }
        }
        return false;
    }
}
