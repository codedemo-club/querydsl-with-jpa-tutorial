package club.codedemo.querydslwithjpatutorial;
import javax.persistence.*;

/**
 * 学生
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学号
     */
    private String no;

    /**
     * 体重
     */
    private Integer weight;


    public Student() {
    }

    public Student(String name, String no, Integer weight) {
        this.name = name;
        this.no = no;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
