package hello;

import java.util.Objects;

public class PersonValue {
	private final String name;
	private final Integer age;
	
	public PersonValue( String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		PersonValue that = (PersonValue)o;
		return Objects.equals(name, that.name) && Objects.equals(age, that.age);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	@Override
	public String toString() {
		return "hello.PersonValue{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}
