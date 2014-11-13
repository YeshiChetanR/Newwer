package mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class sss {
	static Connector connector=new Connector();
	public static void main(String[] args) {
		MongoClient client=connector.getClient();
		connector.createDatabase("First123");
		DB db=connector.getDatabase("First123");
		System.out.println("db"+db);
		connector.createCollection("First123", "Collection123");
		DBCollection dbCollection=connector.getDBCollection("First123", "Collection123");
		System.out.println("dbCollection"+dbCollection);
		BasicDBObject dbobject= new BasicDBObject("userId","user1");
		System.out.println(dbobject);
			dbCollection.insert(dbobject);
		//DB db=connector.getDatabase("First1");
		System.out.println(client.getDatabaseNames());


	




	}

}
