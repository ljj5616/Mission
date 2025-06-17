package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberReviewConverter {

    public static MemberResponseDTO.MyReviewDTO toMyReviewDTO(Review review) {
        return MemberResponseDTO.MyReviewDTO.builder()
                .reviewId(review.getId())
                .storeName(review.getStore().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt())
                .build();
    }


    public static MemberResponseDTO.MyReviewListDTO toMyReviewListDTO(Page <Review> reviewPage) {
        List<MemberResponseDTO.MyReviewDTO> reviewDTOList = reviewPage.stream()
                .map(MemberReviewConverter::toMyReviewDTO)
                .collect(Collectors.toList());

        return MemberResponseDTO.MyReviewListDTO.builder()
                    .reviewList(reviewDTOList)
                    .listSize(reviewDTOList.size())
                    .totalPage(reviewPage.getTotalPages())
                    .totalElements(reviewPage.getTotalElements())
                    .isFirst(reviewPage.isFirst())
                    .isLast(reviewPage.isLast())
                    .build();
        }
}
