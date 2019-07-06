package me.book.objects.theater.domain;

import me.book.objects.theater.global.model.Money;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
