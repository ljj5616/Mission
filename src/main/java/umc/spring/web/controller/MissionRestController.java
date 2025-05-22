package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.MissionRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}/missions")
    public ApiResponse<Long> addMission(@PathVariable("storeId") @ExistStore Long storeId,
                                        @RequestBody @Valid MissionRequestDTO request) {
        Long id = missionCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(id);
    }
}
