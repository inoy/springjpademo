package yskin.jpademo.instructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yskin.jpademo.instructor.entity.Instructor;
import yskin.jpademo.instructor.entity.InstructorDetail;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorRepository repo;
    private final InstructorDetailRepository repoDetail;

    public InstructorController(InstructorRepository repo, InstructorDetailRepository repoDetail) {
        this.repo = repo;
        this.repoDetail = repoDetail;
    }

    @GetMapping
    public Iterable<Instructor> getInstructor() {
        return repo.findAll();
    }

    @GetMapping("/detail")
    public Iterable<InstructorDetail> getInstructorDetail() {
        return repoDetail.findAll();
    }


}
