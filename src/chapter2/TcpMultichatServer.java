package chapter2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TcpMultichatServer {
	public static Map<String, DataOutputStream> clients;
	static {
		//쓰레드에 안전한 해시맵 Ex)1번쓰래드가 잠시 쉬는동안 2번쓰래드가 일을해서 1번쓰래드의 값이 바뀌는현상을 방지//한번에 한개의 쓰래드만쓰는것
		clients = new ConcurrentHashMap<>();
	}
	
	
	public void sratr() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작 되었습니다");
			
			while (true) {
				socket = serverSocket.accept();
				System.out.println("["+ socket.getInetAddress()+" : " + socket.getPort() + " ]에서 접속하였습니다.");
				
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void sendToAll(String msg) {
		Iterator<String> it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				String key = it.next();
			DataOutputStream out = (DataOutputStream) clients.get(key);
			out.writeUTF(msg);
			
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}//end while
				
	}//end try
	
	
	public static void main(String[] args) {
		new TcpMultichatServer().sratr();
	}//main
	
	
	
	
}//class
