package me.book.objects.chap05.domain;

import me.book.objects.theater.global.model.Money;

import java.time.Duration;

public class AmountDiscountMovie extends Movie {
    private Money discountAmount;


    public AmountDiscountMovie(String title,
                               Duration runningTime,
                               Money fee,
                               Money discountAmount,
                               DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
