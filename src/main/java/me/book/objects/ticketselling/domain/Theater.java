package me.book.objects.ticketselling.domain;

/**
 * @author Minhyuk Yoon (ymh92730@gmail.com)
 * @since 2019-06-23
 */
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
