    package entity;

    import enums.Priority;
    import enums.Status;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Size;
    import lombok.*;

    import java.time.LocalDate;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Size(min = 5, max = 100, message = "O titulo deve ter entre 5 e 150 caracteres")
        @NotNull(message = "O título é obrigatório")
        private String title;

        @Column(columnDefinition = "TEXT")
        private String description;

        @Enumerated(jakarta.persistence.EnumType.STRING)
        @NotNull(message = "O status é obrigatório")
        private Status status;

        @Enumerated(jakarta.persistence.EnumType.STRING)
        @NotNull(message = "A prioridade é obrigatória")
        private Priority priority;

        private LocalDate dueDate;

        @ManyToOne(optional = false)
        @JoinColumn(name = "project_id")
        private Project project;

    }
