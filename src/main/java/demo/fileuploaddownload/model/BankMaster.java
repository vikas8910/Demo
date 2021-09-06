package demo.fileuploaddownload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

//@Document
@AllArgsConstructor
@Data
public class BankMaster {
    @Id
    private String bankId;
    private String bankName;
    private String city;
    private String lastname;
}
