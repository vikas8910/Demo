package demo.fileuploaddownload.controller;

import demo.fileuploaddownload.model.BankMaster;
import demo.fileuploaddownload.service.FileStorage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorage fileStorageService;

    @GetMapping("/getBankDtls")
    public List<BankMaster> getBankList() {
        return fileStorageService.getBankDtls();
    }

    
}
