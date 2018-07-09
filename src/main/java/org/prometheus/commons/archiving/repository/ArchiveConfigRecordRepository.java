package org.prometheus.commons.archiving.repository;

import org.prometheus.commons.archiving.domain.ArchiveConfigRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArchiveConfigRecordRepository extends MongoRepository<ArchiveConfigRecord, String> {

    ArchiveConfigRecord findByEmail(String email);
    public ArchiveConfigRecord findByFirstName(String firstName);
    public List<ArchiveConfigRecord> findByLastName(String lastName);
}
