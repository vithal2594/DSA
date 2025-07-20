package Prac.twoDimenstional;

public class new1 {
    @POST
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public void containerSink(@Context HttpHeaders header,
                                String body,
                                @Suspended final AsyncResponse asyncResponse,
                                @Context OperationContext operationContext) {

        CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException();
        })
            .thenAccept(__ -> asyncResponse.resume(Response.status(Response.Status.OK).build()));
    }
}
// volumetric
// jdk 
// scheduler -> 58Lakhs   SPN  30s 


// store migration  
// r1 1000 - r2 



// order-generator


// store-confiy

// fos

// bi

// om 

// order-reader
// oder-casnadraa

