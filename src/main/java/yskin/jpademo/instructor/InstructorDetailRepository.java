package yskin.jpademo.instructor;

import org.springframework.data.repository.CrudRepository;
import yskin.jpademo.instructor.entity.InstructorDetail;

public interface InstructorDetailRepository extends CrudRepository<InstructorDetail, Integer> {
}
