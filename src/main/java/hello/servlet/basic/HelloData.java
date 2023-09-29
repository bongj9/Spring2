package hello.servlet.basic; //디른곳에도 쓸수있게 베이직 아래에 만들었다

import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class HelloData {

    private String username;
    private int age;
//아래식을 lombok이 대신함
 /*   public String getUsername() {
        return username;
    }

    public void setUsername(String username) { //자바 프로퍼티 접근법,자바빈 접근법
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;*/
}
