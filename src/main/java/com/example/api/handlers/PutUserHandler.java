package com.example.api.handlers;

import com.example.api.services.UserService;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.StatusCodes;

public class PutUserHandler {
    public void handleRequest(HttpServerExchange exchange) {
        boolean added = UserService.addUser(exchange.getInputStream());

        if (added) {
            exchange.setStatusCode(StatusCodes.CREATED);
        } else {
            exchange.setStatusCode(StatusCodes.CONFLICT);
        }
    }
}
