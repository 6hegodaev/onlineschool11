package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.LessonDTO;
import rest.service.HtmlPageService;
import rest.dto.RecordDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс в котором описываются http методы (АПИ), методы вызываются с фронта
 **/
@RestController
public class Controller {

    @Autowired
    private HtmlPageService htmlPageService;
    /**
     * Пример метода который будет вызываться по URL: http://localhost:8081
     * метод возвращает html страницу, "resources/templates/lessons-page.html
     *
     * TODO переделать на login.html
     * "
     **/

    @GetMapping(value = "/")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        //return htmlPageService.createRecordPage();//страница загрузки мейна TODO АВТОРИЗАЦИЯ^
        return  htmlPageService.createLessonPage();
    }
    @GetMapping(value = "/add-lesson")
    public ModelAndView newLesson() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-lesson"); // TODO Здесь переделать структуру в соответствии с ТЗ(видео вместо фото я хз))
        return modelAndView;
    }


    @PostMapping(value = "/add-lesson")
    public ModelAndView addLesson(LessonDTO lessonDTO) {
        return htmlPageService.createLesson(lessonDTO);
    }


    @GetMapping(value = "/add-record")
    public ModelAndView newRecord() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-record"); // TODO Здесь переделать структуру в соответствии с ТЗ(видео вместо фото я хз))
        return modelAndView;
    }

    @PostMapping(value = "/add-record")
    public ModelAndView addRecord(RecordDTO recordDTO) {
        return htmlPageService.createRecord(recordDTO);
    }
    /*
        @GetMapping(value = "/remove/{id}")
        public void removeRecord(@PathVariable(value = "id") Long id, HttpServletResponse response, ModelAndView modelAndView) throws IOException {
            modelAndView.clear();
            htmlPageService.removeRecord(id);
            response.sendRedirect("/");//TODO вернуть на lessons-page.html
        }

     */
    @GetMapping(value = "/remove/{id}")
    public void removeLesson(@PathVariable(value = "id") Integer id, HttpServletResponse response, ModelAndView modelAndView) throws IOException {
        modelAndView.clear();
        htmlPageService.removeLesson(id);
        response.sendRedirect("/");//TODO вернуть на lessons-page.html
    }
    /*
    @PostMapping(value = "/login")
    public  ModelAndView login(User user){
        if (HtmlPageService.checkAuth(user))
        ModelAndView modelAndView = new ModelAndView();
        return htmlPageService.createLessonPage();
    }

*/



}