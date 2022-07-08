package main.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="riights")
public class Right {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rightss")
    String right;

    @Override
    public String toString() {
        return "Right{" +
                "id=" + id +
                ", right='" + right + '\'' +
                '}';
    }
}
