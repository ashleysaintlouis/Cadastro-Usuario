package io.github.ashleysaintlouis.apicadastrousuario.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class TokenService {

    private static final String CHAVE_SECRETA = "eee6245c8010e191d18839384aaa811197d9a3184941a8d73f8b73688921496e";
    private Key chaveAssinatura;

    @PostConstruct
    public void init() {
        this.chaveAssinatura = Keys.hmacShaKeyFor(CHAVE_SECRETA.getBytes());
    }

    public String gerarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia
                .signWith(chaveAssinatura, SignatureAlgorithm.HS512)
                .compact();
    }

    public String validarToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(chaveAssinatura)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
