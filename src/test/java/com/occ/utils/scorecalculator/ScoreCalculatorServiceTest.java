package com.occ.utils.scorecalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(args = "src/main/resources/names.txt")
public class ScoreCalculatorServiceTest {

    @Autowired
    ScoreCalculatorService scoreCalculatorService;

    @Test
    public void testCompute(){
        Long score = scoreCalculatorService.compute("Praveen", 2);
        assertEquals(162, score);
    }

    @Test
    public void testGetNamesFromLine(){
        String sampleLine = "\"praveen\",\"Gajjala\", \"jack\"";
        List<String> namesList = scoreCalculatorService.getNamesFromLine(sampleLine);

        assertEquals(3,namesList.size());
        assertEquals("PRAVEEN",namesList.get(0));
    }

    @Test
    public  void testComputeScoresByFirstName() throws Exception {
        Long finalScore = scoreCalculatorService.computeScoresByFirstName("src/test/resources/names.txt");
        assertEquals(871198282, finalScore);
    }

}