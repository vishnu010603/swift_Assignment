package com.example.api.utils;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoClientProvider {
    private static final String DB_NAME = "usersDB";
    private static MongoClient client = MongoClients.create("mongodb://localhost:27017");

    public static MongoDatabase getDatabase() {
        return client.getDatabase(DB_NAME);
    }
}
