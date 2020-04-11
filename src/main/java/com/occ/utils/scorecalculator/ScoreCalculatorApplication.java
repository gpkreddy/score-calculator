package com.occ.utils.scorecalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScoreCalculatorApplication implements CommandLineRunner{

	private static Logger LOG = LoggerFactory.getLogger(ScoreCalculatorApplication.class);

	@Autowired
	private ScoreCalculatorService scoreCalculatorService;

	public static void main(final String[] args) {
		LOG.info("Starting the Score Calculator program");
		SpringApplication.run(ScoreCalculatorApplication.class, args);
		LOG.info("End of Score Calculator Program");
	}

	@Override
	public void run(final String... args) throws Exception {
		
		LOG.info("in run method");

	}

}
