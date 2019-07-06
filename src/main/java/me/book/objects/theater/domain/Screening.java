package me.book.objects.theater.domain;

import me.book.objects.theater.global.model.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime() {
        return this.whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return this.movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return Reservation.builder()
                .customer(customer)
                .screening(this)
                .fee(calculateFee(audienceCount))
                .audienceCount(audienceCount)
                .build();
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
