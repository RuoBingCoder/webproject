package com.springboot.bootcrudpage.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : 石建雷
 * @date :2019/4/10
 */

public class HttpRequestServletUtil {

    public static int getInt(HttpServletRequest request, String key) {

        try {

            return Integer.decode(request.getParameter(key));
        } catch (Exception e) {
            return -1;
        }

    }

    public static Long getLong(HttpServletRequest request, String key) {

        try {

            return Long.decode(request.getParameter(key));
        } catch (Exception e) {
            return -1L;
        }

    }

    public static Double getDouble(HttpServletRequest request, String key) {

        try {

            return Double.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1d;
        }

    }

    public static String getString(HttpServletRequest request, String key) {

        try {
            String result = new String(request.getParameter(key).getBytes("ISO-8859-1"), "UTF-8");
            if (result != null) {
//               去除首尾空格
                result.trim();
            }
            if ("".equals(result)) {
                result = null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }

    }

    public static String getFormDataString(HttpServletRequest request, String key) {

        try {
            String result = request.getParameter(key);
            if (result != null) {
//               去除首尾空格
                result.trim();
            }
            if ("".equals(result)) {
                result = null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean getBoolean(HttpServletRequest request, String key) {

        try {

            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return false;
        }

    }
}
