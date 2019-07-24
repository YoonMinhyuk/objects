package me.book.objects.theater_data_focus.domain;

import lombok.Getter;
import lombok.Setter;
import me.book.objects.theater.global.model.Money;

@Getter
@Setter
public class Reservation {
    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
