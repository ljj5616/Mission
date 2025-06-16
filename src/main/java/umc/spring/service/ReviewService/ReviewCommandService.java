package umc.spring.service.ReviewService;

import umc.spring.web.dto.AddReviewDTO;

public interface ReviewCommandService {
    Long writeReview(Long storeId, AddReviewDTO request);
}
