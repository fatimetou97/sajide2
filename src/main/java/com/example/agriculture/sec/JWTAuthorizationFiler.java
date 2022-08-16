package com.example.agriculture.sec;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JWTAuthorizationFiler extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/refreshToken")){
            filterChain.doFilter(request,response);
        }else{


            String authorizationToken=request.getHeader(SecurityParams.JWT_HEADER_NAME);
            if(authorizationToken!=null&& authorizationToken.startsWith(SecurityParams.HEADER_PREFIX))
            {
                try{ String jwt=authorizationToken.substring(SecurityParams.HEADER_PREFIX.length());
                    Algorithm algo=Algorithm.HMAC256(SecurityParams.SECRET);
                    JWTVerifier jwtVerifier= JWT.require(algo).build();
                    DecodedJWT decodedJWT= jwtVerifier.verify(jwt);
                    String username=decodedJWT.getSubject();
                    String[] roles=decodedJWT.getClaim("roles").asArray(String.class);
                    Collection<GrantedAuthority> authorities=new ArrayList<>();
                    for(String r:roles){
                        authorities.add(new SimpleGrantedAuthority(r));
                    }
                    UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,null,authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request,response);

                }catch (Exception e){
                    response.setHeader("error_message",e.getMessage());
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                }

            }else{
                filterChain.doFilter(request,response);

            }}


    }
}