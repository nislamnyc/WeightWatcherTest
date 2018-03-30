package com.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Md Islam
 *  Purpose: Reading file from given location and spiting the part with '-'.
 *  2nd portion of the line is meaning to display in console.
 */
public class FileReading {

	public static void main(String args[]) {

		String fileName = "data//dictionary.txt";

		if (doesFileExist(fileName)) {

			try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
				List<String> list;
				list = lines.collect(Collectors.toList());
				for (String s : list) {
					String[] st = s.split("-");
					System.out.println(st[0]);
					if (st[1].contains(",")) {
						String[] meaning = st[1].split(",");
						for (String m : meaning) {
							System.out.println(m);
						}
					} else
						System.out.println(st[1]);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	//Check if file exist
	static boolean doesFileExist(String path) {
		Path p = Paths.get(path);
		boolean flag = Files.exists(p);
		if (!flag) {
			System.out.println("File is not present in that location.");
		}
		return flag;
	}

}
