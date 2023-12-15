package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import rest.dto.LessonDTO;
import rest.dto.RecordDTO;

@Service
public class HtmlPageService {

    private final RecordService recordService;
    private final LessonService lessonService;


    public HtmlPageService(RecordService recordService, LessonService lessonService) {
        this.recordService = recordService;
        this.lessonService = lessonService;
    }

    public ModelAndView createRecordPage() {
        return recordService.getAllRecords();
    }
    public ModelAndView createLessonPage() {
        return lessonService.getAllLessons();
    }

    public ModelAndView createRecord(RecordDTO recordDTO) {
        return recordService.createRecord(recordDTO);
    }
    public ModelAndView createLesson(LessonDTO lessonDTO) {return lessonService.createLesson(lessonDTO);}

    public void removeRecord(Long id) {
        recordService.removeRecordById(id);
    }

    public void removeLesson(Integer id) {
        lessonService.removeLessonById(id);
    }

}