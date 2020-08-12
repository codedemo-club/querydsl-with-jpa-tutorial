package club.codedemo.querydslwithjpatutorial;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class StudentDao {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * 查询姓名为X的学生
     *
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
     * 根据姓名或学号进行查询
     *
     * @param name 姓名
     * @param no   学号
     * @return
     */
    Student findByNameAndNo(String name, String no) {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        QStudent qStudent = QStudent.student;

        return query.selectFrom(qStudent)
                    .where(qStudent.name.eq(name), qStudent.no.eq(no))
                    .fetchOne();
    }

    Student findByNameAndNo1(String name, String no) {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        QStudent qStudent = QStudent.student;

        return query.selectFrom(qStudent)
                    .where(qStudent.name.eq(name).and(qStudent.no.eq(no)))
                    .fetchOne();
    }

    /**
     * 按姓名或学号查询学生
     * 满足任一条件即可
     *
     * @param name 姓名
     * @param no   学号
     * @return
     */
    List<Student> findByNameOrNo(String name, String no) {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        QStudent qStudent = QStudent.student;

        return query.selectFrom(qStudent)
                    .where(qStudent.name.eq(name).or(qStudent.no.eq(no)))
                    .fetch();
    }

    /**
     * 按体重排序
     *
     * @return
     */
    List<Student> findAllOrderByWeight() {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        QStudent qStudent = QStudent.student;

        return query.selectFrom(qStudent)
                    .orderBy(qStudent.weight.asc())
                    .fetch();
    }

    int getMaxWeight() {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        QStudent qStudent = QStudent.student;

        int maxWeight = query.selectFrom(qStudent)
                             .select(qStudent.weight.max())
                             .fetchFirst();
        return maxWeight;
    }

    /**
     * 按体重group
     *
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
}
