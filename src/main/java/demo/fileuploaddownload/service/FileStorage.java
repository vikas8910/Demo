package demo.fileuploaddownload.service;
import demo.fileuploaddownload.model.BankMaster;

import java.util.List;

public interface FileStorage {
    void init();
    List<BankMaster> getBankDtls();
  }
