package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import com.lavasoft.GetCountryISO2ByName;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("193.106.40.57");
        System.out.println(ipLocation);
    }
}
