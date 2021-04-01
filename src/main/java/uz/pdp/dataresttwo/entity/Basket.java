package uz.pdp.dataresttwo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double price;

    private String total;

    private String quantity;

    @JsonIgnore
    @OneToMany(mappedBy = "basket",cascade = CascadeType.ALL)
    private List<Product> products;

}
