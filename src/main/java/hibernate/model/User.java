package hibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Entity
@Table(name = "users")
@Getter @Setter
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column
   private String firstName;

   @Column
   private String lastName;

   @Column
   private String email;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      User user = (User) obj;
      return Objects.equals(getEmail(), user.getEmail());

   }

   @Override
   public int hashCode() {
      return Objects.hash(getEmail());
   }
}
