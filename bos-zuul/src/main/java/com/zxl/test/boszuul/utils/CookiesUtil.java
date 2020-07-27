package com.zxl.test.boszuul.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <p></p >
 *
 * @author zxl
 * @email xiaoliang.zhang@payby.com
 * @date CookiesUtil.java v1.0  2020/7/27 12:32 PM
 */
public class CookiesUtil {

    public static final String COOKIE_TICKET_NAME = "TEST_TEST";

    /**
     * 添加Cookie对象
     *
     * @param response
     *            请求
     * @param name
     *            名称
     * @param value
     *            内容
     * @param path
     *            路径
     * @param expiry
     *            有效时间(秒)
     * @return
     */
    public static boolean setCookie(HttpServletResponse response, String name, String value, String domain, String path, int expiry) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(domain);
        cookie.setMaxAge(expiry);// Cookie有效时间(秒)：-1关闭浏览器失效，0立即失效，大于1为具体时间
        cookie.setPath(path);
        response.addCookie(cookie);

        return false;
    }

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name
     *            名称
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 移除客户端Cookie对象
     *
     * @param request
     *            请求
     * @param response
     *            响应
     * @param name
     *            名称
     * @param path
     *            路径
     * @return
     */
    public static boolean removeCookie(HttpServletRequest request, HttpServletResponse response,String domain, String name,
                                       String path) {
        // -- 清除客户端Cookie
        try {
            Cookie cookie = CookiesUtil.getCookieByName(request, name);
            if (cookie != null) {
                cookie.setMaxAge(0);
                cookie.setDomain(domain);
                cookie.setPath(path);
                cookie.setValue(null);
                response.addCookie(cookie);
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
