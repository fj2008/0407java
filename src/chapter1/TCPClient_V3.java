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
			System.out.println(getTime() + "서버가 준비되었습니다");
			System.out.println(getTime() + "연결요청을 기다립니다.");
			Socket socket =null;
			//서버가 클라이언트를 기다릴 시간을 설정
			//5초(밀리초 단위로 시간을 설정하기 때문에 1초 * 1000
			 ServerSocket.setSoTimeout(5*1000);
			System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
			//클라이언트의 pore
			System.out.println("getPort() =" + socket.getPort());
			//서버의 port
			System.out.println("getLocalport() = " + socket.getLocalPort());
			
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			dos.writeUTF("[Notice] Test Message1 from Server.");
			System.out.println(getTime() + "클라이언트로 데이터를 전송했습니다,");
			
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
