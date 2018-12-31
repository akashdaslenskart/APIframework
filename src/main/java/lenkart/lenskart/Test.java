package lenkart.lenskart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Test {

	
	public static void main(String args[]) throws ClientProtocolException, IOException, ParseException {
		Test test=new Test();
		//test.firstpostrequest();
		//test.firstpostrequestusingjson();
		//test.firstpostusingjsonobject();
		test.firstpostusingjsonrequestheader();
	}
	
	public void firtsample() throws ClientProtocolException, IOException {
		
		HttpClient client = HttpClientBuilder.create().build();    
	    HttpResponse response = client.execute(new HttpGet("http://www.vogella.com"));
	    int statusCode = response.getStatusLine().getStatusCode();
	    
	    if(statusCode==200) {
	    	System.out.println("YES");
	    }
	    
	    else {
	    	System.out.println("NO");
	    }
		
		
		/*HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://www.vogella.com");
		HttpResponse response = client.execute(request);

		// Get the response
		BufferedReader rd = new BufferedReader
		    (new InputStreamReader(
		    response.getEntity().getContent()));

		
		String line = "";
		while ((line = rd.readLine()) != null) {
			StringBuilder textView= new StringBuilder("l");
		    textView.append(line);
		    System.out.println(textView+">>");
		}*/
		
		
		
		}
	
	
	 public void firstpostrequest() throws ClientProtocolException, IOException {
		 
		 HttpClient hp=HttpClientBuilder.create().build();
		 HttpPost client=new HttpPost("http://vogellac2dm.appspot.com/register");
		 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
         nameValuePairs.add(new BasicNameValuePair("Email", "youremail"));
		 client.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		 HttpResponse response = hp.execute(client);
		System.out.println(response.getEntity().getContent()+"<<");

	 }
	 
	 public void firstpostrequestusingjson() throws ClientProtocolException, IOException{
		 HttpClient client=HttpClientBuilder.create().build();
		 HttpPost post=new HttpPost("http://vogellac2dm.appspot.com/register");
		 String json="{\n" + 
		 		"  \"storeInventory\": 2\n" + 
		 		"  }";
		 
		 StringEntity entity=new StringEntity(json);
		 post.setEntity(entity);
		 HttpResponse response=client.execute(post);
		 System.out.println(response.getEntity().getContent());
		 System.out.println(response.getStatusLine().getStatusCode());
		 
		 
		 
	 }
	 
	 public void firstpostusingjsonobject() throws ClientProtocolException, IOException, ParseException{
	 
		 JSONParser parser=new JSONParser();
		 Object obj=parser.parse(new FileReader("/Users/prasanjit/Desktop/Hackerrank/lenskart/src/main/java/lenkart/lenskart/payload.json"));
		 JSONObject jsonobj=(JSONObject)obj;
		 HttpClient client=HttpClientBuilder.create().build();
		 HttpPost post=new HttpPost("http://vogellac2dm.appspot.com/register");
		 StringEntity entity=new StringEntity(jsonobj.toString());
		 post.setEntity(entity);
		 HttpResponse response=client.execute(post);
		 System.out.println(response.getStatusLine().getStatusCode());
		 System.out.println(response.getEntity().getContent());

	 }
	 
	 
	 public void firstpostusingjsonrequestheader() throws ClientProtocolException, IOException, ParseException{
		 HttpClient client=HttpClientBuilder.create().build();
		 HttpPost post=new HttpPost("http://vogellac2dm.appspot.com/register");
		 post.setHeader("Content-Type","application/json");
		 JSONParser parser=new JSONParser();
		 Object obj=parser.parse(new FileReader("filelocation"));
		 JSONObject json=(JSONObject)obj;
		 StringEntity entity=new StringEntity(json.toString());
		 post.setEntity(entity);
		 HttpResponse response=client.execute(post);
		 System.out.println(response.getEntity().getContent());
		 
		
		 
	 }
	 
	 
	}
	

