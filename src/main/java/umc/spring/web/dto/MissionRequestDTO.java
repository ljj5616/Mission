package umc.spring.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MissionRequestDTO {

    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
}
