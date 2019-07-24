package me.book.objects.theater_data_focus.domain;

import lombok.Getter;
import lombok.Setter;
import me.book.objects.theater.global.model.Money;

import java.time.Duration;
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
}
