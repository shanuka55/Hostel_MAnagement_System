package lk.ijse.hostelManagementSystem.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student {
   @Id
    private String Id;
    private String name;
    private String address;
    private int contact;
    private String dob;
    private String gender;
}
