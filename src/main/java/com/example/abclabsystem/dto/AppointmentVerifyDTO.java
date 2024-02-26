package com.example.abclabsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointmentVerifyDTO {
    private boolean confirm;
    private boolean nonConfirm;

}
