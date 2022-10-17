package com.ideas2it.employeemanagement.security;

import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import com.ideas2it.employeemanagement.service.impl.EmployeeServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTCustomFilter extends OncePerRequestFilter {

    private static Logger logger = LoggerConfiguration
                .getInstance("JWTCustomFilter.class");

    private EmployeeServiceImpl employeeServiceImpl;
    private JWTUtil jwtUtil;

    public JWTCustomFilter(EmployeeServiceImpl employeeServiceImpl, JWTUtil jwtUtil) {
        this.employeeServiceImpl = employeeServiceImpl;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header = (String) request.getSession().getAttribute("Authorization");
        logger.info("In doFilterInternal()");
        String jwtToken = null;
        String userId = null;
        logger.info("Header in request " + header);

        if (null != header && header.startsWith("Bearer")) {
            logger.info("In doFilterInternal() header != null " + header);
            jwtToken = header.substring(6);
            userId = jwtUtil.extractUserId(jwtToken);
            logger.info(userId);
        }

        if (null != userId && null == SecurityContextHolder.getContext().getAuthentication()) {
            UserDetails userDetails = this.employeeServiceImpl.loadUserByUsername(userId);
            logger.info("In doFilterInternal() userDetails = " + userDetails);

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
            logger.info("If statement fails " + header);
            request.getRequestDispatcher("login").forward(request, response);
        }
    }
}
