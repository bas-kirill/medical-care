package ru.tfs.spring.web.parser;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.tfs.spring.web.model.csv.VaccinationCsv;

import java.util.List;

@Component
public interface VaccinationParser {
    List<VaccinationCsv> parse(MultipartFile file);
}
