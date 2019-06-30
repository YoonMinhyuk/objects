package me.book.objects.ticketselling.domain;

/**
 * @author Minhyuk Yoon (ymh92730@gmail.com)
 * @since 2019-06-23
 */
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
