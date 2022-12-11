package org.vuchete.medical.service.parsers;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.vuchete.medical.service.dto.VaccinationCsvDto;

@Component
public interface VaccinationParser {
  List<VaccinationCsvDto> parse(MultipartFile file);
}
