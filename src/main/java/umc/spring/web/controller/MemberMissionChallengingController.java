package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberMissionService.MemberMissionService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.MemberMissionDTO;

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

    @GetMapping("/{memberId}/missions/ongoing")
    @Operation(summary = "내가 진행 중인 미션 목록 조회", description = "진행 중(MissionStatus = CHALLENGING) 상태의 미션을 페이징 처리하여 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 ID (Path Variable)"),
            @Parameter(name = "page", description = "조회할 페이지 번호")
    })
    public umc.spring.apiPayload.ApiResponse<MemberMissionDTO.ChallengingMissionListDTO> getChallengingMissions(
            @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page
    ) {
        Page<MemberMission> missions = memberMissionService.ChallengingMissions(memberId, page);
        return umc.spring.apiPayload.ApiResponse.onSuccess(MemberMissionConverter.toChallengingMissionListDTO(missions));
    }
}
