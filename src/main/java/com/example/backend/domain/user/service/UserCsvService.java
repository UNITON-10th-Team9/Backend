package com.example.backend.domain.user.service;

import com.example.backend.domain.user.model.User;
import com.example.backend.domain.user.model.repository.UserRepository;
import com.example.backend.global.csv.CsvHelper;
import com.example.backend.global.error.exception.CustomeException;
import com.example.backend.global.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCsvService {
    private final UserRepository userRepository;

    public void save(MultipartFile file) {
        try {
            List<User> tutorials = CsvHelper.csvToTutorials(file.getInputStream());
            userRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new CustomeException(ErrorCode.USER_CSV_EXCEPTION);
        }
    }
}
