package com.example.api.handlers;

import com.example.api.services.UserService;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.StatusCodes;

public class DeleteUsersHandler {
    public void handleRequest(HttpServerExchange exchange) {
        UserService.deleteAllUsers();
        exchange.setStatusCode(StatusCodes.NO_CONTENT);
    }
}
