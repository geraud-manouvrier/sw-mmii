package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.ParFeriado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ParFeriadoDao extends JpaRepository<ParFeriado, LocalDate> {

  public List<ParFeriado> findAllByOrderByIdDesc();
  public Optional<ParFeriado> findById(LocalDate id);
  public ParFeriado save(ParFeriado parFeriado);

  @Modifying
  @Transactional
  @Query(value = "UPDATE public.par_feriado SET es_habil_pershing = NOT es_habil_pershing WHERE dia = :dia", nativeQuery = true)
  void toggleFeriadoPershing(@Param("dia") LocalDate dia);

  @Modifying
  @Transactional
  @Query(value = "UPDATE public.par_feriado SET es_habil_stonex = NOT es_habil_stonex WHERE dia = :dia", nativeQuery = true)
  void toggleFeriadoStonex(@Param("dia") LocalDate dia);


}