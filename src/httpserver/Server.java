package httpserver;
import java.io.*;
import java.net.*;

public class Server {
	ServerSocket server=null;
	public static void main(String[] args) {
		new Server().start();
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
			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			String msg=null;
			while((msg=br.readLine()).length()>0){
				sb.append(msg);
				sb.append("\r\t");
				if(msg==null){
					break;
				}
			}
			String requestInfo=sb.toString().trim();
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void stop(){ 
		
	}
}
