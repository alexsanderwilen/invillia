package com.invillia.acme.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private JWTUtil jwtUtil;

    private UserDetailsService userDetailsService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserDetailsService userDetailsService) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request, header.substring(7));
            if (authenticationToken != null) {
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, String token) {

        if (jwtUtil.tokenValido(token)) {
            String username = jwtUtil.getUsername(token);
            UserDetails user = userDetailsService.loadUserByUsername(username);
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }

        return null;
    }
}
