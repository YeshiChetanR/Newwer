package mongo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class CrudOperations {

	
	public static void main(String[] args) {
		Connector connector=new Connector();
		connector.createDatabase("Master33");
		System.out.println("11");
		connector.createCollection("Master33","Slave1");
		connector.createDatabase("Master2");System.out.println("44");
		connector.createCollection("Master2","Slave1");
		System.out.println("22");
		
		
		System.out.println("LastLine");
	}
}





















/*package mongo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class CrudOperations {

	
	public static void main(String[] args) {
		Connector connector=new Connector();
		connector.createDatabase("Master1");
		connector.createCollection("Master1","Slave1");
		
		BasicDBObject basicDBObject=new BasicDBObject("SchoolName","Abc");
		BasicDBObject basicDBObject1=new BasicDBObject("SchoolName","Xyz");
		basicDBObject.append("City","Pune");
		connector.getDBCollection().insert(basicDBObject);
		connector.getDBCollection().insert(basicDBObject1);
		BasicDBObject basicDBObject2=new BasicDBObject();
		basicDBObject2.put("SchoolName","Xyz");
		DBCursor cursor = connector.getDBCollection().find(basicDBObject2);
		while(cursor.hasNext()) {
		    System.out.println(cursor.next());
		}
		String xmlToJsondata=connector.convertXmlFileToJsonFile( "C:\\workspace\\Tester\\Tester\\test-output\\testng-results.xml", "chetanResults.json");
		BasicDBObject basicDBObject4=new BasicDBObject("ResultsJson",xmlToJsondata);
		connector.getDBCollection().insert(basicDBObject4);
		try {
			JSONObject jsonObject=new JSONObject(xmlToJsondata);
			String value=jsonObject.getJSONObject("testng-results").getJSONObject("suite").getString("name");
			System.out.println("value"+value);
			BasicDBObject basicDBObject3=new BasicDBObject("Suite",value);

			connector.getDBCollection().insert(basicDBObject3);
			DBCollection collection=connector.getDBCollection("Colleges");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("LastLine");
	}
}
*/