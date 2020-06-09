package com.github.cantos.gateway.security;

import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class ServerJsonLoginAuthenticationConverter implements ServerAuthenticationConverter,
        Function<ServerWebExchange, Mono<Authentication>> {
    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        return apply(exchange);
    }

    private String usernameParameter = "username";
    private String passwordParameter = "password";

    @Override
    public Mono<Authentication> apply(ServerWebExchange exchange) {
        return ServerWebExchangeUtils.cacheRequestBody(exchange, this::createAuthentication);
    }

    private Mono<Authentication> createAuthentication(org.springframework.http.server.reactive.ServerHttpRequest serverHttpRequest) {
//        serverHttpRequest.getBody()
//        return new UsernamePasswordAuthenticationToken("", "");
        return Mono.empty();
    }

    /**
     * The parameter name of the form data to extract the username
     *
     * @param usernameParameter the username HTTP parameter
     */
    public void setUsernameParameter(String usernameParameter) {
        Assert.notNull(usernameParameter, "usernameParameter cannot be null");
        this.usernameParameter = usernameParameter;
    }

    /**
     * The parameter name of the form data to extract the password
     *
     * @param passwordParameter the password HTTP parameter
     */
    public void setPasswordParameter(String passwordParameter) {
        Assert.notNull(passwordParameter, "passwordParameter cannot be null");
        this.passwordParameter = passwordParameter;
    }
}