package com.sisdis.tugas2;

import com.sisdis.tugas2.Representation.ImageFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by MartinOenang on 9/30/2015.
 */

@Path(value = "/tugas2/server")
@Produces(MediaType.APPLICATION_JSON)
public class ImageServerResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServerResource.class);

    public ImageServerResource() {}


    @GET
    @Path("/{fileName}")
    public Response getFileinfo(@PathParam("fileName") String fileName) {
        LOGGER.info("filename : " +fileName);
        byte[] base64ByteArray = new byte[102400];
        String path = "C:\\"+fileName;
        File input = new File(path);
        BufferedImage buffImage = null;
        String isiBerkas = "";
        String ukuran = "";
        try {
            buffImage = ImageIO.read(input);
            if (buffImage != null) {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ImageIO.write(buffImage, "png", os);
                String data = (new BASE64Encoder()).encode(os.toByteArray());
                isiBerkas = data;
                ukuran = input.length()/1024+" KB";
                return Response.ok(new ImageFile(isiBerkas, path, ukuran)).build();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
