package demo.fileuploaddownload.service;

import demo.fileuploaddownload.model.BankMaster;
import demo.fileuploaddownload.property.FileStorageProperties;
import demo.fileuploaddownload.repositories.BankDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
@Service
public class FileStorageImpl implements FileStorage {

    private final Path fileStorageLocation;
    private final Path fileStorageRelLocation;

    @Autowired
    BankDetailsRepository bankDetailsRepository;

    @Autowired
    public FileStorageImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageRelLocation = Paths.get(fileStorageProperties.getUploadDir())
                .normalize();
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath()
                .normalize();
    }

    @Override
    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.");
        }
    }

    @Override
    public List<BankMaster> getBankDtls() {

        log.info("getBankDtls");

        bankDetailsRepository.save(new BankMaster("SBI","SBI","MUMBAI","ASAS"));
        bankDetailsRepository.save(new BankMaster("HDFC","HDFC","DELHI","JKJK"));

        Optional<BankMaster> data = bankDetailsRepository.findById("SBI");
        log.info("data:{}",data);

        bankDetailsRepository.deleteById("lkaks");
        log.info("deleted lkaks:{}");

        Optional<BankMaster> findById = bankDetailsRepository.findById("lkaks");
        log.info("findById lkaks:{}",findById);

        //Iterable<BankMaster> findAll = bankDetailsRepository.findAll();
        //log.info("data1:{}",findAll);

        //BankMaster data1 = bankDetailsRepository.findByCity("mumbai");
        //log.info("findByCity:{}",data1);

        //List<BankMaster> result = (List<BankMaster>) bankDetailsRepository.findAll();
        //log.info("result:{}",result);

        String bankName = "SBI";
        BankMaster findByBankName = bankDetailsRepository.findByBankName(bankName);
        log.info("findByBankName:{}",findByBankName);

        log.info("bankDetailsRepository.count()",bankDetailsRepository.countByCity("DELHI"));

        //List<BankMaster> findByLastname = bankDetailsRepository.findByLastname("ioo");
        //log.info("findByBankName",findByLastname);

        return  null;
    }

}