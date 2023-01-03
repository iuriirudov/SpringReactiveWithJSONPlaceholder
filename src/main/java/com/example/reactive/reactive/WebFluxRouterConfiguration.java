package com.example.reactive.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class WebFluxRouterConfiguration {
    private final UserHandler userHandler;

    public WebFluxRouterConfiguration(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Bean
    RouterFunction<ServerResponse> serverRoutes() {
        return RouterFunctions.route()
                .GET("/users/{id}", accept(APPLICATION_JSON), userHandler::getUser)
                .GET("/users", accept(APPLICATION_JSON), userHandler::getUsers)
//                .POST("/users", userHandler::createUser)
                .build();
    }

//    @Bean
//    RouterFunction<ServerResponse> routes() {
//        return RouterFunctions.route()
//                .path("/users", b1 -> b1
//                        .nest(accept(APPLICATION_JSON), b2 -> b2
//                                .GET("/{id}", userHandler::getUser)
//                                .GET(userHandler::getUsers))
//                        .POST(userHandler::createUser))
//                .build();
//    }
}
