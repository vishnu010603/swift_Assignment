package com.example.api.handlers;

import com.example.api.services.UserService;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.StatusCodes;

public class PostUserHandler {
    public void handleRequest(HttpServerExchange exchange) {
        String userId = exchange.getQueryParameters().get("userId").getFirst();
        boolean updated = UserService.updateUser(userId, exchange.getInputStream());

        if (updated) {
            exchange.setStatusCode(StatusCodes.OK);
        } else {
            exchange.setStatusCode(StatusCodes.NOT_FOUND);
        }
    }
}
