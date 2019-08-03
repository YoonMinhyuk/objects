package me.book.objects.chap05.domain;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
