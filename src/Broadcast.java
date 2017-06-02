

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Broadcast implements Runnable{
	Thread thread = new Thread(this);
static	String value ="";
	static	String str = null;
	
	public Broadcast(){
		thread.start();
	}
	public void run(){
	
			
		try{
		//	BufferedReader in = null;
//for(int j = 0; j< arr.length; j++){
	//System.out.println("serving:-"+arr[j]);
			System.out.println("its before");
		//	Thread.sleep(2000);
			Socket clientSocket = new Socket("10.0.0.2", 6111);
			System.out.println("itssssss");
		//	System.out.println("check connection:"+clientSocket.isConnected());
		//	
		System.out.println(nmapClass.nodesMap.size());
			String ipAdd, sysName, macAddress, role;
		for(int i = 0; i <nmapClass.nodesMap.size() ; i++){
			ipAdd = nmapClass.nodesMap.get(i).ip;
			sysName = nmapClass.nodesMap.get(i).sysName;
			macAddress = nmapClass.nodesMap.get(i).macAddress;
	role= nmapClass.nodesMap.get(i).role;
	if(i ==0){
		value = value + ipAdd+" "+sysName+" "+macAddress+" "+role;
	}
	else
	{
		value = value +" "+ ipAdd+" "+sysName+" "+macAddress+" "+role;
	}
	
	
	
			
		}
		System.out.println(value);
		PrintWriter out =
				new PrintWriter(clientSocket.getOutputStream(), true);
		out.println(value);
		out.flush();
		out.close();
				
clientSocket.close();
//Thread.sleep(5000);
//}	
		
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	//	}
	}
}
