package org.prometheus.commons.archiving.backend;

import org.prometheus.commons.archiving.domain.ArchiveConfigRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveConfigRecordRepository extends MongoRepository<ArchiveConfigRecord, String> {

        /*
        @Override
        ArchiveConfigRecord findOne(String id);

        @Override
        void delete(ArchiveConfigRecord deleted);
        */
}

