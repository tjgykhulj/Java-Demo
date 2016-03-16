package demo;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class StringTest2 extends BaseDemo {
/*
 * Example input:
after 23 minutes.
[a-e].
\d
.[aeiou].
 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// and then "br.readLine()", is also a way to read from console.
		
		print("Test Regular Expression, Input : ");
		// you can invoke methods like stdin.nextInt()
		Scanner stdin = new Scanner(System.in);
		String input = stdin.nextLine();
		//println(Arrays.toString(input.split("\\.|:|\\ ")));
		println("match only digits : " + input.matches("\\d*"));
		println("match only letters : " + input.matches("[a-z]*")); // match letter 'a'
		println("replace [c-f] to 1 : " + input.replaceAll("[c-f]", "1")); // changes C-F to 1
		

		for (int i=0; i<3; i++) {
			printf("[test %d] regular expression : ", i);
			String re = stdin.nextLine();
			Pattern p = Pattern.compile(re);
			Matcher m = p.matcher(input);
			while (m.find()) 
				printf("  match \"%s\" at pos %s - %s\n",
						m.group(), m.start(), m.end());
		}

		println("[Other Test]");
		String test = "He is my friend.\n" +
				"he is not a good people.\n" +
				"HE hung out with her yesterday.";
		/* There are three 'he's in the head of sentences.
		 * ?i will make matcher case insensitive, and
		 * ?m will make ^ to match the head of every line.
		 * or else ^ will only match the head of string.
		 */
		Matcher m = Pattern.compile("(?im)^he").matcher(test);
		while (m.find()) {
			printf("[match] \"%s\" at pos %s - %s\n",
					m.group(), m.start(), m.end());
		}
		// it will reset the string it searches. 
		m.reset("he");
		
		
		// Split by the regular expression. 
		// Number 2 means at most 2 sentences it can be divided to.
		String test2 = "Fuck!!Can you hear it!!There is a sound.";
		println(Arrays.toString(Pattern.compile("!!").split(test2, 2)));
		
		StringBuffer sbuf = new StringBuffer();
		Matcher m2 = Pattern.compile("[aeiou]").matcher(test2);
		while (m2.find()) 
			m2.appendReplacement(sbuf, m2.group().toUpperCase());
		// if you don't appendTail, this example will end with "sOU" but miss "und."
		m2.appendTail(sbuf);
		println(sbuf);
		
		/*
		 * 	stdin.useDelimiter("\\s*,\\s*");
		 *  like 1,2,3,4,5
		 *  stdin.nextInt() will get 1 to 5 in order and ignore ','
		 *  
		 *  stdin.hasNext(pattern) stdin.next(pattern)
		 *  means use this pattern to match next one. 
		 */
	}

}
