package umc.spring.service.memberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface MemberQueryService {
    Page<Review> getMyReviews(Long memberId, Integer page);

}
