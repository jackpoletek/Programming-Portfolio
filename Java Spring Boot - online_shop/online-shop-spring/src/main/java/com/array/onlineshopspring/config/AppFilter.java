//package com.array.onlineshopspring.config;
//
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Objects;
//
//@Component
//@WebFilter("/*")
//public class AppFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletResponse httpServletRes = (HttpServletResponse) servletResponse;
//
//        httpServletRes.setHeader("Access-Control-Allow-Origin", getOriginHeader(httpServletRes));
//        httpServletRes.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        httpServletRes.setHeader("Access-Control-Allow-Headers", "Origin, Access-Control-Allow-Origin, Content-Type," +
//                "Accept, Authorization, X-Requested-With, Access-Control-Request-Method, Access-Control-Request-Headers");
//        httpServletRes.setHeader("Access-Control-Allow-Credentials", "true");
//        httpServletRes.setHeader("Access-Control-Max-Age", "43200");
//
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    private String getOriginHeader(HttpServletResponse httpServletRes) {
//
//        String servletResHeader = "";
//
//        if (Objects.nonNull(httpServletRes) && !StringUtils.hasLength(servletResHeader)) {
//            servletResHeader = httpServletRes.getHeader("Access-Control-Allow-Origin");
//            return servletResHeader;
//        }
//        return "*";
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
