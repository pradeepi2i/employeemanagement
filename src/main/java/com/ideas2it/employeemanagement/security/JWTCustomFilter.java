package com.ideas2it.employeemanagement.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import com.ideas2it.employeemanagement.service.EmployeeService;
import com.ideas2it.employeemanagement.service.impl.EmployeeServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTCustomFilter extends OncePerRequestFilter {

    private static Logger logger = LoggerConfiguration
                .getInstance("JWTCustomFilter.class");
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        logger.info("In doFilterInternal()");
        String jwtToken = null;
        String userId = null;

        if (null != header && header.startsWith("Bearer")) {
            logger.info("In doFilterInternal() ");
            jwtToken = header.substring(6);
            userId = jwtUtil.extractUserId(jwtToken);
        }

        if (null != userId && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.employeeServiceImpl.loadUserByUsername(userId);

            if (jwtUtil.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource()
                        .buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                filterChain.doFilter(request,response);
            }
        } else {
            request.getRequestDispatcher("/").forward(request, response);
        }


    }
}
