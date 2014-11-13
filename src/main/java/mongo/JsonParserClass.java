package mongo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.wink.json4j.utils.XML;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.xml.sax.SAXException;

public class JsonParserClass {

	FileReader fileReader = null;
	String jsonFileContent = null;
	JSONObject jsonObject = null;
	BufferedReader bufferedReader=null;
	@SuppressWarnings("null")
	public static void main(String[] args) {
	

		//
		//fileReader = new FileReader("C:\\Users\\chetan.yeshi\\Downloads\\testng-results.xml");
		JsonParserClass jsonParserClass=new JsonParserClass();
		jsonParserClass.convertXmlFileToJsonFile("C:\\workspace\\Tester\\Tester\\test-output\\testng-results.xml", 
				"C:\\Users\\chetan.yeshi\\Desktop\\testng-results.json");

jsonParserClass.getJsonFileContent("C:\\Users\\chetan.yeshi\\Desktop\\testng-results.json");
	 
	System.out.println("99999"+jsonParserClass.getValue("C:\\Users\\chetan.yeshi\\Desktop\\testng-results.json","suite"));	;
	

	}

	//fileName=C:\\Users\\chetan.yeshi\\Desktop\\testng-results.json
	private String getJsonFileContent(String fileName){
		try {
			fileReader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		bufferedReader = new BufferedReader(fileReader);

		if (bufferedReader != null) {
			try {
				jsonFileContent = bufferedReader.readLine();
				
				//jsonObject = new JSONObject(jsonFileContent);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/*catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		return jsonFileContent;
		
	}
	
	public String getValue(String filename,String key){
		String content=getJsonFileContent(filename);
		try {
			JSONObject jsonObject=new JSONObject(content);
			
			System.out.println("99999988888"+jsonObject.getString((String) jsonObject.keys().next()));;
			String jsString=jsonObject.getString((String) jsonObject.keys().next());
			JSONObject jsonObject2=new JSONObject(jsString);
			
			ArrayList<JSONObject> arrayList=new ArrayList();
			
			Iterator i=jsonObject2.keys();
			while(i.hasNext()){
				
				System.out.println(i.next());
				if(i.next().toString().equalsIgnoreCase(key)){System.out.println("found"+ key);}
				else{
					jsonObject2.get(key);
				}
			}
			
			//System.out.println(jsonObject2);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
		
	}
	
	
	
	
	
	
	
	
	
/*public String getValue(String filename,String key){
	//filename="C:\\Users\\chetan.yeshi\\Desktop\\testng-results.json"
	String content=getJsonFileContent(filename);
	String value = null;
	try {
		JSONObject jsonObject=new JSONObject(content);
			
		ArrayList listOfKeysPresent=new ArrayList();
	
		Iterator iterator=jsonObject.keys();
		while(iterator.hasNext()){
			listOfKeysPresent.add(iterator.next().toString());
			
		}
		
	for( int i=0;i<listOfKeysPresent.size();i++){
		System.out.println("listOfKeysPresent"+listOfKeysPresent);
		if(listOfKeysPresent.get(i).equals(key)){
			System.out.println("key found");
			value=jsonObject.getString(key);
			System.out.println("Value for key is"+jsonObject.get(key));
			
			
			}
		else{
			System.out.println("key not found23");
			organise(jsonObject);
			for (int j = 0; j < jsonobjectList.size(); j++) {
				if(jsonobjectList.get(j).equals(key)){
					System.out.println("key found in jsonobjectList");
					value=jsonObject.getString(key);
					System.out.println("Value for key is"+jsonObject.get(key));
					
					}
				else if(jsonArrayList.get(j).equals(key)){
					System.out.println("key found in jsonArrayList");
					value=jsonObject.getString(key);
					System.out.println("Value for key is"+jsonObject.get(key));
					
					}
				else{
					System.out.println("key not found");
					JSONObject jsonObject2=jsonObject.getJSONObject(key);
					organise(jsonObject2);
					
					}
				
			}
			}
	}
		
		
		
		
		
		
		
		
	} catch (JSONException e) {
		System.out.println("key not found");
		//e.printStackTrace();
	}
	
	
	return value;
}*/




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	ArrayList jsonobjectList=new ArrayList();
	ArrayList jsonArrayList=new ArrayList();
	private void organise(JSONObject object) {
		System.out.println("In Organise");
		
	if(object instanceof JSONObject){
		
		System.out.println("Is object "+object);
		
		System.out.println("jsonobjectList::::::"+jsonobjectList);
		jsonobjectList.add(object);
	}else{
		jsonArrayList.add(object);
		System.out.println("Is array");
	}
	
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


