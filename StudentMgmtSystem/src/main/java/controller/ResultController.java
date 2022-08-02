package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Result;
import in.ac.charusat.studentmgmtsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController  {

    @Autowired
    ResultRepository resultRepository;

    @GetMapping("/listresult")
    public List<Result> get_result(){
        return resultRepository.findAll();
    }

    @GetMapping("/result/{id}")
    public Result getresult(@PathVariable Integer id){
        return resultRepository.findById(id).get();
    }

    @DeleteMapping("/result/{id}")
    public List<Result> delete_result(@PathVariable Integer id){
        resultRepository.delete(resultRepository.findById(id).get());
        return resultRepository.findAll();
    }

    @PostMapping("/result")
    public List<Result> addresult(@RequestBody Result result){
        resultRepository.save(result);
        return resultRepository.findAll();
    }

    @PutMapping("/result/{id}")
    public List<Result> updateresult(@RequestBody Result result,@PathVariable Integer id){
        Result resultobj = resultRepository.findById(id).get();
        resultobj.setId(result.getId());
        resultobj.setSemester(result.getSemester());
        resultobj.setPercentage(result.getPercentage());
        resultRepository.save(resultobj);
        return resultRepository.findAll();
    }

}