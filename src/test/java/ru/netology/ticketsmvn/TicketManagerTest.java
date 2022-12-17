package ru.netology.ticketsmvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ticketsrepository.TicketRepository;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(11, 1000, "LED", "CAN", 540);
    Ticket ticket2 = new Ticket(801, 1500, "LED", "CKZ", 240);
    Ticket ticket3 = new Ticket(157, 800, "LED", "BUG", 600);
    Ticket ticket4 = new Ticket(233, 1300, "LED", "BUG", 600);

    @Test
    public void shouldFindOneTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findAll("LED", "CKZ");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindFewTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {ticket3, ticket4};
        Ticket[] actual = manager.findAll("LED", "BUG");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketsNoExists() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("BUG", "CKZ");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowOffers() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] expected = {ticket3, ticket1, ticket2};
        Ticket[] actual = manager.showOffers();

        Assertions.assertArrayEquals(expected, actual);

    }
}
