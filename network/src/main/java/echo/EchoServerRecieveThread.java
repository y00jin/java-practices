package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerRecieveThread extends Thread {

	private Socket socket;
	
	public EchoServerRecieveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		EchoServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

		try {
			// 4. IOStream 받아오기
			// 연결이 되면 통신을 위한 stream 객체를 얻음
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			while (true) {
				// 5. 데이터 읽기
				String data  = br.readLine();
				if(data == null ) {
					EchoServer.log("closed by client");
					break;
				}
				EchoServer.log("Receiver : " + data);

				// 6. 데이터 쓰기
				pw.println(data);
			}
		} catch (SocketException e) {
			EchoServer.log("suddenly closed by client");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
