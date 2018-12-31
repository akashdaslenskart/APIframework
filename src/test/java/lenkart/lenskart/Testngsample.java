package lenkart.lenskart;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testngsample {

	
	String name;
 
	@BeforeSuite
	public void printtestdetails() {
		System.out.println("coding details");
	}
	
	
	  
	  @Test
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
			
	  
  }
	  
	  
	  @Test
	  public void secondsample() throws ClientProtocolException, IOException {
			
			HttpClient client = HttpClientBuilder.create().build();    
		    HttpResponse response = client.execute(new HttpGet("http://www.vogella.com"));
		    int statusCode = response.getStatusLine().getStatusCode();
		    
		    if(statusCode==200) {
		    	System.out.println("second time");
		    }
		    
		    else {
		    	System.out.println("NO");
		    }
			
	  
  }
	  
	  @DataProvider(name="valuestoadd")
	  public Object[][] dataprovider(){
		  return new Object[][]{{1,2}};
	  }
	  
	  
	  @Test(dataProvider="valuestoadd")
	  public void add(int a,int b){
		  int x =a;
		  int y=b;
		  int z=x+y;
		  System.out.println(z+"the sum is");
		  Assert.assertEquals(z, 3);
		  
		  
	  }
	  
	  @BeforeClass
	  public void readingfrompropertiesfile() throws IOException {
		  FileReader reader=new FileReader("/Users/prasanjit/Desktop/Hackerrank/lenskart/src/test/java/lenkart/lenskart/name.properties");
		  Properties prop=new Properties();
		  prop.load(reader);
		  System.out.println(prop.getProperty("name"));
		  name=prop.getProperty("name");
	  }
	  
	  
	  
	@Test
	@Parameters("name")
	public void checkpropertiesfile(String name) {
		String names=name;
		System.out.println(names+"<");
		
	}
	
	
	
	  
	  @AfterSuite
	  public void aftertest() {
		  System.out.println("after test");
	  }

	  
	  @BeforeMethod
	  public void beforemethod() {
		  System.out.println("before method");
	  }
	  
	  @BeforeTest
	  public void beforetest() {
		  System.out.println("before test");
	  }
	  
	  @Test(groups= {"functest"})
	  public void functionaltest() {
		  System.out.println("Checking");
		  
	  }
	  
	  @Test(groups= {"checkintest"})
	  public void checkintest() {
		  System.out.println("checkintest");
		  
	  }
	  
}