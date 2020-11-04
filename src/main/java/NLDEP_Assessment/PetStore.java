package NLDEP_Assessment;

public class PetStore
{
     String serviceBaseUrl;
    public PetStore(String petstoreType)
    {
        if(petstoreType.equals("real"))
        {
            serviceBaseUrl ="https://petstore.swagger.io/";
        }else
            {
            serviceBaseUrl ="http://localhost:8889/";   //wiremock implementation
        }
    }

    public String getURL(){
        return serviceBaseUrl;
    }

}
