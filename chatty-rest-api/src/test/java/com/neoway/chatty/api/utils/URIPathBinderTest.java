package com.neoway.chatty.api.utils;

import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class URIPathBinderTest {

    @Test
    public void shouldReturnIdAtTheEndOfUrl() throws URISyntaxException {
        String id = "5aaf62a676df252c51cc632a";
        String path = "/users/" + id;
        assertEquals(path, URIPathBinder.resourceLocationBuilder(id).getPath());
    }

}
