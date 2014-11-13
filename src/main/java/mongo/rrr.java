package mongo;

import java.util.HashMap;

public class rrr {
	public static void main(String[] args) {
		HashMap hashMap=new HashMap();
		HashMap hashMap1=new HashMap();
		hashMap1.put(1,"AA");
		hashMap1.put(2,"BB");
		hashMap.put(9,hashMap1);
		HashMap hashMap2=(HashMap) hashMap.get(9);
		System.out.println(hashMap2.get(1));
		
	}

}
