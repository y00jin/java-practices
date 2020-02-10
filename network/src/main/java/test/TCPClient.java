package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPClient {
	
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;
	
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			// 1. 소켓 생성
			socket = new Socket();
			
			// 1-1. 소켓 버퍼 사이즈 확인
			int receiveBufferSize = socket.getReceiveBufferSize();
			int sendBufferSize = socket.getSendBufferSize();
			System.out.println(receiveBufferSize + ":" + sendBufferSize);
			
			// 1-2. 소켓 버퍼 사이즈 변경
			socket.setReceiveBufferSize(1024*10);
			socket.setSendBufferSize(1024*10);
			receiveBufferSize = socket.getReceiveBufferSize();
			sendBufferSize = socket.getSendBufferSize();
			System.out.println(receiveBufferSize + ":" + sendBufferSize);

			// 1-3. SO_NODELAY(Nagle Algorithm Off)
			socket.setTcpNoDelay(true);
			
			// 1-4. SO_TIMEOUT
			socket.setSoTimeout(1000);
			
			// 2. 서버연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT)); // 상대편의 address
			System.out.println("[client] connected");
			
			// 3. IOStream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			// 4. 쓰기
			String data = "Hello World";
			os.write(data.getBytes("UTF-8"));
			
			// 5, 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if (readByteCount == -1) {
				// server에서 정상종료 (close 호출)
				System.out.println("close by server");
				return;
			}
			data = new String(buffer, 0, readByteCount, "UTF-8");
			System.out.println("[client] received : " + data);
		} catch (SocketTimeoutException ste) {
			System.out.println("[client] time out");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
