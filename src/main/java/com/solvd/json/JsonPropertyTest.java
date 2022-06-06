//package com.solvd.json;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.solvd.entities.Band;
//import org.junit.Test;
//
//import java.io.IOException;
//
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
//
//public class JsonPropertyTest {
//
//    @Test
//    public final void serializing(){
//        Band band = new Band(5, 2,"ThaCooglers");
//        try {
//            String result = new ObjectMapper().writeValueAsString(band);
//            assertThat(result, containsString("5"));
//            assertThat(result,containsString("2"));
//            assertThat(result,containsString("ThaCooglers"));
//
//            Band resultBand = new ObjectMapper().readerFor(Band.class).readValue(result);
//            assertEquals("1",);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
