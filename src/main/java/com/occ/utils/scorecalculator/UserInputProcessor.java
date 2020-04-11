/*
 * Copyright (c) ABC Inc. All rights reserved.  
 * Licensed under ABC Inc. See LICENSE file in the project root for full license information.  
 *   
 */

package com.occ.utils.scorecalculator;

import java.io.File;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/* created by Praveen Gajjala
 *  created on 4/11/2020
*/

@Service
public class UserInputProcessor {

    @Value("${file-path}")
    private String defaultFilePath;

    private static Logger LOG = LoggerFactory.getLogger(UserInputProcessor.class);

    public String readAndValidateInput(String... args) {
        String filePath = "";

        if (args.length > 0) {
            if (!isValidFile(args[0])) {
                LOG.info("File passed to the program is not valid. press enter to use the sample file or pass the correct file location : ");
                filePath = readFilePathFromUser();
            }
        } else {
            LOG.info("File path has not been passed to the program. Press enter to use the sample file or pass the correct file location : ");
            filePath = readFilePathFromUser();
        }

        if (filePath.trim().isEmpty() || !isValidFile(filePath)) {
            LOG.info("Passed in file is either not valid or empty. Using the sample file for calculation");
            filePath = this.defaultFilePath;
        }
        return filePath;
	}
	
	private boolean isValidFile(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    private String readFilePathFromUser() {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        scanner.close();
        return filePath.trim();
    }

}