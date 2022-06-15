package SMS.schoolmanagementsystem.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.endpoint.NimbusAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] WHITELIST = {
            "/v2/api-docs",
            "/v3/api-docs",
            "/**/v3/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "**/swagger-ui.html",
            "/**/swagger-ui.html**",
            "/swagger-ui.html**",
            "/webjars/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .antMatchers(WHITELIST)
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .authorizationEndpoint()
                .baseUri("/oauth2/authorize-client")
                .authorizationRequestRepository(authorizationRequestRepository())
                .and()
                .tokenEndpoint()
                .accessTokenResponseClient(accessTokenResponseClient())
                .and()
                .defaultSuccessUrl("/login-success")
                .failureUrl("/login-failure");
        http.csrf().disable();
    }

    @Bean
    public AuthorizationRequestRepository<OAuth2AuthorizationRequest>
    authorizationRequestRepository() {
        return new HttpSessionOAuth2AuthorizationRequestRepository();
    }

    @Bean
    public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest>
    accessTokenResponseClient() {

        return new NimbusAuthorizationCodeTokenResponseClient();
    }
}
