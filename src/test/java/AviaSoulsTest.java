import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    TicketTimeComparator ticketComparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Мурманск", "Москва", 5_000, 17, 20);
    Ticket ticket2 = new Ticket("Москва", "Сочи", 7_000, 16, 19);
    Ticket ticket3 = new Ticket("Екатеринбург", "Челябинск", 10_000, 11, 13);
    Ticket ticket4 = new Ticket("Калуга", "Воронеж", 7_000, 16, 17);
    Ticket ticket5 = new Ticket("Москва", "Сочи", 12_000, 12, 16);
    Ticket ticket6 = new Ticket("Москва", "Владивосток", 13000, 6, 15);

    @Test
    public void shouldSearchAndSortByPriceIfExist() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket2, ticket5};
        Ticket[] actual = manager.search("Москва", "Сочи");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchIfNoTickets() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchIfOneTicket() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("Калуга", "Воронеж");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchAndSortByPriceIfTicketsExistUsingComparator() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket2, ticket5};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Сочи", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotSearchIfNoTicketsUsingComparator() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket6);
        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Сочи", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchOneTicketUsingComparator() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.searchAndSortBy("Мурманск", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}

