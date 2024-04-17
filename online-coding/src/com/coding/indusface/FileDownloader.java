package com.coding.indusface;

/**
 * To use parallel processing with threads for downloading and moving files to multiple
 * destinations in Java, you can create a new thread for each file operation.
 * <p>
 * Here's an example using threads:
 */

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FileDownloader {
    public static void main ( String[] args ) {
        List<String> filesToDownload = new ArrayList<>();
        filesToDownload.add("https://example.com/file1.txt");
        filesToDownload.add("https://example.com/file2.txt");
        // Add more files to download as needed
        //   In this example, for each file to download, a new Thread is created to handle the
        //   download and move operations. The downloadAndMoveFile method is executed in each thread,
        //   allowing multiple files to be processed concurrently.
        List<Thread> threads = new ArrayList<>();

        for (String fileUrl : filesToDownload) {
            Thread thread = new Thread(() -> {
                try {
                    downloadAndMoveFile(fileUrl , "C:/Downloads" , "C:/Destination");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
//                The join method is used to wait for
                //   all threads to finish before the program exits.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void downloadAndMoveFile ( String fileUrl , String downloadPath , String destinationPath ) throws IOException {
        URL url = new URL(fileUrl);
        Path downloadFilePath = new File(downloadPath , getFileNameFromUrl(fileUrl)).toPath();
        Files.copy(url.openStream() , downloadFilePath , StandardCopyOption.REPLACE_EXISTING);

        // Move the downloaded file to the destination path
        Path destinationFilePath = new File(destinationPath , getFileNameFromUrl(fileUrl)).toPath();
        Files.move(downloadFilePath , destinationFilePath , StandardCopyOption.REPLACE_EXISTING);
    }

    private static String getFileNameFromUrl ( String fileUrl ) {
        return fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
    }
}

