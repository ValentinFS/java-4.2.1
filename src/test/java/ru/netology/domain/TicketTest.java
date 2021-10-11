package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    private Ticket ticket1 = new Ticket(1, 1000, "VKO", "KJA", 456);
    private Ticket ticket2 = new Ticket(2, 3000, "SVO", "BTK", 400);
    private Ticket ticket3 = new Ticket(3, 7000, "VKO", "KJA", 387);
    private Ticket ticket4 = new Ticket(4, 6000, "SVO", "BTK", 387);
    private Ticket ticket5 = new Ticket(5, 5000, "VKO", "KJA", 387);
    private Ticket ticket6 = new Ticket(6, 2000, "DME", "MMK", 387);


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
        Ticket[] expected = new Ticket[]{ticket1, ticket5, ticket3};
        Ticket[] actual = manager.searchBy("VKO", "KJA");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetByFromDmeToMmk() {
        Ticket[] expected = new Ticket[]{ticket6};
        Ticket[] actual = manager.searchBy("DME", "MMK");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetByFromSvoToBtk() {
        Ticket[] expected = new Ticket[]{ticket2, ticket4};
        Ticket[] actual = manager.searchBy("SVO", "BTK");

        assertArrayEquals(expected, actual);
    }

}