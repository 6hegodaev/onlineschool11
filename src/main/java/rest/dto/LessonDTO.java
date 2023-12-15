package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Integer id;
    private String name;
    private String about;
    private String category;
    private Integer teacherId;
    private String video;

}