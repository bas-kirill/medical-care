package ru.tfs.spring.web.model.csv;

import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationCsv {

    private String fullName;
    private String passportNumber;
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate vaccinationDate;

    private Long vaccineId;
    private String vaccineName;

    private Long vaccinationPointId;
    private String vaccinationPointName;
    private String vaccinationPointCity;
    private String vaccinationPointAddress;
}
