package com.shocial.shocial.repository;

import com.shocial.shocial.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Notice the interface class. A lot of Spring magic going on in here
// Sara: I'll need to study up on "Optional", for overview, it's a shortcut way to check for null cases,
//       need to dive into these a bit deeper.
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByUsernameAndPassword(String username, String password);
}
