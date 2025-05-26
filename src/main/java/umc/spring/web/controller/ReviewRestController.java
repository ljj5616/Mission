package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.AddReviewDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class ReviewRestController {
    //add feature/#2-review

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}/my-reviews")
    public ApiResponse<Long> writeReview(@PathVariable("storeId") Long storeId,
                                         @RequestBody @Valid AddReviewDTO request) {
        Long reviewId = reviewCommandService.writeReview(storeId, request);
        return ApiResponse.onSuccess(reviewId);
    }
}
