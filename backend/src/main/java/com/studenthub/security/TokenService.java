package com.studenthub.security;

import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenService {
    private final ConcurrentHashMap<String, String> sessions = new ConcurrentHashMap<>();
    public String issue(String email, String role) { String token=UUID.randomUUID().toString(); sessions.put(token,email+"|"+role); return token; }
    public String identity(String token) { return sessions.get(token); }
    public void revoke(String token) { sessions.remove(token); }
}
