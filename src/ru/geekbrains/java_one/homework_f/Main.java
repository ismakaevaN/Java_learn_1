package ru.geekbrains.java_one.homework_f;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		concatfiles();
		findWordInFile("D:/joke.txt", "JScript");
		findWordInFile("D:/joke.txt", "Kilkenny");
		Main main = new Main();
		main.findWordInFolder("D:/testf", "JScript");
	}

	private static void concatfiles() {
		try {
			FileInputStream fis = new FileInputStream("D:/joke_1.txt");
			int b;
			FileOutputStream fos = new FileOutputStream("D:/joke.txt");
			while ((b = fis.read()) != -1) {
				fos.write(b);
			}
			fis.close();

			fis = new FileInputStream("D:/joke_2.txt");
			while ((b = fis.read()) != -1) {
				fos.write(b);
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean findWordInFile(String fileName, String searchWord) {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Scanner sc = new Scanner(fis);
			while (sc.hasNext()) {
				if (sc.next().contains(searchWord)) {
					fis.close();
					return true;
				}
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean findWordInFolder(String fileName, String searchWord) {
		File file = new File(fileName);
		if (file.isDirectory()) {
			String[] ppp = file.list();
			for (int i = 1; i < ppp.length; i++) {
				if (findWordInFolder(fileName + "/" + ppp[i], searchWord)) {
					return true;
				}
			}
		} else {
			if (findWordInFile(fileName, searchWord)) {
				return true;
			}
		}
		return false;
	}
}
