package ma.khaoulabaadi.jeeexam.security;

import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    // Mettez cette clé dans application.properties en prod
    private final String SECRET = "votrenom-khaoulabaadi-secret-key-256bits-minimum";
    private final long EXPIRATION = 1000 * 60 * 60 * 24; // 24h

    private SecretKey secretKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claim("roles", userDetails.getAuthorities()
                        .stream().map(GrantedAuthority::getAuthority)
                        .collect(
                                Collectors.toList()))
                .issuedAt(new
                        Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secretKey())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().verifyWith(secretKey()).build()
                .parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser().verifyWith(secretKey()).build()
                .parseSignedClaims(token).getPayload()
                .getExpiration().before(new Date());
    }
}