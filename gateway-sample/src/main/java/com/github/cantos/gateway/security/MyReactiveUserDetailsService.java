package com.github.cantos.gateway.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Collections;

@Component
public class MyReactiveUserDetailsService implements ReactiveUserDetailsService {
    @Resource
    private WebClient webClient;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.just(new User(username, "{noop}password", Collections.singleton(new SimpleGrantedAuthority("ADMIN"))));
    }

}
