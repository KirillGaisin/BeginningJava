package com.kirill.web;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class SitoUniqueWords {
	
	private void uniqueWordsIO() {
		
		try {
			BufferedReader br = new BufferedReader
					(new InputStreamReader
							(new FileInputStream
									("C:\\Users\\Zoddtheimmortal\\Desktop\\testfile1.txt")));
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Сортировать слова из файла в алфавитном порядке? Да/Нет");
			String alphabet = sc.nextLine();
			System.out.println("Вывести число повторяющихся в файле слов? Да/Нет");
			String duplicates = sc.nextLine().toLowerCase();
			
			sc.close();
			
			String strLine;
			
			ArrayList<String> sortWords = new ArrayList<>();
				while ((strLine = br.readLine()) != null){
					sortWords.addAll(Arrays.asList(strLine.split("\\s")));
					Collections.sort(sortWords);
					//System.out.printf("следующая строка - %s\n", strLine);	
				}
				
				if(alphabet.equalsIgnoreCase("да"))
					System.out.println("Отсортированные в алфавитном порядке слова: ");
					for (String alphabetSorted : sortWords)
						System.out.println(alphabetSorted);
			
				if(duplicates.equalsIgnoreCase("да")) {
					
				Map<String, Integer> dupeMap = new HashMap<>();
				for (String name : sortWords)
					if(dupeMap.containsKey(name)) {
						int count = dupeMap.get(name); // get выдает value по ключу в ()
						dupeMap.put(name, ++count);
					} else {
						dupeMap.put(name, 1);
					}			
				
				Set<Map.Entry<String, Integer>> dupes = dupeMap.entrySet();
				
				Iterator<Map.Entry<String, Integer>> iterator = dupes.iterator();
				while(iterator.hasNext()) {
					Map.Entry<String, Integer> dupe = iterator.next();
					if(dupe.getValue() == 1)
						iterator.remove();
				}
				
				System.out.printf("Дубликаты: %s\n", dupes);

			}
				
			br.close();
				
			Set<String> words = new HashSet<>(sortWords);			
				
			File uniqueWords = new File("C:\\Users\\Zoddtheimmortal\\Desktop\\uniqueWords.txt");
			if(!uniqueWords.exists())
				uniqueWords.createNewFile();
				
			PrintWriter bw = new PrintWriter
					(new BufferedWriter
							(new OutputStreamWriter
									(new FileOutputStream(uniqueWords))));
				
				for(String w : words)
					//System.out.printf("пишем строку %s\n", w);
					bw.println(w);
				
				bw.flush();
				bw.close();
				
				System.out.println("Файл " + uniqueWords + " обновлен.");
				
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		
	}

	public static void main(String[] args) {
	
		SitoUniqueWords uniqueSito = new SitoUniqueWords();
		uniqueSito.uniqueWordsIO();
		

	}

}
