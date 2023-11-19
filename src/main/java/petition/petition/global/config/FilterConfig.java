package petition.petition.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import petition.petition.global.error.GlobalExceptionFilter;
import petition.petition.global.security.jwt.JwtReissueUtil;
import petition.petition.global.security.jwt.JwtTokenFilter;
import petition.petition.global.security.jwt.JwtTokenProvider;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;
    private final JwtReissueUtil jwtReissueUtil;

    @Override
    public void configure(HttpSecurity http) {

        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider, jwtReissueUtil);
        GlobalExceptionFilter globalExceptionFilter = new GlobalExceptionFilter(objectMapper);

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(globalExceptionFilter, JwtTokenFilter.class);
    }

}
