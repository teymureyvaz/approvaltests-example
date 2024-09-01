package com.example;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class JsonPlaceholderApiTests {

    @Test
    public void testGetUserBody() {
        JsonPlaceholderApi api = new JsonPlaceholderApi("users/1");
        api.get().then().statusCode(200);
        Approvals.verify(api.getBody());
    }

    @Test
    public void testGetUserFullResponse() {
        JsonPlaceholderApi api = new JsonPlaceholderApi("users/1");
        api.get();
        Approvals.verify(api.getFullResponse(true));
    }
}
