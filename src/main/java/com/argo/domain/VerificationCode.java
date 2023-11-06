package com.argo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YangY
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {
    private String phoneNo;
    private String code;
}
