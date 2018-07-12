package org.prometheus.commons.archiving.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.prometheus.commons.archiving.domain.ArchiveConfigRecord;
import org.prometheus.commons.archiving.domain.ArchiveProcessRecord;
import org.prometheus.commons.archiving.domain.PathPlaceholder;

import java.util.ArrayList;
import java.util.List;

/**
 * Low level API class
 */
@AllArgsConstructor
@Data
@Log4j2
public class ArchiveUtil {

    /**
     * sourcePath sample: C:\Users\myself\06-Day ahead\DA reports\$YYYY\$MM
     * you start processing: C:\Users\myself\06-Day ahead\DA reports\
     * you will look only for YEAR, so if there folders like this:
     * - somefolder
     * - 2011
     *
     *
     */

    private ArchiveConfigRecord archiveConfigRecord;

    private List<String> sourcePathSplit;
    private String sourcePathWithoutPlaceholders;




    /**
     * Here will be stored all subdirectories detected to lowest level
     * Examples:
     *
     * C:\Users\myself\06-Day ahead\DA reports\2015\01
     * C:\Users\myself\06-Day ahead\DA reports\2015\02
     * C:\Users\myself\06-Day ahead\DA reports\2015\03
     * ...
     * C:\Users\myself\06-Day ahead\DA reports\2018\06
     */
    private List<String> allSourcePaths;





    /**
     * Dummy function for JUnit5 unit testing
     * @return
     */
    public String sayHello(){
        return "Hello";
    }

    /**
     * Used to
     * @param path
     * @return
     */
    private List<String> splitFolderPath(String path){
        List<String> pathSplit = new ArrayList<>();
        // TODO

        return pathSplit;
    }

    // Every sourcePath should be checked it exists


    /**
     * This will process one ArchiveRecord object -
     */
    public void process(){
        // First we split source path
        this.sourcePathSplit = splitFolderPath(archiveConfigRecord.getSourcePath());


        // Create a full list of all subfolders on the lowest level
        this.allSourcePaths = createAllSourcePaths(archiveConfigRecord.getSourcePath());




    }

    private List<String> createAllSourcePaths(String string) {
        String sourcePathWithoutPathPlaceholder;
        // TODO

        return new ArrayList<>();

    }

    private String getSourcePathWithoutPathPlaceholder(@NonNull String sourcePath) {
        StringBuffer sourcePathWithoutPathPlaceholder = null;
        for (String pathSplit : sourcePathSplit){
            if (
                    !PathPlaceholder.$YYYY.getPathPlaceholderString().equals(pathSplit)
                &&
            !PathPlaceholder.$MM.getPathPlaceholderString().equals(pathSplit)){
                sourcePathWithoutPathPlaceholder.append(pathSplit);
            }

        }
        return  sourcePathWithoutPlaceholders.toString();
    }

    public void doArchive(List<ArchiveProcessRecord> archiveProcessRecords){
        // iterate archiveProcessRecords


    }

    public void compressFolder(){

    }

    public void addFileToArchiveFile(){}

}
