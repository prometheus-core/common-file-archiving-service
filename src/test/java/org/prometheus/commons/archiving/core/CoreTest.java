package org.prometheus.commons.archiving.core;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.prometheus.commons.archiving.domain.ArchiveConfigRecord;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoreTest {

    private boolean linuxPlatform;


    C:/users
    C:\\users


    c:\users

    @Test
    public void testSourcePathPlaceholderDetection(){

    }

    @Test
    public void testSayHello(){
        assertEquals("Ladislav",new ArchiveUtil().sayHello());
    }

    @Test
    public void testWholeArchivingProcess(){
        ArchiveConfigRecord archiveConfigRecord = new ArchiveConfigRecord();
        archiveConfigRecord.setArchiveFolder("C:\\Users\\myself\\06-Day ahead\\DA reports\\$YYYY\\$MM");
        archiveConfigRecord.setFileMask("yyyyMM.._50HzT_pra.xls");


    }
}
