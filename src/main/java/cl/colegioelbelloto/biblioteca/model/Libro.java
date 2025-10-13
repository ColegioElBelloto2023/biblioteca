package cl.colegioelbelloto.biblioteca.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ⚡ genera el ID en la BD
    private Long idLibro;
    @NonNull
    private String titulo;
    @NonNull
    private String autor;
    @NonNull
    @Column(unique = true) // para que no se repitan
    private String isbn;
    private Integer anioPublicacion;
    private Integer stock;
}
