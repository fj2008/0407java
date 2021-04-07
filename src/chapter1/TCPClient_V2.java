package chapter1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPClient_V2 {

	public static void main(String[] args) {
		ServerSocket  ServerSocket = null;
		
	
			
		
		while(true) {	
			try {
			ServerSocket = new ServerSocket(7777);
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�");
			System.out.println(getTime() + "�����û�� ��ٸ��ϴ�.");
			Socket socket = ServerSocket.accept();
			System.out.println(getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
			System.out.println("getPort() =" + socket.getPort());
			System.out.println("getLocalport() = " + socket.getLocalPort());
			
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			dos.writeUTF("[Notice] Test Message1 from Server.");
			System.out.println(getTime() + "Ŭ���̾�Ʈ�� �����͸� �����߽��ϴ�,");
			
			dos.close();
			socket.close();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		}
	}//main

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}
}
