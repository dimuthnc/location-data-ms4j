package org.dimuth.dataServices;

/**
 * Created by dimuth on 11/18/16.
 */
import org.json.JSONObject;
import org.wso2.msf4j.formparam.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.*;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 0.1
 */
@Path("/save")
public class SaveDataService {
    @GET
    @Path("/get/hello")
    public String getHello() {




        return "Hello";



    }



}
