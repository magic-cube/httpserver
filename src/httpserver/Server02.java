package httpserver;
import java.io.*;
import java.net.*;

public class Server02 {
	ServerSocket server=null;
	public static void main(String[] args) {
		new Server02().start();
	}
	public void start(){
		try {
			server=new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void receive(){
		
		try {
			Socket client=server.accept();
			StringBuilder sb=new StringBuilder();
			byte[] data=new byte[2048];
			int len=client.getInputStream().read(data);
			//接收客户端请求信息
			String requestInfo=new String(data,0,len).trim();
			System.out.println(requestInfo);
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	public void stop(){ 
		
	}
}
