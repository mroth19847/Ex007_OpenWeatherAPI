/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import BL.DataClasses.Destination;
import BL.Responses.ForecastResponse;
import BL.Responses.OpenWeatherResponse;
import java.util.Arrays;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author ROTHWANGLMaximilian
 */
@RunWith(value = Parameterized.class)
public class OpenWeatherAPIHandlerTest {
    
        
    @Parameter(value = 0)
    public String cityName;
    @Parameter(value = 1)
    public String expected;
    @Parameters(name = "{0}:")
    public static Iterable<Object[]> data1(){
        return Arrays.asList(new Object[][]{
            {"asdfa3q14", "failure"},
            {"Berlin", "success"},
            {"New York", "success"},
            {"20937584znoaiw", "failure"}
        });
    }
    
    public OpenWeatherAPIHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }
    
    @BeforeClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentInformation method, of class OpenWeatherAPIHandler.
     */
    @Test
    public void testGetCurrentInformation() throws Exception {
        System.out.println("getCurrentInformation");
        Destination dest = new Destination(cityName, "");
        String result = "success";
        try{
            OpenWeatherResponse obj = OpenWeatherAPIHandler.getCurrentInformation(dest);            
        }
        catch(Exception ex){
            result = "failure";
        }
        assertEquals(expected, result);
    }

    /**
     * Test of getForecast method, of class OpenWeatherAPIHandler.
     */
    @Test
    public void testGetForecast() throws Exception {
        System.out.println("getForecast");
        Destination dest = new Destination(cityName, "");
        String result = "success";
        try{
            ForecastResponse obj = OpenWeatherAPIHandler.getForecast(dest);            
        }
        catch(Exception ex){
            result = "failure";
        }
        assertEquals(expected, result);
    }
    
}
