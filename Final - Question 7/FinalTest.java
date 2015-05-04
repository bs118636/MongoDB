package com.mongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class FinalTest 
{
	public static void main(String[] args) 
	{
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("final7");
		MongoCollection<Document> collection = database.getCollection("albums");
		MongoCollection<Document> imageColl = database.getCollection("images");
		
		for(int i=0; i<100000; i++)
		{
			//collection.find(new Document("images", new Document("$in", "["+i+"]")))
			//if(collection.count(new Document("images", new Document("$nin", Arrays.asList(i)))) == 1000)
			if(collection.count(new Document("images", new Document("$in", Arrays.asList(i)))) == 0)
			{
				imageColl.deleteOne(new Document("_id", i));
				System.out.println("Image " + i + ": Deleted!");
			}
			
		}
		
		
		
	}
}
