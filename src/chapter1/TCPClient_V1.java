package chapter1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient_V1 {

	public static void main(String[] args) {
		
		try {
			//�������ּ�
			String serverIp = "192.168.2.101";
			
			System.out.println("������ �������Դϴ�. ���� IP = " + serverIp);
			
			Socket socket;
			
			socket = new Socket(serverIp,7777);
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("�����κ��� ���� �޽��� : " + dis.readUTF());
			System.out.println("������ �����մϴ�");
			
			dis.close();
			socket.close();
			System.out.println("������ ����Ǿ����ϴ�.");
				
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
	}

}
