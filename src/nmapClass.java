import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class nmapClass {
public 	static HashMap<Integer, Nodes>  nodesMap= new HashMap<>();
public 	static HashMap<String, String>  map= new HashMap<>();

static String reader,macAdd, sysName, ipAddress ;
static int i = 0;
static int ipCount=0;
static int ipMax=0;
	public static void main(String args[]){
	//	nmapClass.getIp();
fetchIpAndRole();
assignRole();
//System.out.println("after assign");
	//	ListenThread listenThread = new ListenThread();

Broadcast broadcast = new Broadcast();
	try{
	Thread.sleep(7000);
	}
	catch (Exception e) {
	  System.out.println(e.getMessage());
	}
//	WriteAck writeAck = new WriteAck();
	AckReceived ackReceived = new AckReceived();
	}
public static void fetchIpAndRole(){
	try{
		BufferedReader		br1 = new BufferedReader(new FileReader("C:\\Users\\siddhartha\\Desktop\\nmapdata.txt"));
while((reader = br1.readLine()) != null)		{
	  if( reader.contains("Nmap scan report") ){
		  ipCount++;
	  }
}
	BufferedReader		br = new BufferedReader(new FileReader("C:\\Users\\siddhartha\\Desktop\\nmapdata.txt"));
	while ((reader = br.readLine()) != null) {
		//  System.out.println("ip is:-"+ip);
		 
		  if( reader.contains("Nmap scan report") ){
			if(!reader.contains("routerlogin.com")){
				ipAddress = reader.substring(21);		
			}
			else if(reader.contains("routerlogin.com")){
				ipAddress = reader.substring(41);		
			}
			 
			 ipMax++;
			 if(ipMax == ipCount){
					  macAdd = "A4-17-31-F0-31-9B";
					   sysName = "honhai";
					   Nodes nodes = new Nodes(ipAddress, sysName, macAdd) ;
						nmapClass.nodesMap.put(i, nodes);
						i++;			  
				  }
	//		 System.out.println(address);
		 	
	  }	
		  else		 if(reader.contains("MAC Address") ){
			 
			  
			  //System.out.println("inside");
			   macAdd = reader.substring(13, 30);
			   sysName = reader.substring(31).replace(" ", "");
			   Nodes nodes = new Nodes(ipAddress, sysName, macAdd) ;
				nmapClass.nodesMap.put(i, nodes);
				i++;	
			  
			//  System.out.println(macAdd);
			 // System.out.println(sysName);
		 }
			  
			  
		  }
	for(int i =0 ; i< nmapClass.nodesMap.size() ; i++ ){
		System.out.println(nmapClass.nodesMap.get(i).ip);
		System.out.println(nmapClass.nodesMap.get(i).macAddress);
		System.out.println(nmapClass.nodesMap.get(i).sysName);
		System.out.println("\n\n");
	}
		}
	
	
	catch (Exception e) {
		System.out.println("in catch");
		System.out.println(e.getMessage());
	}
	}
public static void assignRole(){
	for(int i = 0; i<nodesMap.size(); i++){
		System.out.println("Assign role for:-"+nodesMap.get(i).sysName+" : "+nodesMap.get(i).macAddress);
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
			nodesMap.get(i).role = scanner.nextLine();
			System.out.println(nodesMap.get(i).role);	
			
				break;
			}
		}	
	//	System.out.println("after while");
	}
	//System.out.println("after for");
}
	
}