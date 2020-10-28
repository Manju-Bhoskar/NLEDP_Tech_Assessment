package NLEDP_Assessment;

import NLDEP_Assessment.PetStore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class StepDefinition<petname> {

    // Global variables defined
    String petStatus;
    int count;
    int total;
    String namePet;
    JsonPath avialablejson;
    private PetStore petStore;
     String petname;

    {
        petname = "doggie";
    }

    @Given("The (.*) petstore is running$")
    public void restassuredBaseURI(String petstoreType) {
        petStore= new PetStore(petstoreType);

    }


    @When("^user finds pets by status$")
    public void user_finds_pets_by_status() {


        petStatus=given().baseUri(petStore.getURL()).queryParam("status","available").
                when().get("v2/pet/findByStatus").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println("Details of all the data " +petStatus);
    }

//get the size of an array returning number of pets with status available

    @Then("the array size of available pets is returned")
    public void the_array_size_of_available_pets_is_returned() {


        avialablejson=new JsonPath(petStatus);
        count=avialablejson.getInt("petStatus.size()");

        System.out.println("Total number of pets with status available is " +count);

    }


    @And("the number of pets with status available and the name (.*)")
    public void the_number_of_pets_with_status_available_and_the_name_Doggie(petname)  {
        total=0;


        for (int i=0;i<count;i++)
        {
            namePet = avialablejson.get("["+i+"].name");

            if (namePet.equals(petname))
                total=total+1;

        }
        System.out.println("The total number of pet with name doggie is: " +total);
        assertTrue(total>1);
    }
}
