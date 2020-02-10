package test;

import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 1-1. Time-Wait 시간에 소켓에 포트번호 할당을 가능하게 하기 위해서
			serverSocket.setReuseAddress(true);

			// 2. 바인딩 : Socket Address(IP Address + Port) Binding
			// 소켓을 호스트의 포트와 연결(Bind)
			serverSocket.bind(new InetSocketAddress("127.0.0.1", 5000));
			
			// 3. accept
			// 클라이언트로부터 소켓 연결이 올 때 까지 대기(accept)
			Socket socket = serverSocket.accept(); // blocking
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			
			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			
			System.out.println("[server] connected by client["+remoteHostAddress + ":" + remotePort + "]");
			try {
				// 4. IOStream 받아오기
				// 연결이 되면 통신을 위한 stream 객체를 얻음
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				// 5. 데이터 읽기
				while (true) {
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);
					if (readByteCount == -1) {
						// client에서 정상종료 (close 호출)
						System.out.println("close by client");
						return;
					}
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received : " + data);
	
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					// 6. 데이터 쓰기
					os.write(data.getBytes("UTF-8"));
				}
			} catch (SocketException e) {
				System.out.println("[server] sudden closed by client");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null && !socket.isClosed())
						socket.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
