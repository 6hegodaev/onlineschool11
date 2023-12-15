package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import rest.dto.LessonDTO;

@Service
public class HtmlPageService {

    private final LessonService lessonService;

    public HtmlPageService(LessonService lessonService) {
        this.lessonService = lessonService;
    }


    public ModelAndView createLessonPage() {
        return lessonService.getAllLessons();
    }

    public ModelAndView createLesson(LessonDTO lessonDTO) {return lessonService.createLesson(lessonDTO);}


    public void removeLesson(Integer id) {
        lessonService.removeLessonById(id);
    }

}