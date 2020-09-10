package pl.javastart.sellegro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auctions")
public class Auction {

    @Id
    private Long id;
    @Column(name = "carMake")
    private String carMake;
    @Column(name = "carModel")
    private String carModel;
    private String color;
    private BigDecimal price;
    @Column(name = "endDate")
    private LocalDate endDate;
}
