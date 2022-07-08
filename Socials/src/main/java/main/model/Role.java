package main.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(length = 100)
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="roles_to_rights")

    private Set<Right> accessList=new HashSet<>();

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", accessList=" + accessList +
                '}';
    }

    public void addRight(Right right) {this.accessList.add(right);}
}
