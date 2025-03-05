package com.kdr.CrediGo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Good practice to use since this is a Data Transfer Object (DTO)
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EmailDetails {
    private String recipient;
    private String messageBody;
    private String subject;
    private String attachment;

}
