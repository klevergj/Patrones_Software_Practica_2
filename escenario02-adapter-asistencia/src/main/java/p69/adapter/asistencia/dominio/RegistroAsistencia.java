package p69.adapter.asistencia.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

/** Información normalizada que espera el sistema institucional. */
public record RegistroAsistencia(String idColaborador, LocalDate fecha,
                                 LocalTime horaIngreso, LocalTime horaSalida) { }
