package com.solvd.metro.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCountService {

    private static final Logger logger = LogManager.getLogger(WordCountService.class);

    public void countUniqueWords(String inputPath, String outputPath) throws IOException {
        // read file using FileUtil
        String content = FileUtils.readFileToString(new File(inputPath), "UTF-8");

        // split into words using StringUtils
        String[] words = StringUtils.split(content.toLowerCase(), " \n\r\t.,!?;:\"'()-");

        // count unique words using HashSet
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        // result
        String result = "Total unique words: " + uniqueWords.size();
        logger.info(result);

        // write result to file using FileUtils
        FileUtils.writeStringToFile(new File(outputPath), result, "UTF-8");
        logger.info("Result written to: {}", outputPath);
    }
}