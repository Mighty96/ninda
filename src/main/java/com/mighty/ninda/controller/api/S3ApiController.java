package com.mighty.ninda.controller.api;

import com.mighty.ninda.config.auth.LoginUser;
import com.mighty.ninda.config.auth.dto.CurrentUser;
import com.mighty.ninda.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class S3ApiController {

    private final S3Service s3Service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping("/api/upload")
    public String upload(@LoginUser CurrentUser user, MultipartHttpServletRequest multipartFile, HttpServletResponse response) throws IOException {

        MultipartFile file = multipartFile.getFile("upload");
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        String fileUrl = s3Service.upload(file, fileName, "temp/" + user.getId().toString() + "/");
        PrintWriter printWriter = response.getWriter(); // 서버로 파일 전송 후 이미지 정보 확인을 위해 filename, uploaded, fileUrl 정보를 response 해주어야 함
        printWriter.println("{\"filename\" : \"" + fileName + "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}");
        printWriter.flush();

        return null;
    }

}
