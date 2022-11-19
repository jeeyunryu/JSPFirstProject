package com.example.common;

import com.example.bean.BoardVO;
import com.example.dao.BoardDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUpload {
    public BoardVO uploadPhoto(HttpServletRequest request) {
        String filename = "";
        int sizeLimit = 15 * 1024 * 1024;

        String realPath = request.getServletContext().getRealPath("upload");

        File dir = new File(realPath);
        if(!dir.exists()) dir.mkdirs();

        BoardVO one = null;
        MultipartRequest multipartRequest = null;
        try {
            multipartRequest = new MultipartRequest(request, realPath, sizeLimit,"utf-8", new DefaultFileRenamePolicy());
            filename = multipartRequest.getFilesystemName("albumPhoto");

            one = new BoardVO();
            String sid = multipartRequest.getParameter("songID");
            if(sid!=null && !sid.equals("")) one.setSongID(Integer.parseInt(sid));
            one.setTitle(multipartRequest.getParameter("title"));
            one.setSinger(multipartRequest.getParameter("singer"));
            one.setAlbumTitle(multipartRequest.getParameter("albumTitle"));
            one.setReleasedDate(multipartRequest.getParameter("releasedDate"));
            one.setRanking(Integer.parseInt(multipartRequest.getParameter("ranking")));
            one.setRunningTime(multipartRequest.getParameter("runningTime"));
            one.setSongWriter(multipartRequest.getParameter("songWriter"));
            one.setLyrics(multipartRequest.getParameter("lyrics"));
            
            if(sid !=null && !sid.equals("")) {
                BoardDAO dao = new BoardDAO();
                String oldfilename = dao.getPhotoFileName(Integer.parseInt(sid));
                if(filename!=null && oldfilename!=null)
                    FileUpload.deleteFile(request, oldfilename);
                else if(filename==null && oldfilename!=null)
                    filename = oldfilename;
            }
            one.setAlbumPhoto(filename);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return one;
    }

    public static void deleteFile(HttpServletRequest request, String filename) {
        String filePath = request.getServletContext().getRealPath("upload");

        File f = new File(filePath + "/" + filename);
        if(f.exists()) f.delete();
    }
}
