package mongo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import org.xml.sax.SAXException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Connector {
	DB db=null;
	DBCollection collection=null;
	HashMap<String,HashMap<String,DBCollection>> databaseHashMap=new HashMap<String,HashMap<String,DBCollection>>();
	HashMap<String,DBCollection> collectionHashMap=new HashMap<String,DBCollection>();
	public static void main(String args[])
	{

	}

	public MongoClient getClient(){
		MongoClient client = null;
		try {
			client = new MongoClient("localhost",27017);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}
	HashMap<String ,DB >arr=new HashMap<String ,DB >();
	
	public void createDatabase(String databaseName){
		DB d=getClient().getDB(databaseName);
		System.out.println("db created");
		arr.put(databaseName, d);
		
		System.out.println("databaseHashMap"+databaseHashMap);
		

	}
	public DB getDatabase(String databaseName) {
		return arr.get(databaseName);
	}

	
	public void createCollection(String databaseName,String collectionName){
		DBCollection dbCollection= getClient().getDB(databaseName).getCollection(collectionName);

		collectionHashMap.put(collectionName, dbCollection);
		databaseHashMap.put(databaseName,collectionHashMap);
		System.out.println("databaseHashMap"+databaseHashMap);
		
		
			}
	public DBCollection getDBCollection(String databaseName,String collectionName) {
		collectionHashMap.get(collectionName);
		System.out.println("99999999"+collectionHashMap);
		System.out.println("collectionHashMap.get(collectionName)"+ databaseHashMap.get(databaseName));
		
		return databaseHashMap.get(databaseName).get(collectionName);
	}
	
public String convertXmlFileToJsonFile(String xmlFilename,String jsonFileName){

	File xmlFile;String jsonFileData = null;
	
	xmlFile=new File(xmlFilename);
	FileInputStream fileInputStream = null;

	String jsonObject1 = null;
	try {
		fileInputStream = new FileInputStream(xmlFile);
		jsonObject1 = org.apache.wink.json4j.utils.XML.toJson(fileInputStream);

	//	System.out.println("88"+jsonObject1);
		jsonFileData=jsonObject1;
		//System.out.println("97777"+jsonFileData);

		FileWriter fileWriter = null;
		fileWriter = new FileWriter(jsonFileName);
		
		fileWriter.write(jsonFileData);
		fileWriter.flush();
		fileWriter.close();
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	}catch (IOException e) {

		e.printStackTrace();
	}catch (SAXException e) {
		e.printStackTrace();
	} 
	return jsonFileData;

}
	
}
