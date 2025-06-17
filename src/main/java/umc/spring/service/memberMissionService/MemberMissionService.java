package umc.spring.service.memberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionService {

    Page<MemberMission> ChallengingMissions(Long memberId, Integer page);

}
