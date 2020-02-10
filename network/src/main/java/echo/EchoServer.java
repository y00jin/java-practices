package echo;

import java.io.IOException;
import java.net.*;

public class EchoServer {

	private static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩 : Socket Address(IP Address + Port) Binding
			// 소켓을 호스트의 포트와 연결(Bind)
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT));
			log("Server Starts...[port : " + PORT + "]");

			while (true) {
				// 3. accept
				// 클라이언트로부터 소켓 연결이 올 때 까지 대기(accept)
				Socket socket = serverSocket.accept(); // blocking

				/////////////////////////// EchoServerRecieveThread
				new EchoServerRecieveThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		// thread 번호 가져오기 
		// Thread.currentThread().getId()
		System.out.println("[server#" + Thread.currentThread().getId() +" ] " + log);
	}

}
