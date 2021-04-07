package chapter1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PCPServer_V4 implements Runnable {
	ServerSocket serverSocket;
	Thread[] threadArr;
	
	public PCPServer_V4(int num) {
		try {
			serverSocket = new ServerSocket(7777);
			
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�");
		
		threadArr= new Thread[num];
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}
	
	
	
	
		@Override
	public void run() {
		while(true) {
			try {
				System.out.println(getTime() + Thread.currentThread() + "�� ���� ��û�� ��ٸ��ϴ�.");
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�");
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice] Test Message1 From Server.");
				System.out.println(getTime() + "�����͸� �����ޤ����ϴ�.");
				dos.close();
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void start () {
		for(int i = 0 ; i<threadArr.length; i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	
	public static void main(String[] args) {
		PCPServer_V4 server = new PCPServer_V4(5);
		
		server.start();
		
		
	}

	

}
