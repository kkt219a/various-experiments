package hello.match;

import java.util.List;

public class Match {
	private static final String COLOR_CODE_PATTERN = "^(?:[^+]{1,248}\\+)?#([A-Fa-f0-9]{6})$";
	public static void main(String[] args) {
		List<String> matches = List.of(
		
		);
		List<String> notMatches = List.of(
		
		);
		System.out.println(matches.stream()
							   .allMatch(COLOR_CODE_PATTERN::matches));
		System.out.println(notMatches.stream()
								  .noneMatch(COLOR_CODE_PATTERN::matches));
	}
}
