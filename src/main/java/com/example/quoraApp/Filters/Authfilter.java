package com.example.quoraApp.Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
@Slf4j
@Component
public class Authfilter implements Filter{

    RestTemplate template =new RestTemplate();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String resourceURL= "http://localhost:8080/auth/validate";
        String token=null;
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request,response);
        }else {
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals("Jwttoken")) {
                        token = cookie.getValue();
                    }
                }
                HttpHeaders headers = new HttpHeaders();
                headers.set("Jwttoken", token);
                System.out.println(token + " doooooo");
                HttpEntity<String> entity = new HttpEntity<String>(headers);
                try {
                    ResponseEntity<String> response1 = template.exchange(resourceURL, HttpMethod.GET, entity, String.class);
                    if (response1.getStatusCode().is2xxSuccessful()) {
                        log.info("Inside filter of quora app!!, success remote call");
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                } catch (RestClientException e) {
                    log.info("Failed remote call to auth service ");
//                HttpServletResponse response = (HttpServletResponse) servletResponse;
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"message\": \"incorrect credentials\"}");
                }
            } else {
                log.info("Failed remote call !! No token found ");
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"message\": \"incorrect credentials\"}");

            }
        }

    }
}
