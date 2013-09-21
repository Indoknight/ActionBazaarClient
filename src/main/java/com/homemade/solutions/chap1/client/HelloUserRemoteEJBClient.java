package com.homemade.solutions.chap1.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.homemade.solutions.chap1.model.HelloUser;

public class HelloUserRemoteEJBClient {
	 	public static void main(String[] args) throws Exception {
	        // Invoke a stateless bean
		 	HelloUser user = lookupHelloUser();
		 	
		 	System.out.println(user.sayHello("Naren!"));
		 	

	    }
	 
	 	private static HelloUser lookupHelloUser() throws NamingException{
	 		  	//final Hashtable<String, Object> jndiProperties = new Hashtable<String, Object>();
		        //jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		       
		       // final Context context = new InitialContext(jndiProperties);
		        
	 		final Context context = getContext();

		       return (HelloUser) context.lookup("ejb:/ActionBazaar/HelloUserBean!"
		                + HelloUser.class.getName());
	 		
	 	}
	 	
	 	
	 	private static Context getContext() throws NamingException{
	 		final Properties jndiProperties = new Properties();   
	 		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");  
	        
	 		
//	        jndiProperties.put(javax.naming.Context.SECURITY_PRINCIPAL, "admin");  
//	        jndiProperties.put(javax.naming.Context.SECURITY_CREDENTIALS, "tintin1316");  
//	        jndiProperties.put(Context.PROVIDER_URL, "remote://localhost:4447");
//	        
//	        jndiProperties.put("jboss.naming.client.ejb.context", true);
//	        
//	        jndiProperties.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT","false");
//	        
//	        jndiProperties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");  
	        
	        return new InitialContext(jndiProperties);  
	        
	  	}
	 

}
