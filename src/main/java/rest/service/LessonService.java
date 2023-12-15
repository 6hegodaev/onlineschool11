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
    public ModelAndView getAllLessons() {
        List<Lesson> lessons = lessonRepository.getAllLessons();
        List<LessonDTO> resultList = new ArrayList<>();
        for (Lesson lesson : lessons) {
            LessonDTO lessonDTO = new LessonDTO();
            lessonDTO.setId(Math.toIntExact((lesson.getId())));
            lessonDTO.setName(lesson.getName());
            lessonDTO.setAbout(lesson.getAbout());
            lessonDTO.setCategory(lesson.getCategory());
            lessonDTO.setTeacherId(lesson.getTeacherId());
            lessonDTO.setVideo(lesson.getVideo());
            resultList.add(lessonDTO);
        }
        return createAndFillModel(resultList);
    }
    private ModelAndView createAndFillModel(List<LessonDTO> lessonDTOs) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.getModel().put("listLessons", lessonDTOs);
        modelAndView.setViewName("lessons-page");
        return modelAndView;
    }


    public void removeLessonById(Integer id) {lessonRepository.deleteById(id);
    }
}

