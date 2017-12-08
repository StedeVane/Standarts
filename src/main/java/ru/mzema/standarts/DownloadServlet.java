package ru.mzema.standarts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
     //   super.doGet(req, response);
        // тип данных, которые вы отправляете
        // например application/pdf, text/plain, text/html, image/jpg
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition","attachment; filename=file.pdf");

        // файл, который вы отправляете
        File my_file = new File("E:\\Git\\Standarts\\file.pdf");

        // отправить файл в response
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(my_file);

        byte[] buffer = new byte[4096];
        int length;

        while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }

        // освободить ресурсы
        in.close();
        out.flush();
    }


}
