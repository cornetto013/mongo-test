package org.example;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.Collection;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Replace with your actual MongoDB connection string
        String connectionString = "mongodb+srv://sanghvi:qazwsxedcrfv@cluster0.h1acy6w.mongodb.net/";

        // Create a connection string
        ConnectionString connString = new ConnectionString(connectionString);

        // Create settings for the MongoDB client
        MongoClientSettings settings = MongoClientSettings.builder()
                                                          .applyConnectionString(connString)
                                                          .build();

        // Create a MongoDB client
        MongoClient mongoClient = MongoClients.create(settings);

        // Connect to the "testdb" database
        String databaseName = "sample_analytics";
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection("accounts");

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println(document.toJson());
                /*Integer name = document.getInteger("roll");
                System.out.println("Name: " + name);*/
            }
        }

        // ------------------------XXXXXXXXXXXXXX-------------------
        // Define the field name and the value to search for
        /*String fieldName = "location";
        String searchValue = "Bangalore";*/

        // Build the filter to find documents with the specified field value
        //Document filter = new Document(fieldName, searchValue);

        // Perform the search by passing the filter to the find method

        /*try (MongoCursor<Document> cursor = collection.find(filter).iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                document.remove("_id");
                System.out.println(document.toJson());
            }
        }*/

        // ------------------------XXXXXXXXXXXXXX-------------------


        /*String fieldName = "name";
        String searchValue = "Aarushi";
        Document filter = new Document(fieldName, searchValue);
        System.out.println(collection.find(filter).iterator().next().toJson());


        // Define the update operation to remove the "role" field
        //Document updateDocument = new Document("$unset", new Document("location", ""));

        // Perform the update on the first matching document found
        //collection.updateOne(filter, updateDocument);
        System.out.println(collection.find(filter).iterator().next().toJson());*/



        // Make sure to close the cursor when done to free resources


        // Close the connection to the MongoDB server
        mongoClient.close();
    }
}