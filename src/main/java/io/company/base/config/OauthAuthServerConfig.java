package io.company.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableAuthorizationServer
public class OauthAuthServerConfig extends AuthorizationServerConfigurerAdapter {

    private final String JWT_TOKEN_KEY = "N3!d$FWnm39dfjkdfd-PO12$fCvff##i09!-fhj38A#nf832!QASfdF^DFffhd78&%";
    private final AuthenticationManager authenticationManager;

    public OauthAuthServerConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(JWT_TOKEN_KEY);
        return jwtAccessTokenConverter;
    }


    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }


    // Client 에 대한 정보를 설정
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("id").secret("$2a$10$3Uwd8ey8uGUwq/WvSBbJWOk7QPagmJP8I75/J0UOhr3ZRhSYwcZLy"/*1234*/)
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                .scopes("all");
    }


    // OAuth2 서버가 작동하기 위한 Endpoint에 대한 정보를 설정
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
                .authenticationManager(authenticationManager);
    }


    // Oauth2 서버 자체의 보안설정
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {

    }
}
