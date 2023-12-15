

package rest.service;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.StudentDto;
import rest.dto.UserDTO;
import rest.persistence.entity.User;
import rest.persistence.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository studentRepository;

    public StudentService(UserRepository userRepository) {
        this.studentRepository = userRepository;
    }

    public ModelAndView createStudent(UserDTO studentDto) {
        User user = new User();
        user.setPassword(studentDto.getPassword());
        user.setUsername(studentDto.getUsername());
        user.setBirthDate(studentDto.getBirthDate());

        studentRepository.save(user);

        return getAllStudents();
    }

    public ModelAndView getAllStudents() {
        List<User> users = studentRepository.findAllStudents();
        List<UserDTO> resultList = new ArrayList<>();
        for (User user : users) {
            UserDTO studentDto = new UserDTO();
            studentDto.setId(user.getId().toString());
            studentDto.setPassword(user.getPassword());
            studentDto.setUsername(user.getUsername());
            studentDto.setBirthDate(user.getBirthDate());
            resultList.add(studentDto);
        }

        return createAndFillModel(resultList);
    }

    private ModelAndView createAndFillModel(List<UserDTO> studentDtos) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.getModel().put("listStudents", studentDtos);
        modelAndView.setViewName("studets-page");
        return modelAndView;
    }

    public void removeStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}