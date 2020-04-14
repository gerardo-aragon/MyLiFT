package base;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

import java.net.MalformedURLException;
import java.net.URL;

public class TestLink {
    private String testLinkUrl = "https://testlink.i.edify.cr/lib/api/xmlrpc/v1/xmlrpc.php";
    private String testLinkKey = "5bc6be9069683ebec0ea4225f4bfd331";
    public TestLinkAPI testLinkAPI;
    private TestProject testProject;
    private TestPlan testPlan;
    private Build latestBuild;
    private String testSuite;
    private String testCasePath;
    private String platform;

    public TestLink(String projectName, String planName){
        this.testLinkAPI = connection();
        this.testProject = testLinkAPI.getTestProjectByName(projectName);
        this.testPlan = testLinkAPI.getTestPlanByName(planName, testProject.getName());
        this.latestBuild = testLinkAPI.getLatestBuildForTestPlan(testPlan.getId());
    }

    public TestLinkAPI connection(){

        URL url;
        TestLinkAPI testLinkAPI = null;
        try {

            url = new URL(testLinkUrl);
            testLinkAPI = new TestLinkAPI(url, testLinkKey);

        } catch (MalformedURLException | TestLinkAPIException e) {
            e.printStackTrace(System.err);
        }
        return testLinkAPI;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setTestSuite(String testSuite) {
        this.testSuite = testSuite;

    }

    public String getTestSuite() {
        return testSuite;
    }

    public String getTestCasePath() {
        return testCasePath;
    }

    public void setTestCasePath(String testCasePath) {
        this.testCasePath = testCasePath;
    }

    public void setTestCaseStatus(String testCaseName, ExecutionStatus status){
        int testCaseID = testLinkAPI.getTestCaseIDByName(testCaseName, "",
                testProject.getName(), testCasePath + testCaseName);
        testLinkAPI.setTestCaseExecutionResult(testCaseID, null, testPlan.getId(),
                status, latestBuild.getId(), latestBuild.getName(), "", null,
                null, null, platform, null, null);
    }

}
