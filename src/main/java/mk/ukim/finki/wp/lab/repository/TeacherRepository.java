package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepository {
    public List<Teacher> findAll(){
        return DataHolder.teacherList;
    }

    public Teacher findTeacherById(Long teacherId){
        return DataHolder.teacherList.stream().filter(r->r.getId().equals(teacherId)).findFirst().get();
    }



}
