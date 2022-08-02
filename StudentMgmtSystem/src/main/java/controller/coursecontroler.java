package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class coursecontroler {

    @Autowired
    CourseRepository courseRepository;

//    List<course> courses = new ArrayList<>(
//            Arrays.asList(
//                    new course(1,"full stack","full stack developer"),
//                    new course(2,"DAA","design and analysis of algorithm")
//            )
//    );

//    @GetMapping("/getcourselist")
//    public String  course_list(){
//        return courses.toString();
//    }


    @GetMapping("/getcourselist")
    public List<course> course_list(){

        return courseRepository.findAll();
    }

    @GetMapping("/get_course/{id}")
    public course  get_course(@PathVariable Integer id){

        return courseRepository.findById(id).get();
    }

    @PostMapping("/course")
    public List<course> addcourse(@RequestBody course courses){
        courseRepository.save(courses);
        return courseRepository.findAll();
    }

    @DeleteMapping("/course/{id}")
    public List<course> deletecourse(@PathVariable Integer id){
        courseRepository.delete(courseRepository.findById(id).get());
        return courseRepository.findAll();
    }

    @PutMapping("/course/{id}")
    public List<course> updatecourse(@RequestBody course c,@PathVariable Integer id){
        course course_obj = courseRepository.findById(id).get();
        course_obj.setTitle(c.getTitle());
        course_obj.setId(c.getId());
        course_obj.setDescription(c.getDescription());
        courseRepository.save(course_obj);
        return courseRepository.findAll();




    }


}