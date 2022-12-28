package rca.risbo.springbootrestcontrollertutorial.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private Long id;
    private String model;
    private String brand;
    private Integer horses;
    private Double price;

}
