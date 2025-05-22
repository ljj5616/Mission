package umc.spring.service.ReviewService;

import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Long writeReview(Long storeId, ReviewRequestDTO request);
}
