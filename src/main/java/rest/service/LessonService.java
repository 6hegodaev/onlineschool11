package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.LessonDTO;
import rest.persistence.entity.Lesson;
import rest.persistence.repository.LessonRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }



    public  ModelAndView createLesson(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson();
        lesson.setName(lessonDTO.getName());
        lesson.setAbout(lessonDTO.getAbout());
        lesson.setCategory(lessonDTO.getCategory());
        lesson.setTeacherId(lessonDTO.getTeacherId());
        if (!lessonDTO.getVideo().equals("")) {
            lesson.setVideo(lessonDTO.getVideo());
        } else {
            lesson.setVideo("/tmp/default.jpg");
        }
        lessonRepository.save(lesson);
        return getAllLessons();
    }
