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

   @NonNull private String email;

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
