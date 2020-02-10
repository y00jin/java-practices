package io;

import java.io.*;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;

		try {
			in = new FileReader("1234.txt");

			int count = 0;
			int data = -1;
			while ((data = in.read()) != -1) {
				System.out.print((char) data);
				count++;
			}
			System.out.println("\ncount : " + count);
			System.out.println("*******************");

			count = 0;
			data = -1;
			is = new FileInputStream("1234.txt");
			while ((data = is.read()) != -1) {
				System.out.print((char) data);
				count++;
			}
			System.out.println("\ncount : " + count);
		} catch (FileNotFoundException e) {
			System.out.println("No file this repository - " + e);
		} catch (IOException e) {
			System.out.println("ERROR - " + e);
		} finally {
			try {
				if (in != null)
					in.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
