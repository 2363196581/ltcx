package com.connxun.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mac on 2017/6/15.
 */
public class AJaxFilter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub
    }


    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse)response;
        resp.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, "
                + "If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, "
                + "Content-Type, X-E4M-With");
        resp.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        chain.doFilter(request, resp);
    }


    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }

}

