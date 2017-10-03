package com.simple;



/**
 * Generate a unique number
 *
 */
public class Greeting 
{

    public static void main( String[] args )
    {
        Greeting msg = new Greeting();
       System.out.println(msg.getStatus());
    }
    
    public String getStatus(){
    	
    	return "GOOD";
    	
    }
}
