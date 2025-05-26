package umc.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberMissionHandler;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void completeMission(Long memberId, Long missionId) {

        MemberMission memberMission = memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId)
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        if (memberMission.getMissionStatus() == MissionStatus.COMPLETED) {
            throw new MemberMissionHandler(ErrorStatus.ALREADY_COMPLETED_MISSION);
        }

        memberMission.updateStatus(MissionStatus.COMPLETED);
    }
}
