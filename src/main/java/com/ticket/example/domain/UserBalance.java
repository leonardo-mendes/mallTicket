package com.ticket.example.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "user_balance")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBalance implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "user_id")
    Integer userId;

    Double balance;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
