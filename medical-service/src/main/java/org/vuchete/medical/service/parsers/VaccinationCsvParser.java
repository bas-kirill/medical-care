package org.vuchete.medical.service.parsers;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import org.vuchete.medical.service.dto.VaccinationCsvDto;

public class VaccinationCsvParser implements VaccinationParser {

  @Override
  public List<VaccinationCsvDto> parse(MultipartFile file) {
    return null;
  }
}
