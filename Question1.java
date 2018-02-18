import java.io.*;

public class Question1 {

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new FileReader(file));
        File afile = new File("/home/chunky/IdeaProjects/AssignmentStreamJava8/src/folder1/file.txt");
        File bfile = new File("/home/chunky/IdeaProjects/AssignmentStreamJava8/src/folder2/file.txt");
        InputStream inStream = null;
        OutputStream outStream = null;
        inStream = new FileInputStream(afile);
        outStream = new FileOutputStream(bfile);

        byte[] buffer = new byte[1024];

        int length;
        //copy the file content in bytes
        while ((length = inStream.read(buffer)) > 0) {
            outStream.write(buffer, 0, length);
        }

        inStream.close();
        outStream.close();


    }
}
