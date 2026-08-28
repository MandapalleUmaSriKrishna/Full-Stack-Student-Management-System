package com.studenthub.security;

import jakarta.servlet.*; import jakarta.servlet.http.*; import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; import org.springframework.security.core.authority.SimpleGrantedAuthority; import org.springframework.security.core.context.SecurityContextHolder; import org.springframework.web.filter.OncePerRequestFilter; import java.io.IOException; import java.util.List;
public class TokenFilter extends OncePerRequestFilter {
    private final TokenService tokens; public TokenFilter(TokenService tokens){this.tokens=tokens;}
    protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain)throws ServletException,IOException { String h=req.getHeader("Authorization"); if(h!=null&&h.startsWith("Bearer ")){String identity=tokens.identity(h.substring(7)); if(identity!=null){String[] p=identity.split("\\|",2); SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(p[0],null,List.of(new SimpleGrantedAuthority("ROLE_"+p[1]))));}} chain.doFilter(req,res); }
}
