package io;

import java.io.*;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			// 기반스트림
			FileReader fr = new FileReader("./src/io/BufferedReaderTest.java");

			// 보조스트림
			br = new BufferedReader(fr);

			int index = 0;
			String line = null;
			while ((line = br.readLine()) != null) {
				index++;
				System.out.println(index + " : " + line);
			}
		} catch (FileNotFoundException e) {
			System.err.println("no file - " + e);
		} catch (IOException e) {
			System.err.println("error - " + e);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
