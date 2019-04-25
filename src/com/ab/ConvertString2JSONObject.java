package com.gslab.ab;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConvertString2JSONObject {
	public static void main(String[] args) throws JSONException {
      
        String data = "[{\"userName\": \"sandeep\",\"age\":30}]";
		JSONArray jsonArr = new JSONArray(data);

        for (int i = 0; i < jsonArr.length(); i++)
        {
            JSONObject jsonObj = jsonArr.getJSONObject(i);

            System.out.println(jsonObj.get("userName")); // sandeep
        }
	}
}
