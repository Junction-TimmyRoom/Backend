package site.timmyroom.backend.dto.request;

import lombok.Data;

@Data
public class MuseumGetReqeustDTO {
    private Double latitude;
    private Double longitude;
    private Double distance;
}
