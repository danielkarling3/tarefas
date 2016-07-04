/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpr.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author danielkarling
 */
public class autorizadorInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controler) throws IOException {

        String uri = request.getRequestURI();

        if ((uri.endsWith("loginForm")) || (uri.endsWith("resources")) || (uri.endsWith("efetuaLogin"))){

            return true;
        }
        if (request.getSession().getAttribute("logado") != null) {
            return true;
        }
        response.sendRedirect("loginForm");
        return false;

    }
}
