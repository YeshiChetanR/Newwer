package mongo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.wink.json4j.utils.XML;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.xml.sax.SAXException;

public class UsingSimpleJson {


	@SuppressWarnings("null")
	public static void main(String[] args) {
		FileReader fileReader = null;
		String string = null;
		org.json.simple.JSONObject jsonObject = null;
		BufferedReader bufferedReader=null;
		try {
			//
			//fileReader = new FileReader("C:\\Users\\chetan.yeshi\\Downloads\\testng-results.xml");
			UsingSimpleJson jsonParserClass=new UsingSimpleJson();
			jsonParserClass.convertXmlFileToJsonFile("C:\\workspace\\Tester\\Tester\\test-output\\testng-results.xml", 
					"C:\\Users\\chetan.yeshi\\Desktop\\testng-results.json");


			fileReader = new FileReader("C:\\Users\\chetan.yeshi\\Desktop\\testng-results.json");


			bufferedReader = new BufferedReader(fileReader);

			if (bufferedReader != null) {


				string = bufferedReader.readLine();


				jsonObject = new org.json.simple.JSONObject();
				jsonObject.


			} 

			System.out.println(">>>>" + string);
			System.out.println("9999");
			ArrayList<String> arrayList=null;
			System.out.println("9999888");
			if(jsonObject.keys().hasNext()){
				String keyName=(String) jsonObject.keys().next();
				System.out.println("keyname"+keyName);

				arrayList=new ArrayList<String>();
				arrayList.add(keyName);//inserting keys in list
				System.out.println("666"+arrayList);
				for(String s:arrayList){
					JSONObject jsonObject2=jsonObject.getJSONObject(s);
					
					if(jsonObject2 instanceof JSONObject){
						System.out.println("is object");

						ArrayList<String> a=new ArrayList<String>();
					

						System.out.println("aaaaaaaaa"+a);

					}
					else {
						System.out.println("is array");
					}
				}

				System.out.println("jsonObject.keys()"+jsonObject.getJSONObject(keyName));

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



	public void convertXmlFileToJsonFile(String xmlFilename,String jsonFileName){

		File xmlFile;
		//String jsonFileData = null;

		xmlFile=new File(xmlFilename);
		FileInputStream fileInputStream = null;

		String jsonObject1 = null;
		try {
			fileInputStream = new FileInputStream(xmlFile);
			jsonObject1 = XML.toJson(fileInputStream);

			//	System.out.println("88"+jsonObject1);
			//jsonFileData=jsonObject1;
			//System.out.println("97777"+jsonFileData);

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
		//return jsonFileData;

	}






}



