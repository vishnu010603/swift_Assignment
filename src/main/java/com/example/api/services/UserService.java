package com.example.api.services;
import com.example.api.utils.MongoClientProvider;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class UserService {
    private static final MongoDatabase db = MongoClientProvider.getDatabase();
    private static final MongoCollection<Document> userCollection = db.getCollection("users");
    public static boolean loadUsersFromAPI() {
        return true;
    }
    public static String getUserById(String userId) {
        Document user = userCollection.find(new Document("_id", userId)).first();
        return user != null ? user.toJson() : null;
    }
    public static boolean deleteUserById(String userId) {
        return userCollection.deleteOne(new Document("_id", userId)).wasAcknowledged();
    }
}
