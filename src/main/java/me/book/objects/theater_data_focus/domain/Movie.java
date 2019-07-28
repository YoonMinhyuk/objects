package me.book.objects.theater_data_focus.domain;

import lombok.Getter;
import lombok.Setter;
import me.book.objects.theater.global.model.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) throw new IllegalArgumentException();
        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountFee() {
        if (movieType != MovieType.NONE_DISCOUNT) throw new IllegalArgumentException();
        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreend, int sequence) {
        for (DiscountCondition discountCondition : discountConditions) {
            if (discountCondition.getType() == DiscountConditionType.PERIOD) {
                if (discountCondition.isDiscountable(whenScreend.getDayOfWeek(), whenScreend.toLocalTime())) {
                    return true;
                }
            }

            if (discountCondition.isDiscountable(sequence)) {
                return true;
            }
        }

        return false;
    }
}
