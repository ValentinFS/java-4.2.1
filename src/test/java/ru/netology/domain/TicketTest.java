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
    private Ticket ticket4 = new Ticket(4, 6000, "SVO", "SVX", 387);
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
    public void shouldSortById() {
        Ticket[] expected = new Ticket[]{ticket1, ticket6, ticket2, ticket5, ticket4, ticket3};
        Ticket[] actual = new Ticket[]{ticket3, ticket1, ticket2, ticket5, ticket4, ticket6};

        assertArrayEquals(expected,manager.getAll());

    }

    @Test
    public void shouldGetByFromTo() {



        Ticket[] expected = new Ticket[]{ticket1, ticket5, ticket3};
        Ticket[] actual = manager.searchBy("VKO", "KJA");

        Arrays.sort(actual, comporator);

        assertArrayEquals(expected, actual);

    }


}