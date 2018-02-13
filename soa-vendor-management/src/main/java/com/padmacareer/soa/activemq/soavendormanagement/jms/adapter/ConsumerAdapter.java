package com.padmacareer.soa.activemq.soavendormanagement.jms.adapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

//@Component
public class ConsumerAdapter {
	private static Logger logger = LogManager.getLogger(ConsumerAdapter.class);

	public void sendToMongo(String json) {
		logger.info("Sending to MongoDB");
		// MongoClient client = new MongoClient("localhost", 27017);
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("vendor");
		MongoCollection<Document> collection = db.getCollection("contact");
		logger.info("converting json to DBObject");
		Document dbObject = Document.parse(json);
		collection.insertOne(dbObject);
		logger.info("sent to MongoDB");

	}

}
