

package rest.service;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.UserDTO;
import rest.persistence.entity.User;
import rest.persistence.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ModelAndView createStudent(UserDTO userDTO) {
        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setBirthDate(userDTO.getBirthDate());

        userRepository.save(user);

        return getAllStudents();
    }

    public ModelAndView getAllStudents() {
        List<User> users = userRepository.findAllStudents();
        List<UserDTO> resultList = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId().toString());
            userDTO.setPassword(user.getPassword());
            userDTO.setUsername(user.getUsername());
            userDTO.setBirthDate(user.getBirthDate());
            resultList.add(userDTO);
        }

        return createAndFillModel(resultList);
    }

    private ModelAndView createAndFillModel(List<UserDTO> userDTOs) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.getModel().put("listStudents", userDTOs);
        modelAndView.setViewName("studets-page");
        return modelAndView;
    }

    public void removeStudentById(Long id) {
        userRepository.deleteById(id);
    }
}