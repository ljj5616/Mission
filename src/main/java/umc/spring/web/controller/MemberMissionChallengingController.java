package umc.spring.web.controller;

<<<<<<< HEAD
import jakarta.validation.Valid;
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
                                              @RequestBody @Valid MissionChallengeRequestDTO request) {
        Long id = memberMissionCommandService.challengeMission(missionId, request.getMemberId());
        return ApiResponse.onSuccess(id);
=======
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
import MemberMissionChallengingConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberMissionService.MemberMissionService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.MemberMissionDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
@Slf4j
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

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
>>>>>>> feature/#8-get-challenging-mission-list
    }
}
