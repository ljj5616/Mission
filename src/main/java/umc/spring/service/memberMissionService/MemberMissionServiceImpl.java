package umc.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MemberMissionHandler;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Page<MemberMission> ChallengingMissions(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return memberMissionRepository.findAllByMemberAndMissionStatus(
                member,
                MissionStatus.CHALLENGING,
                PageRequest.of(page, 10));
    }

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
