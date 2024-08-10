package site.timmyroom.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import site.timmyroom.backend.entity.Menu;

@Data
@Builder
public class ImageDTO {

    private String id;
    private String contentType;
    private Long size;
    private String name;
    private MenuDTO menu;
}
