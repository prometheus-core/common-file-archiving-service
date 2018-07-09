package org.prometheus.commons.archiving;

import org.prometheus.commons.archiving.repository.ArchiveConfigRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonFileArchivingService {

        @Autowired
        private ArchiveConfigRecordRepository repository;

        public static void main(String[] args) {
            SpringApplication.run(CommonFileArchivingService.class, args);
        }
}
