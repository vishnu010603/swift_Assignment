package com.example.api;

import com.example.api.services.UserService;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.util.StatusCodes;

public class GetUserByIdHandler {
    public void handleRequest(HttpServerExchange exchange) {
        String userId = exchange.getQueryParameters().get("userId").getFirst();
        String response = UserService.getUserById(userId);

        if (response != null) {
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
            exchange.setStatusCode(StatusCodes.OK);
            exchange.getResponseSender().send(response);
        } else {
            exchange.setStatusCode(StatusCodes.NOT_FOUND);
        }
    }
}
