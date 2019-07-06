package me.book.objects.theater.domain;

import me.book.objects.theater.global.model.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
