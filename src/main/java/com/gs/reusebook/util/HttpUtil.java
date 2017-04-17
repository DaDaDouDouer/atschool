package com.gs.reusebook.util;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
public class HttpUtil {
	public static String doGet(String url, long timeout) throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
            HttpGet httpget = new HttpGet(url);

            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            	
				public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
				}
  
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            return responseBody;
        } finally {
            httpclient.close();
        }
	}
	public static String doPost(String url,long timeout){
		return "";
	}
}
