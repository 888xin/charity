package com.lhx.charity.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class SaveFileUtil {

    public static String saveOneFile(MultipartFile oneFile){
        if(oneFile != null && !oneFile.isEmpty()) {

            String oldFileName = oneFile.getOriginalFilename();

            //String randomStr = UUID.randomUUID().toString().replaceAll("-", "");
            String randomStr = UUID.randomUUID().toString();

            randomStr = randomStr.split("-")[0];

            String newFileName = randomStr + Constants.SPLIT2 + oldFileName;
            File file = new File(newFileName);
            try {
                oneFile.transferTo(file);
                return newFileName;
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return null;
    }

    public static String saveOneFile2(MultipartFile oneFile){
        if(oneFile != null && !oneFile.isEmpty()) {
            String oldFileName = oneFile.getOriginalFilename();
            String randomStr = UUID.randomUUID().toString();
            String newFileName = randomStr + oldFileName.substring(oldFileName.lastIndexOf("."));
            File file = new File(newFileName);
            try {
                oneFile.transferTo(file);
                return newFileName;
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return null;
    }


    public static List<String> saveMoreFile(List<MultipartFile> moreFiles){
        List<String> result = new ArrayList<>();
        if (moreFiles != null && moreFiles.size() > 0) {
            for (MultipartFile oneFile : moreFiles) {
                String path = saveOneFile(oneFile);
                result.add(path);
            }
        }
        return result;
    }

}






