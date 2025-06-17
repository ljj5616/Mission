package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.service.memberMissionService.MemberMissionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Validated
@Slf4j
public class MemberMissionChallengingController {

    private final MemberMissionService memberMissionService;

    @PatchMapping("/{memberId}/missions/{missionId}/complete")
    @Operation(summary = "진행중인 미션 완료 처리", description = "memberId와 missionId를 받아 미션 상태를 COMPLETED로 변경합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "COMMON200", description = "성공"),
            @ApiResponse(responseCode = "MISSION4001", description = "진행 중 미션이 존재하지 않음"),
            @ApiResponse(responseCode = "MISSION4002", description = "이미 완료된 미션"),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 ID"),
            @Parameter(name = "missionId", description = "미션 ID")
    })
    public umc.spring.apiPayload.ApiResponse<String> completeMission(
            @PathVariable(name = "memberId") Long memberId,
            @PathVariable(name = "missionId") Long missionId
    ) {
        memberMissionService.completeMission(memberId, missionId);
        return umc.spring.apiPayload.ApiResponse.onSuccess("미션 완료 처리 성공");
    }
}
