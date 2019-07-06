package me.book.objects.theater.domain;

import me.book.objects.theater.global.model.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private List<DiscountCondition> conditions;

    DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.setConditions(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition discountCondition : conditions) {
            if (discountCondition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(Screening screening);

    private void setConditions(DiscountCondition... conditions) {
        if (Objects.isNull(conditions)) this.conditions = new ArrayList<>();
        this.conditions = Arrays.asList(conditions);
    }
}
