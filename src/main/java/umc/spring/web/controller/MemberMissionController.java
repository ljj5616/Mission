package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.web.dto.MissionChallengeRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<Long> challengeMission(@PathVariable("missionId") Long missionId,
                                              @RequestBody MissionChallengeRequestDTO request) {
        Long id = memberMissionCommandService.challengeMission(missionId, request.getMemberId());
        return ApiResponse.onSuccess(id);
    }
}
