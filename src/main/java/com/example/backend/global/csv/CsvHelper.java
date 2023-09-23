package com.example.backend.global.csv;

import com.example.backend.domain.user.model.Position;
import com.example.backend.domain.user.model.User;
import com.example.backend.global.error.exception.CustomeException;
import com.example.backend.global.error.exception.ErrorCode;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {
    public static String TYPE = "text/csv";


    public static List<User> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<User> users = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                User user = User
                        .builder()
                        .name(csvRecord.get(0))
                        .email(csvRecord.get(1))
                        .phoneNumber(csvRecord.get(2))
                        .position(Position.valueOf(csvRecord.get(3)))
                        .organization(csvRecord.get(4))
                        .annual(Integer.parseInt(csvRecord.get(5)))
                        .build();

                users.add(user);
            }

            return users;
        } catch (IOException e) {
            throw new CustomeException(ErrorCode.USER_CSV_EXCEPTION);
        }
    }

}
