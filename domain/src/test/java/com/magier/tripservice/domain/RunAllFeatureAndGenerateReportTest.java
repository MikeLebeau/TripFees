package com.magier.tripservice.domain;

import com.magier.tripservice.domain.cucumber.BDDRunnerTest;
import com.magier.tripservice.domain.reporting.PdfSimpleReport;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BDDRunnerTest.class})
public class RunAllFeatureAndGenerateReportTest {

    @AfterClass
    public static void generateExecutionReport() throws Exception {
        new PdfSimpleReport().generate();
    }
}
