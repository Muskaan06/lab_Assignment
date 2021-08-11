package echoUDPProg;

import java.io.*;
import java.net.*;
import java.util.*;

public class MyClient{
	
	public static void main(String args[]) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		//create socket
		DatagramSocket ds = new DatagramSocket();
		
		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;
		
		while(true) {
			String inp = sc.nextLine();
			buf = inp.getBytes();
			//create datagram packet
			DatagramPacket dpsend = new DatagramPacket (buf, buf.length,ip,53273);
			ds.send(dpsend);
			System.out.println("Server: "+inp);
			if(inp.equals("stop"))
				break;
		}
		ds.close();
		sc.close();
	}
}