package io.github.jotamath.projetomensageria.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Message {
    private BigDecimal customerId;
    private String productId;
    private BigDecimal price;

    @Override
    public String toString() {
        return "Message{" +
                "customerId=" + customerId +
                ", productId='" + productId + '\'' +
                ", price=" + price +
                '}';
    }

}
