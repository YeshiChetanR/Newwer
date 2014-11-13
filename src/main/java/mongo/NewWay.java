package mongo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.wink.json4j.utils.XML;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.xml.sax.SAXException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class NewWay {
	FileReader fileReader=null;	

	public static void main(String[] args) {

		NewWay newWay=new NewWay();
		newWay.convertXmlFileToJsonFile("C:\\workspace\\Tester\\Tester\\test-output\\testng-results.xml", 
				"C:\\Users\\chetan.yeshi\\Desktop\\testng-results.json");
		try {
			System.out.println(newWay.getValue("C:\\Users\\chetan.yeshi\\Desktop\\testng-results.json","suite"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}


	private String getJsonFileContent(String fileName){

		try {
			fileReader = new FileReader(fileName);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		String jsonFileContent = null;
		if (bufferedReader != null) {
			try {
				jsonFileContent = bufferedReader.readLine();
				JSONObject jsonObject = new JSONObject(jsonFileContent);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jsonFileContent;

	}
	//"C:\\Users\\chetan.yeshi\\Downloads\\testng-results.json"
	public void insertFileIntoDb( String fileName){
		try {
			MongoClient client=new MongoClient("localhost",27017);
			DB db=client.getDB("Testss");
			DBCollection collection=db.getCollection("User");
			
			
			//collection.insert(new BasicDBObject("_id","Chetan").append("address",fis));
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public String  getValue(String fileName,String key) throws JSONException{
		
		String content=getJsonFileContent(fileName);
		System.out.println("content"+content);
		
		JSONObject  jsonObject=new JSONObject(content);
		System.out.println("jsonObject.opt"+jsonObject.getJSONObject("testng-results").getString("skipped"));;
		String res=jsonObject.getJSONObject("testng-results").getJSONObject("suite").getJSONObject("test").getString("name");
System.out.println("vvsdvs"+res);
		try {
			System.out.println("ddsd");
			JSONObject jsonObjectContainingWholeFileContent=new JSONObject(content);
			Iterator iteratorOverWholeContent=jsonObjectContainingWholeFileContent.keys();
			ArrayList arrayList=new  ArrayList();

			while (iteratorOverWholeContent.hasNext()){
				arrayList.add(iteratorOverWholeContent.next());

			}

			System.out.println("arrayList"+arrayList);




		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}
	public void convertXmlFileToJsonFile(String xmlFilename,String jsonFileName){

		File xmlFile;
		xmlFile=new File(xmlFilename);
		FileInputStream fileInputStream = null;

		String jsonObject1 = null;
		try {
			fileInputStream = new FileInputStream(xmlFile);
			jsonObject1 = XML.toJson(fileInputStream);
			FileWriter fileWriter = null;
			fileWriter = new FileWriter(jsonFileName);
			fileWriter.write(jsonObject1);
			fileWriter.flush();
			fileWriter.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}catch (IOException e) {

			e.printStackTrace();
		}catch (SAXException e) {
			e.printStackTrace();
		} 


	}
}
