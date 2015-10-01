package com.sisdis.tugas2;

import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by MartinOenang on 10/1/2015.
 */
@Path(value = "/tugas2/client")
@Produces(MediaType.TEXT_HTML)
public class ImageClientResource {
    public ImageClientResource() {}
    @GET
    @Path("/{name}")
    public Response showImage(@PathParam("name") String name){
        try {
            String url_ = "http://localhost:8080/tugas2/server/"+name;
            URL url = null;
            url = new URL(url_);
            InputStream is = url.openConnection().getInputStream();
            BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );
            String line = "";
            String line_temp;
            while( ( line_temp = reader.readLine() ) != null )  {
                line += line_temp;
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(line);
            String isiBerkas = (String) jsonObject.get("isi_berkas");
            String lokasiBerkas = jsonObject.getString("lokasi_berkas");
            String ukuranBerkas = jsonObject.getString("ukuran_berkas");
            return Response.ok("<img src='data:image/jpg;base64, "+isiBerkas+"' /><br>" +
                    "Lokasi pada server : " + lokasiBerkas + "<br>" +
                    "Ukuran : " + ukuranBerkas).build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
