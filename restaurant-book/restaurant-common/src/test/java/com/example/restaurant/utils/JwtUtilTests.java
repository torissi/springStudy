package com.example.restaurant.utils;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class JwtUtilTests {

    private static final String SECRET = "12345678901234567890123456789012";

    private JwtUtil jwtUtil ;

    @BeforeEach
    public void setUp() {
        jwtUtil = new JwtUtil(SECRET);
    }

    @Test
    public void createToken() {
        String token = jwtUtil.createToken(1004L, "joohee");

        assertThat(token, containsString("."));
    }

    @Test
    public void getCalims() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJqb29oZWUifQ.Lx34QEtZtn2EBdLgNO5QLUGe17sr_fVjX5c0w59i2aQ";
        Claims claims = jwtUtil.getClaims(token);

        assertThat(claims.get("userId", Long.class)).isEqualTo(1004L);
        assertThat(claims.get("name")).isEqualTo("joohee");
    }
}