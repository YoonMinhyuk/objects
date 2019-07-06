package me.book.objects.theater.domain;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
