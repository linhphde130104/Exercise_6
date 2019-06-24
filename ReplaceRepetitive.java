import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceRepetitive {
	private ReplaceRepetitive() {}
	public static String replace(String input) {
		String regex = "\\b(\\w+)(\\s+\\1\\b)+";
		
		Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);
		while(m.find()) {
			input = input.replaceAll(m.group(), "REPEAT");
			input =input.replaceAll("\\s+"," ");
		}
		return input;
	}
	public static void test(String input) {
		switch (input) {
		case "i want to to go to the zoo":
			System.out.println(input);
			System.out.println("Expect output is: i want REPEAT go to the zoo");
			System.out.println("Realput: "+ replace(input));
			break;
		case "i want to go to the zoo ZOO Zoo":	
			System.out.println(input);
			System.out.println("Expect output is: i want to go to the REPEAT");
			System.out.println("Realput: "+ replace(input));
			break;
		case "i want to to     go to the zoo":
			System.out.println(input);
			System.out.println("Expect output is: i want REPEAT go to the zoo");
			System.out.println("Realput: "+ replace(input));
			break;

		default:
			break;
		}
	}
		

	public static void main(String[] args) {
		test("i want to to go to the zoo");
		test("i want to go to the zoo ZOO Zoo");
		test("i want to to     go to the zoo");

		
	}
}