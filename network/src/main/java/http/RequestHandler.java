package http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			// get IOStream
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			OutputStream outputStream = socket.getOutputStream();

			String request = null;
			while (true) {
				String line = br.readLine();
				// 브라우저가 연결을 끊음
				if (line == null)
					break;
				// Request(요청)의 헤더만 읽음
				if ("".equals(line))
					break;
				// 헤더의 첫번째 라인만 읽음
				if (request == null) {
					request = line;
					break;
				}
			}
			consoleLog(request);

			String[] tokens = request.split(" ");
			if ("GET".equals(tokens[0])) {
				reponseStaticResource(outputStream, tokens[1], tokens[2]);
			} else {
				response400Error(outputStream, tokens[2]);
				// [POST, DELETE, PUT], HEAD, CONNECT

			}
		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}

	private void reponseStaticResource(OutputStream outputStream, String uri, String protocol) throws IOException {
		if ("/".contentEquals(uri)) {
			uri = "/index.html";
		}
		File file = new File(DOCUMENT_ROOT + uri);
		if (!file.exists()) {
//			응답예시
//			HTTP/1.1 404 Not Found\r\n;
//			Content-Type:text/html; charset=utf-8\r\n
//			\r\n
//			HTML 에러 문서(./webapp/error/404.html) 을 읽어서 보여줘랑
			response404Error(outputStream, protocol);
			return;
		}
		// nio (new io)
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		// 응답
		outputStream.write((protocol+" 200 OK\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}
	
	private void response404Error(OutputStream outputStream, String protocol) throws IOException {
		File notFound = new File(DOCUMENT_ROOT + "/error/404.html");
		byte[] body = Files.readAllBytes(notFound.toPath());
		String contentType = Files.probeContentType(notFound.toPath());

		// 응답
		outputStream.write((protocol + " 404 Not Found\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}
	
	private void response400Error(OutputStream outputStream, String protocol) throws IOException {
		File badRequest = new File(DOCUMENT_ROOT + "/error/400.html");
		byte[] body = Files.readAllBytes(badRequest.toPath());
		String contentType = Files.probeContentType(badRequest.toPath());

		// 응답
		outputStream.write((protocol + " 400 Bad Request\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}
}
