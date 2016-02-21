package Test;

import java.io.File;

public class SendReportToEmail {
    private final String SOURCE_ZIP = "/home/anna/Documents/";      // путь где будет форироваться архив "data"/
    private final String SOURCE_FOLDER = "/home/anna/Documents/P";   // путь к папке с отчетами
    private String zipArchive; //путь к zip файл с отчетами

    public SendReportToEmail() {

        CreateZipArchive archive = new CreateZipArchive();
        zipArchive = archive.init(SOURCE_FOLDER, SOURCE_ZIP);

        CreateSendMail sendMail = new CreateSendMail();
        boolean b = sendMail.init(zipArchive);

        if (b) {
         // delete zipArchive
            File file = new File(zipArchive);
            file.delete();
        }
    }
}
