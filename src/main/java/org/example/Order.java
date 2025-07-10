package org.example;

import java.time.LocalDate;
import java.util.List;

public record Order(String id,
                    LocalDate date,
                    double totalAmount,
                    List<String> productIds) {
}
