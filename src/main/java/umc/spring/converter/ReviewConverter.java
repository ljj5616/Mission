package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.AddReviewDTO;

public class ReviewConverter {

    public static Review toEntity(AddReviewDTO dto, Member member, Store store) {
        return Review.builder()
                .body(dto.getContent())
                .score(dto.getScore())
                .member(member)
                .store(store)
                .build();
    }
}
