package club.codedemo.querydslwithjpatutorial;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class StudentDao {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * 查询姓名为X的学生
     * @param name 学生姓名
     * @return
     */
    Student findByName(String name) {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        QStudent qStudent = QStudent.student;

        return query.selectFrom(qStudent)
             .where(qStudent.name.eq(name))
             .fetchOne();
    }

    /**
     * 按体重排序
     * @return
     */
    List<Student> findAllOrderByWeight() {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        QStudent qStudent = QStudent.student;

        return query.selectFrom(qStudent)
                .orderBy(qStudent.weight.asc())
                .fetch();
    }

    /**
     * 按体重group
     * @return
     */
    List<Integer> groupByWeight() {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        QStudent qStudent = QStudent.student;

        return query.select(qStudent.weight)
             .from(qStudent)
             .groupBy(qStudent.weight)
             .fetch();
    }


    /**
     * 修改学生信息
     * @param no 学号
     * @param name 姓名
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateNoByName(String no, String name) {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        QStudent qStudent = QStudent.student;

        query.update(qStudent)
             .where(qStudent.name.eq(name))
             .set(qStudent.no, no)
             .execute();
    }

    /**
     * 删除学生
     * @param name 姓名
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteByName(String name) {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        QStudent qStudent = QStudent.student;

        query.delete(qStudent)
             .where(qStudent.name.eq(name))
             .execute();
    }
}
