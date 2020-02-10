package io;

import java.io.*;

public class FileCopy {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("pic.jpg");
			os = new FileOutputStream("ture.jpg");

			int data = -1;
			while ((data = is.read()) != -1) {
				os.write(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No file - " + e);
		} catch (IOException e) {
			System.out.println("ERROR - " + e);
		} finally {
			try {
				if(is != null)
					is.close();
				if(os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
