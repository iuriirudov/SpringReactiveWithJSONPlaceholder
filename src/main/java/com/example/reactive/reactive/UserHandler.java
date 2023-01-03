package com.example.reactive.reactive;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.reactive.reactive.ReactiveApplication.REMOTE_API_URL;

@Component
public class UserHandler {
    WebClient client = WebClient.create(REMOTE_API_URL);
    public Mono<ServerResponse> getUser(ServerRequest request) {
        Mono<User> user = client.get()
                .uri("/users/{id}", request.pathVariables())
                .retrieve()
                .bodyToMono(User.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(user, User.class);
    }

    public Mono<ServerResponse> getUsers(ServerRequest request) {
        Flux<User> users = client.get()
                .uri("/users")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users, User.class);
    }
//
//    public Mono<ServerResponse> createUser(ServerRequest request) {
//        return null;
//    }
}
