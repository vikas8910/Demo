package demo.fileuploaddownload.repositories;

import demo.fileuploaddownload.model.BankMaster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankDetailsRepository extends CrudRepository<BankMaster,String> {
    BankMaster findByBankName(String bankName);
    BankMaster findByCity(String city);
    List<BankMaster> findByLastname(String lastname);
    long countByCity(String city);
}
