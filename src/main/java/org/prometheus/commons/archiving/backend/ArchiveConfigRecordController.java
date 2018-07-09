package org.prometheus.commons.archiving.backend;

import lombok.extern.log4j.Log4j2;
import org.prometheus.commons.archiving.domain.ArchiveConfigRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/archiveConfigRecords")
@Log4j2
public class ArchiveConfigRecordController {

    @Autowired
    ArchiveConfigRecordRepository archiveConfigRecordRepository;


    /**
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ArchiveConfigRecord> getAllUsers() {
        log.info("Getting all archive recoreds.");
        return archiveConfigRecordRepository.findAll();
    }

    /**
     *
     * @param businessName
     * @return
     */
    @RequestMapping(value = "/{businessName}", method = RequestMethod.GET)
    public Optional<ArchiveConfigRecord> getArchiveConfigRecordByBusinessName(@PathVariable String businessName) {
        log.info("Getting archive config with businessName: {}.", businessName);
        return archiveConfigRecordRepository.findById(businessName);
    }
}
