package com.tps.prestamo.repository;
import com.tps.prestamo.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo,Long> {

}