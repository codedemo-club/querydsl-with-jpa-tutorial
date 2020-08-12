package club.codedemo.querydslwithjpatutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class StudentDaoTest {

    @Autowired
    StudentDao studentDao;

    @Test
    void findByName() {
        Assertions.assertEquals(1L,
                this.studentDao.findByName("zhangsan").getId());
    }

    @Test
    void findByNameAndNo() {
        Assertions.assertEquals(1L,
                this.studentDao.findByNameAndNo("zhangsan", "200001").getId());
    }

    @Test
    void findByNameAndNo1() {
        Assertions.assertEquals(1L,
                this.studentDao.findByNameAndNo1("zhangsan", "200001").getId());
    }

    @Test
    void findByNameOrNo() {
        Assertions.assertEquals(2,
                this.studentDao.findByNameOrNo("zhangsan", "200002").size());
    }

    @Test
    void findAllOrderByWeight() {
        List<Student> students = this.studentDao.findAllOrderByWeight();

        Assertions.assertEquals(56, students.get(0).getWeight());
        Assertions.assertEquals(65, students.get(students.size() - 1).getWeight());
    }

    @Test
    void getMaxWeight() {
        Assertions.assertEquals(65, this.studentDao.getMaxWeight());
    }

    @Test
    void groupByWeight() {
        Assertions.assertEquals(3,
                this.studentDao.groupByWeight().size());
    }


}