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
		//�����忡 ������ �ؽø� Ex)1�������尡 ��� ���µ��� 2�������尡 �����ؼ� 1���������� ���� �ٲ�������� ����//�ѹ��� �Ѱ��� �����常���°�
		clients = new ConcurrentHashMap<>();
	}
	
	
	public void sratr() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("������ ���� �Ǿ����ϴ�");
			
			while (true) {
				socket = serverSocket.accept();
				System.out.println("["+ socket.getInetAddress()+" : " + socket.getPort() + " ]���� �����Ͽ����ϴ�.");
				
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
