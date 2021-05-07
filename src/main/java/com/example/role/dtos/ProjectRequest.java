package com.example.role.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectRequest {
    private Long id;
    private String projectName;
    private String projectDescription;

}
