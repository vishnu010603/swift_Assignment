package com.example.api.;

import com.example.api.services.UserService;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.StatusCodes;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class LoadUsersHandler {
    public void handleRequest(HttpServerExchange exchange) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() == 200) {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder jsonResponse = new StringBuilder();
                while (scanner.hasNext()) {
                    jsonResponse.append(scanner.nextLine());
                }
                scanner.close();
                UserService.loadUsersToDB(jsonResponse.toString());
            }
            exchange.setStatusCode(StatusCodes.OK);
        } catch (IOException e) {
            exchange.setStatusCode(StatusCodes.INTERNAL_SERVER_ERROR);
        }
    }
}
