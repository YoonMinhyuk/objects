package me.book.objects.theater_data_focus.domain;

import lombok.Getter;
import lombok.Setter;
import me.book.objects.theater.global.model.Money;

import java.time.LocalDateTime;

@Getter
@Setter
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Money calculateFee(int audienceCount) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount);
                }
                break;
            case PERCENT_DISCOUNT:
                if (movie.isDiscountable(whenScreened, sequence))
                    return movie.calculatePercentDiscountFee().times(audienceCount);
                break;
            case NONE_DISCOUNT:
                return movie.calculateNoneDiscountFee().times(audienceCount);
        }
        return movie.calculateAmountDiscountedFee().times(audienceCount);
    }
}
