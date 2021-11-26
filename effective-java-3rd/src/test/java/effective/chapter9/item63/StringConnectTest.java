package effective.chapter9.item63;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringConnectTest {

	@Test
	public void stringConcat() {
		String s = "";
		for(int i=0;i<100_000;i++){
			s+= i+"hello";
		}
	}

	@Test
	public void stringBuilder() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<100_000;i++){
			sb.append(i).append("hello");
		}
	}

}
