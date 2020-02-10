package io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class PhoneList02 {

	public static void main(String[] args) {

		Scanner scanner = null;

		try {
			File file = new File("phone.txt");

			if (!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;
			}
			System.out.println("* * * * * * * * * * * * * 파일정보 * * * * * * * * * * * * *");
			System.out.println(file.getAbsolutePath()); // 파일의 절대 경로
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified()))); // 최종수정일

			System.out.println("\n* * * * * * * * * * * * * 전화번호 * * * * * * * * * * * * *");
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String name = scanner.next();
				String phone1 = scanner.next();
				String phone2 = scanner.next();
				String phone3 = scanner.next();

				System.out.println(name + " : " + phone1 + "-" + phone2 + "-" + phone3);
			}

		} catch (IOException e) {
			System.out.println("error : " + e);
		} finally {
			scanner.close();
		}

	}

}
