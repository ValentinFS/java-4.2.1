package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    private Ticket ticket1 = new Ticket(1, 1000, "VKO", "KJA", 456);
    private Ticket ticket2 = new Ticket(2, 3000, "SVO", "BTK", 400);
    private Ticket ticket3 = new Ticket(3, 7000, "VKO", "KJA", 387);
    private Ticket ticket4 = new Ticket(4, 6000, "SVO", "BTK", 254);
    private Ticket ticket5 = new Ticket(5, 5000, "VKO", "KJA", 648);
    private Ticket ticket6 = new Ticket(6, 2000, "DME", "MMK", 791);
    TicketByPriceAscComparator comparator = new TicketByPriceAscComparator();

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldGetByFromVkoToKja() {


        Ticket[] expected = new Ticket[]{ticket3, ticket1, ticket5};
        Ticket[] actual = manager.searchBy("VKO", "KJA", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetByFromDmeToMmk() {
        Ticket[] expected = new Ticket[]{ticket6};
        Ticket[] actual = manager.searchBy("DME", "MMK", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetByFromSvoToBtk() {
        Ticket[] expected = new Ticket[]{ticket4, ticket2};
        Ticket[] actual = manager.searchBy("SVO", "BTK", comparator);

        assertArrayEquals(expected, actual);
    }

}