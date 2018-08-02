package daebaksong.org.firstProject;

// DTO : Data Transfer Object
public class HelloDTO {
    private String name; // 필드(field)
    private int age;

    // name 프로퍼티(property)
    // getter 메서드
    public String getName() {
        return name;
    }

    // name 프로퍼티(property)
    // setter 메서드
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
