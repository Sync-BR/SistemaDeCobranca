package com.sistema.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

/**
 *
 * @author sync
 * @classe responsavel por gera token de autorização
 *
 */
public class JwtTokenUtil {

    public final String key = "secreto"; // Chave secreta
// Método para gerar um token JWT a partir de um nome de usuário

    public String generateToken(String username) {
        // Inicia a construção do token JWT
        return Jwts.builder()
                // Define o assunto (subject) do token como o nome de usuário
                .setSubject(username)
                // Define a data de emissão do token como a data atual
                .setIssuedAt(new Date())
                // Define a data de expiração do token para 10 horas a partir do momento atual
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                // Assina o token usando o algoritmo HS256 e uma chave secreta
                .signWith(SignatureAlgorithm.HS256, key)
                // Conclui a construção do token e o compacta em uma string
                .compact();
    }

// Método para expirar um token JWT
    public String expireToken(String token) {
        // Extrai todas as reivindicações (claims) do token
        Claims claims = extractAllClaims(token);
        // Define a data de expiração do token para um momento no passado
        claims.setExpiration(new Date(System.currentTimeMillis() - 1000)); // Define a expiração para o passado
        // Reconstrói o token com as novas reivindicações e o assina novamente
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

// Método para validar um token JWT comparando o nome de usuário e verificando se o token não está expirado
    public boolean validateToken(String token, String username) {
        // Extrai o nome de usuário do token
        String extractedUsername = extractUsername(token);
        // Retorna true se o nome de usuário extraído for igual ao nome de usuário fornecido e o token não estiver expirado
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

// Método para extrair o nome de usuário de um token JWT
    public String extractUsername(String token) {
        // Usa o método extractClaim para obter o assunto (subject) do token
        return extractClaim(token, Claims::getSubject);
    }

// Método para extrair a data de expiração de um token JWT
    public Date extractExpiration(String token) {
        // Usa o método extractClaim para obter a data de expiração do token
        return extractClaim(token, Claims::getExpiration);
    }

// Método genérico para extrair uma reivindicação específica de um token JWT
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        // Extrai todas as reivindicações do token
        final Claims claims = extractAllClaims(token);
        // Aplica o claimsResolver para obter a reivindicação desejada
        return claimsResolver.apply(claims);
    }

// Método privado para extrair todas as reivindicações de um token JWT
    private Claims extractAllClaims(String token) {
        // Analisa o token usando a chave secreta para obter as reivindicações
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

// Método privado para verificar se um token JWT está expirado
    private boolean isTokenExpired(String token) {
        // Verifica se a data de expiração do token é anterior à data atual
        return extractExpiration(token).before(new Date());
    }

    public static void main(String[] args) {
        JwtTokenUtil token = new JwtTokenUtil();
        String tk = token.generateToken("SYNC");
        System.out.println("Token: " + tk);
        
    }
}
