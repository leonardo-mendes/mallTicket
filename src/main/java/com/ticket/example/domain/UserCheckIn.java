package com.ticket.example.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "user_check_in")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCheckIn implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
