package hibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Entity
@Table(name = "users")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter @Setter
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @NonNull private String firstName;

   @NonNull private String lastName;

   @Column(unique = true)
   @NonNull private String email;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return Objects.equals(getId(), user.getId())
              && Objects.equals(getEmail(), user.getEmail());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getId(), getEmail());
   }
}
