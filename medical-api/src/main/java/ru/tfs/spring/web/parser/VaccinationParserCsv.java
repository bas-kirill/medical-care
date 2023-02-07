package ru.tfs.spring.web.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.tfs.spring.web.exception.CsvParsingException;
import ru.tfs.spring.web.model.csv.VaccinationCsv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
public class VaccinationParserCsv implements VaccinationParser {

    @Override
    public List<VaccinationCsv> parse(MultipartFile file) {
        if (file.isEmpty()) {
            throw new CsvParsingException("File is empty!");
        } else {
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                CsvToBean<VaccinationCsv> csvToBean = new CsvToBeanBuilder<VaccinationCsv>(reader)
                        .withType(VaccinationCsv.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                return csvToBean.parse();
            } catch (Exception ex) {
                throw new CsvParsingException("An error occurred while processing the CSV file.");
            }
        }
    }
}
