/*
 * Copyright (c) ABC Inc. All rights reserved.  
 * Licensed under ABC Inc. See LICENSE file in the project root for full license information.  
 *   
 */

package com.occ.utils.scorecalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* created by Praveen Gajjala
 *  created on 4/11/2020
*/

@SpringBootApplication
public class ScoreCalculatorApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(ScoreCalculatorApplication.class);

	@Autowired
	private ScoreCalculatorService scoreCalculatorService;

	@Autowired
	private UserInputProcessor userInputProcessor;

	public static void main(final String[] args) {
		LOG.info("Starting the Score Calculator program");
		SpringApplication.run(ScoreCalculatorApplication.class, args);
		LOG.info("End of Score Calculator Program");
	}

	@Override
	public void run(final String... args) throws Exception {
		String filePath = userInputProcessor.readAndValidateInput(args);
		LOG.info("File used for the calculation is : " + filePath);

	}

}
