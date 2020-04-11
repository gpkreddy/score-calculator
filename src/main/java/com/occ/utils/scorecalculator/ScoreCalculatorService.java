
/*
 * Copyright (c) ABC Inc. All rights reserved.  
 * Licensed under ABC Inc. See LICENSE file in the project root for full license information.  
 *   
 */

package com.occ.utils.scorecalculator;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/* created by Praveen Gajjala
 *  created on 4/11/2020
*/

@Service
public class ScoreCalculatorService {

    private static Logger LOG = LoggerFactory.getLogger(ScoreCalculatorService.class);
    private final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final char DOUBLE_QUOTE_CHAR = '"';
    private static final String COMMA = ",";

    /*
     * computes scores for a given file using First Name
     *
     * uses default file(names.txt) from resources if sent filePath is empty
     */
    public Long computeScoresByFirstName(final String filePath) throws Exception {

        Long finalScore = 0L;

        try {
            final List<String> sortedNames = getNamesFromFileAlphabetically(filePath);

            for (int i = 0; i < sortedNames.size(); i++) {
                finalScore += compute(sortedNames.get(i), i + 1);
            }

        } catch (final Exception e) {
            LOG.info(e.getMessage());
            throw e;
        }

        return finalScore;
    }

    /*
     * converts the csv file of names into a list and sorts the list alphabetically
     */
    private List<String> getNamesFromFileAlphabetically(final String file) throws Exception {
        FileInputStream inputStream = null;
        Scanner scanner = null;
        List<String> namesList;
        try {
            inputStream = new FileInputStream(file);
            scanner = new Scanner(inputStream, "UTF-8");
            namesList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                LOG.debug("Read Line is : " + line);
                namesList.addAll(getNamesFromLine(line));
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (scanner != null) {
                scanner.close();
            }
        }

        // sort names alphabetically
        Collections.sort(namesList);
        return namesList;
    }

    /*
     * converts a CSV line to list of strings by trimming double quotes
     */
    private List<String> getNamesFromLine(final String line) {
        final List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA);
            while (rowScanner.hasNext()) {
                String name = rowScanner.next().trim();
                name = StringUtils.trimLeadingCharacter(name, DOUBLE_QUOTE_CHAR);
                name = StringUtils.trimTrailingCharacter(name, DOUBLE_QUOTE_CHAR);
                values.add(name);
                LOG.debug(name);
            }
            rowScanner.close();
        }
        return values;
    }

    /*
     * Sums the alphabetical value of each letter and multiply the sume by the
     * name's position in the list
     */
    private Long compute(final String name, final long position) {
        Long sum = 0L;
        for (int i = 0; i < name.toUpperCase().length(); i++) {
            sum += ALPHABETS.indexOf(name.charAt(i)) + 1;
        }
        return sum * position;
    }

}