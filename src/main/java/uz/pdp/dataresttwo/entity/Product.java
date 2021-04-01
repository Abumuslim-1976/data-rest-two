package uz.pdp.dataresttwo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    @OneToOne
    private Attachment photo;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Basket basket;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Property property;

    @ManyToOne
    private Order order;

}
