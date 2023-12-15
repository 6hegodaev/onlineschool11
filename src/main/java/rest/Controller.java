package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.LessonDTO;
import rest.persistence.entity.User;
import rest.service.HtmlPageService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс в котором описываются http методы (АПИ), методы вызываются с фронта
 **/
@RestController
public class Controller {

    @Autowired
    private HtmlPageService htmlPageService;

    @GetMapping(value = "/")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();

        return  htmlPageService.createLessonPage();
    }
    @GetMapping(value = "/add-lesson")
    public ModelAndView newLesson() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-lesson");
        return modelAndView;
    }


    @PostMapping(value = "/add-lesson")
    public ModelAndView addLesson(LessonDTO lessonDTO) {
        return htmlPageService.createLesson(lessonDTO);
    }





    @GetMapping(value = "/remove/{id}")
    public void removeLesson(@PathVariable(value = "id") Integer id, HttpServletResponse response, ModelAndView modelAndView) throws IOException {
        modelAndView.clear();
        htmlPageService.removeLesson(id);
        response.sendRedirect("/");// вернуть на lessons-page.html
    }

    @PostMapping(value = "/login")
    public  ModelAndView login(User user) {
        if (true) {
            ModelAndView modelAndView = new ModelAndView();
            return htmlPageService.createLessonPage();
        }

    }



}