package club.codedemo.querydslwithjpatutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    void findByName() {
        Assertions.assertEquals(1L,
                this.studentService.findByName("zhangsan").getId());
    }

    @Test
    void findAllOrderByWeight() {
        List<Student> students = this.studentService.findAllOrderByWeight();

        Assertions.assertEquals(56, students.get(0).getWeight());
        Assertions.assertEquals(65, students.get(students.size() - 1).getWeight());
    }

    @Test
    void groupByWeight() {
        Assertions.assertEquals(3,
                this.studentService.groupByWeight().size());
    }

    @Test
    void findAllByCourseName() {
        Assertions.assertEquals(3,
                this.studentService.findAllByCourseName("english").size());
    }

    @Test
    void findAllByKlassName() {
        Assertions.assertEquals(3,
                this.studentService.findAllByKlassName("classOne").size());
    }

    @Test
    void updateNoByName() {
        this.studentService.updateNoByName("888888", "zhangsan");
        Assertions.assertEquals("888888",
                this.studentService.findByName("zhangsan").getNo());
    }

    @Test
    @Transactional
    void deleteByName() {
        this.studentService.deleteByName("zhangsan");
        Assertions.assertNull(this.studentService.findByName("zhangsan"));
    }

}