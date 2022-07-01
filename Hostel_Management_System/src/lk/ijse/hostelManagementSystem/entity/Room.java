package lk.ijse.hostelManagementSystem.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Room {
    @Id
    private String rId;
    private String roomType;
    private BigDecimal keyMoney;
}
