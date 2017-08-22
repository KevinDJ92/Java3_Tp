package com.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.servlet.http.Part;

public class UploadImageMethod1 {
     public static void doUpload(Part image){
        try {
            InputStream in = image.getInputStream();
            
            byte[] imageBytes = null;
          
           File f = new File("/Users/Kevin/Documents/Java3_tp/web/upload/" + image.getSubmittedFileName());
           f.createNewFile();
           
           FileOutputStream out = new FileOutputStream(f);
           byte[] buffer = new byte[1024];
           int length;
           
           while ((length = in.read(buffer)) > 0){
               out.write(buffer, 0, length);
           }
           
           out.close();
           in.close();
           
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
