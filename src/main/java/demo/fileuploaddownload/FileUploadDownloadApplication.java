package demo.fileuploaddownload;

import demo.fileuploaddownload.config.AerospikeConfig;
import demo.fileuploaddownload.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class, AerospikeConfig.class
})
public class FileUploadDownloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadDownloadApplication.class, args);
	}
}