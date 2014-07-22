package com.mdp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

 
import android.util.Log;
 
public class RESTClient {
 
    private static String convertStreamToString(InputStream is) {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
 
   
    public static String connectAndReturnResponse(String url)
    {
 
    	String result = "";
    	
        HttpClient httpclient = new DefaultHttpClient();
 
        HttpGet httpget = new HttpGet(url); 
 
        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
            
            Log.i("Android_Store",response.getStatusLine().toString());
 
            HttpEntity entity = response.getEntity();
            
            if (entity != null) {
 
                InputStream instream = entity.getContent();
                result = convertStreamToString(instream);
                Log.i("Android_Store",result);
 
                instream.close();
                
            }
            
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
		return result; 
		
    }
 
}