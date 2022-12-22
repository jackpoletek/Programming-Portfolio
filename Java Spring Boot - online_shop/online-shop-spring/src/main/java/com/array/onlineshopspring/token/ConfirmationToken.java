//package com.array.onlineshopspring.token;
//
//import com.array.onlineshopspring.model.AppUser;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//public class ConfirmationToken {
//
//    @SequenceGenerator(
//            name = "confirmation_token_sequence",
//            sequenceName = "confirmation_token_sequence",
//            allocationSize = 1
//    )
//
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "confirmation_token_sequence"
//    )
//    private Integer id;
//    @Column(nullable = false)
//    private String token;
//    @Column(nullable = false)
//    private LocalDateTime localDateTime;
//    @Column(nullable = false)
//    private LocalDateTime expiresAt;
//    private LocalDateTime confirmedAt;
//    @ManyToOne // 1 User, MANY tokens
//    @JoinColumn(
//            nullable = false,
//            name = "user_id"
//    )
//    private AppUser user;
//
//    public ConfirmationToken(String token, LocalDateTime localDateTime,
//                             LocalDateTime expiresAt, AppUser user) {
//        this.token = token;
//        this.localDateTime = localDateTime;
//        this.expiresAt = expiresAt;
//        this.user = user;
//    }
//}
