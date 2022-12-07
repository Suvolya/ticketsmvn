package ru.netology.ticketsrepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ticketsmvn.Ticket;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(11, 1000, "LED", "CAN", 540);
    Ticket ticket2 = new Ticket(801, 1500, "LED", "CKZ", 240);
    Ticket ticket3 = new Ticket(157, 800, "LED", "BUG", 600);

    @Test
    public void testRepositorySave() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRepositoryRemoveById() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.removeById(11);

        Ticket[] expected = {ticket2, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRepositoryEmptyTicket() {
        TicketRepository repo = new TicketRepository();

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRepositoryNotEmptyTicket() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }
}
