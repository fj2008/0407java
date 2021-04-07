package chapter1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPServer_V1 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		//��Ĺ���α׷��� cmd(���������Ʈ)�� �����ų������ 
		try {
			//Ŭ���̾�Ʈ�� ������ �޾Ƶ��� ��Ĺ
			//7777��Ʈ�� ����� ���� ���� ����
			
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
			
			while(true) {
			System.out.println(getTime() + "�����û�� ��ٸ��ϴ�.");
			Socket socket = serverSocket.accept();
			System.out.println(getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
			
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			dos.writeUTF("[Notice] Test Message1 from Server.");
			System.out.println(getTime() + "Ŭ���̾�Ʈ�� �����͸� �����߽��ϴ�,");
			
			dos.close();
			socket.close();
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}//main

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}
	
	
	
}
