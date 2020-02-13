//package com.hwagain.mail.config;
//
//import com.hwagain.mail.entity.SysPer;
//import com.hwagain.mail.utils.Constants;
//import com.hwagain.mail.utils.ContentUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.util.StringUtils;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import javax.servlet.*;
//import javax.servlet.FilterConfig;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Base64;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Slf4j
//public class LogCostFilter implements Filter {
//
//    private static final Set<String> PASS_SET = Stream.of("/doc/sync", "/doc/sync/mail",
//            "/manage/authority/list","/manage/authority/user/list","/manage/authority/user/add","/manage/authority/user/give","/manage/authority/user/delete","/manage/authority/update",
//            "/forward/dept/list","/forward/no/forward/list","/forward/forward","/forward/public/list","/forward/public/one","/forward/public/save","/forward/public/set/list","/forward/public/set/one","/forward/public/set/save",
//            "/count/company/list", "/count/company/one", "/count/persons/one", "/statistics/company").collect(Collectors.toSet());
//
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//
//        String method = request.getMethod();
//        String authorization = request.getHeader("Authorization");
//        // 获取 servlet上下文
//        ServletContext sc = request.getSession().getServletContext();
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        if (method.equals("OPTIONS")) {
//            response.setStatus(HttpServletResponse.SC_OK);
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//
//
//        String path = request.getServletPath();
//        //String pathShort = path.replace("/doc/","");
//        if (!PASS_SET.contains(path)){
//            //通行
//            filterChain.doFilter(servletRequest,servletResponse);
//            return;
//        }
//        //System.out.println(authorization);
//        if (authorization != null){
//            boolean flag = true ;
//            byte[] base64decodedBytes = Base64.getDecoder().decode(authorization);
//            //姓名:编号:ID
//            String[] userData = new String(base64decodedBytes).split(":");
//
//
////            // 获取 spring 容器
//            AbstractApplicationContext cxt = (AbstractApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sc);
//            if(cxt != null && cxt.getBean("redisTemplate") != null){
//                // 取出 redisTemplate
//                RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("redisTemplate");
//                String perIds = (String) redisTemplate.opsForHash().get(Constants.REDIS_MAIL_AUTHORITY, userData[0]);
//                if (!StringUtils.isEmpty(perIds)){
//
//                    Set<String> idSet = Stream.of(perIds.split(",")).collect(Collectors.toSet());
//                    if (idSet.contains(Constants.SUPER_ADMIN_ID) && !path.startsWith("/manage")){
//                        //超级管理员(不能授权)
//                        filterChain.doFilter(servletRequest,servletResponse);
//                        flag = false ;
//                    } else {
//                        String hasPath = ContentUtils.SYS_PER.stream().filter(p -> !StringUtils.isEmpty(p.getPerPath()) && idSet.contains(p.getFdId()+"")).map(SysPer::getPerPath).collect(Collectors.joining(","));
//                        Set<String> pathSet = Stream.of(hasPath.split(",")).collect(Collectors.toSet());
//                        pathSet.remove("");
//                        pathSet.remove(null);
//                        if (pathSet.size() > 0){
//                            for (String s : pathSet) {
//                                if (path.startsWith(s)){
//                                    filterChain.doFilter(servletRequest,servletResponse);
//                                    flag = false ;
//                                    break;
//                                }
//                            }
//                        }
//                    }
//
//                }
//
//            }
//
//            //测试用
//            //filterChain.doFilter(servletRequest,servletResponse);
//            //test
//            if (flag){
//                servletRequest.getRequestDispatcher("/jump/authority").forward(servletRequest, servletResponse);
//            }
//        } else {
//
//            filterChain.doFilter(servletRequest,servletResponse);
//
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//
//}
