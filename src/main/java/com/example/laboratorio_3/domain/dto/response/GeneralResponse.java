package com.example.laboratorio_3.domain.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResponse<T> {
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private String path;
    private T data;
}
