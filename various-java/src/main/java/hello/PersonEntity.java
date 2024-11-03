package hello;

import java.util.Objects;

public class PersonEntity implements Comparable<PersonEntity> {
	private Long id;
	private String name;
	private Integer age;
	
	public PersonEntity(Long id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Long getId() {
		return id;
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
		PersonEntity that = (PersonEntity)o;
		return Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
	@Override
	public String toString() {
		return "hello.PersonEntity{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
	}
	
	@Override
	public int compareTo(PersonEntity o) {
		return this.id.compareTo(o.id);
	}
}
