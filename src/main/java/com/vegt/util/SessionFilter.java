package com.vegt.util;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "sessionFilter",urlPatterns = {"*"})
public class SessionFilter implements Filter {
    //标识符，表示当前用户未登录
    String NO_LOGIN = "未登陆";

    //不需要登陆就可以访问的页面
    String [] inCludeUrl = new String[]{"/user/login","/user/reg","/vegt/vegtlist/","/order/cuser","/order/inorder"};



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        System.out.println("filteruri"+uri);
        System.out.println("SESSION:"+request.getSession().getAttributeNames());
        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);

        if(!needFilter){ //不需要过滤，直接传给下一个过滤器
            filterChain.doFilter(servletRequest,servletResponse);
        }else{ //需要过滤
            if( request.getSession().getAttributeNames()!=null){
                filterChain.doFilter(request,response);
            }else{
                String requestType = request.getHeader("X-Requested-With");
                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
                    response.getWriter().write(NO_LOGIN);
                }else{
                    response.sendRedirect(request.getContextPath()+"login.html");
                }
                return;
            }
        }

    }

    //是否需要过滤
    public boolean isNeedFilter(String uri) {

        for (String includeUrl : inCludeUrl) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void destroy() {

    }
}
