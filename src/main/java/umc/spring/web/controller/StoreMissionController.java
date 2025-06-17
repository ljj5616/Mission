package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreMissionConverter;
import umc.spring.domain.Mission;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.StoreMissionDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
@Slf4j
public class StoreMissionController {

    private final umc.spring.service.storeService.StoreMissionQueryService storeMissionQueryService;

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "가게 ID를 기준으로 등록된 미션을 페이징 처리하여 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "조회할 page 번호 입니다.")
    })

    public ApiResponse<StoreMissionDTO.MissionListDTO> getMissionsByStore(@PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page) {
        log.info("page={}", page);
        Page<Mission> missionList = storeMissionQueryService.getMissionsByStore(storeId, page);
        return ApiResponse.onSuccess(StoreMissionConverter.toMissionListDTO(missionList));
    }
}
