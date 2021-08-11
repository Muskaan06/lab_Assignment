package echoUDPProg;

import java.net.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class MyServer {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket(53273);
        byte[] receive = new byte[65535];

        
        DatagramPacket dprcv = null;
       

        while(true){
            dprcv = new DatagramPacket(receive,receive.length);
            ds.receive(dprcv);
            System.out.println("Client: "+ data(receive));
            
            if(data(receive).toString().equals("stop")){
                System.out.println("Server closing...");
                break;
            }
            receive = new byte[65535];
        }
        ds.close();
        sc.close();
    }

    public static StringBuilder data(byte[] a){
        if(a == null)return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while(a[i] != 0){
            ret.append((char)a[i]);
            i++;
        }
        return ret;
    }
}