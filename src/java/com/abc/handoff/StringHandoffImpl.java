package com.abc.handoff;

import com.abc.pp.stringhandoff.*;
import com.programix.thread.*;

//import java.util.Vector;

public class StringHandoffImpl implements StringHandoff {

	static final int MAXQUEUE =8;
	int i=0;
	private String messages = "apple";
//	final String  message = "apple";
    public StringHandoffImpl() 
 
    {
    	/*messages.addElement("strawberry"); 
    	messages.addElement("apple");  
        messages.addElement("banana");
    messages.addElement("cranberry");
    	messages.addElement("date");
    	messages.addElement("eggplant");
    	 messages.addElement("fig");
    		messages.addElement("grape");
    	messages.addElement("orange");
    	messages.addElement("pear");
    	
    
    	
       
       Thread t1  = new Thread(new Runnable() 
       {
    	   public void run()
    	   {    		  
    			try 
    			{
					while(i<10)
					{
						wait();
						
						pass((String) messages.elementAt(i), 1000);	
						
						
							
						i++;
					}
				} 
    			catch (TimedOutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ShutdownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
    	   }
       });
       Thread t2  = new Thread(new Runnable() 
       {
    	   public void run()
    	   {
    		   
    			try {
    				
					 receive(1000);
					 
				} catch (TimedOutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ShutdownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
    	   }
       });
       t1.start();
       t2.start();
    	
    	// FIXME*/
    }

    @Override
    public synchronized void pass(String msg, long msTimeout)
            throws InterruptedException,
                   TimedOutException,
                   ShutdownException,
                   IllegalStateException {
    
    	 wait(msTimeout);  
    	notify();
         
      // FIXME
    }

    @Override
    public synchronized void pass(String msg)
            throws InterruptedException,
                   ShutdownException,
                   IllegalStateException {

    	  wait(1000);
    	notify();
      
    }

    @Override
    public synchronized String receive(long msTimeout)
            throws InterruptedException,
                   TimedOutException,
                   ShutdownException,
                   IllegalStateException {
            notify();
            wait(msTimeout);
            if(messages.isEmpty())
            	wait(msTimeout);
            	//throw new ShutdownException();
    		String msg = null;
       
        	 return msg; 
    
       	 //throw new IllegalStateException(); // FIXME
    }

    @Override
    public synchronized String receive()
            throws InterruptedException,
                   ShutdownException,
                   IllegalStateException {
    	notify();
    	wait(1000);
       if(messages.isEmpty())
    	   wait(10000);
    	   //throw new ShutdownException();
    	String msg = null;
    	
    	 return msg;
    	// throw new IllegalStateException(); // FIXME
    }

    @Override
    public synchronized void shutdown() {
    	 throw new ShutdownException(); // FIXME
  }
    @Override
    public Object getLockObject() {
        return this;
    }
}

























