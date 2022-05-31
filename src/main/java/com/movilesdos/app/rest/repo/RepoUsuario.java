package com.movilesdos.app.rest.repo;
import com.movilesdos.app.rest.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUsuario extends JpaRepository<Usuario, Long> {
    // Usuario findById(int id);
}
