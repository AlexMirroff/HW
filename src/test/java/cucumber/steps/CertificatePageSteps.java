//package cucumber.steps;
//
//import com.ithillel.pages.CertificatePage;
//import io.cucumber.java.Transpose;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//import java.util.Map;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//public class CertificatePageSteps extends UIStep {
//
//    CertificatePage page = null;
//    // Page page = null;
//
//
//    @Given("I am on {word} page")
//    public void openPage(String pageName) {
//        if (pageName.equals("Certificate")) page = new CertificatePage(driver);
//        else throw new IllegalArgumentException("Invalid page type provided" + pageName);
//        page.open();
//    }
//
//    @Then("I can see Certificate input field")
//    public void verifyCertificateInputField() {
//        assertThat((page.getCertificateInput().isDisplayed())).isTrue();
//    }
//
//    @When("I fill out the following parameters:")
//    public void iFillOutTheFollowingParameters(@Transpose Map<String, String> params) {
//        page.checkCertificate(params.get("number"));
//    }
//
//    @Then("Certificate not found")
//    public void CertificateNotFound() {
//        assertThat(page.getCertificateCheckMsg().
//                getText().
//                equals("Сертификат не найден")).
//                isTrue();
//    }
//}
