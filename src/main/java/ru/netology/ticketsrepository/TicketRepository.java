package ru.netology.ticketsrepository;

import ru.netology.ticketsmvn.Ticket;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket coupons) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = coupons;
        tickets = tmp;

    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket product : tickets) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] getTickets() {
        return tickets;
    }
}
