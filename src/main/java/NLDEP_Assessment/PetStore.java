package NLDEP_Assessment;




public class PetStore {

     String serviceBaseUrl;

    public PetStore(String petstoreType){


        if(petstoreType.equals("real"))
        {

              getURL(); //online implementation

        }else{

            serviceBaseUrl =" http://localhost:8889/";   //wiremock implementation
        }
        

    }



    public String getURL(){

        serviceBaseUrl ="https://petstore.swagger.io/";

        return serviceBaseUrl;
    }





}
