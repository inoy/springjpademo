package yskin.jpademo.instructor;

import org.springframework.data.repository.CrudRepository;
import yskin.jpademo.instructor.entity.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor, Integer> {
}
