package chapter1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPClient_V3 {

	public static void main(String[] args) {
ServerSocket  ServerSocket = null;
		
	
			
		
		while(true) {	
			try {
			ServerSocket = new ServerSocket(7777);
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�");
			System.out.println(getTime() + "�����û�� ��ٸ��ϴ�.");
			Socket socket =null;
			//������ Ŭ���̾�Ʈ�� ��ٸ� �ð��� ����
			//5��(�и��� ������ �ð��� �����ϱ� ������ 1�� * 1000
			 ServerSocket.setSoTimeout(5*1000);
			System.out.println(getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
			//Ŭ���̾�Ʈ�� pore
			System.out.println("getPort() =" + socket.getPort());
			//������ port
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
	}
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}
}
