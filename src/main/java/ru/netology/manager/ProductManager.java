package ru.netology.manager;


import ru.netology.domain.Ticket;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;
import java.util.Comparator;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket product) {
        repository.save(product);
    }

    public Ticket[] getAll() {
        return repository.findAll();
    }

    public Ticket[] searchBy(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket product : repository.findAll()) {
            if (product.matches(from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        System.out.println("После сортировки осталось " + result.length + " билета.");
        return result;
    }


}