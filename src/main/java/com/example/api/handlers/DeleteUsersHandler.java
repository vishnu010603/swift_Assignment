package com.example.api;

import com.example.api.services.UserService;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.StatusCodes;

public class DeleteUserByIdHandler {
    public void handleRequest(HttpServerExchange exchange) {
        String userId = exchange.getQueryParameters().get("userId").getFirst();
        boolean deleted = UserService.deleteUserById(userId);

        if (deleted) {
            exchange.setStatusCode(StatusCodes.NO_CONTENT);
        } else {
            exchange.setStatusCode(StatusCodes.NOT_FOUND);
        }
    }
}
