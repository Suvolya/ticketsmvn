package ru.netology.ticketsmvn;

import ru.netology.ticketsrepository.TicketRepository;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;


    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (ticket.getDepartureAirport().equalsIgnoreCase(from) && ticket.getArrivalAirport().equalsIgnoreCase(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] showOffers() {
        Ticket[] result = repo.getTickets();
        Arrays.sort(result);
        return result;
    }
}

