package portalefika.dal;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import java.io.File;
import java.io.IOException;
import portalefika.dal.exception.UploadException;
import portalefika.util.StringUtil;

/**
 *
 * @author G0042204
 */
public class ArquivoManager {

    private String str;

    private File file;

    private static final String DIR = "C:/UploadedFiles/portalefika";

    public ArquivoManager() {
        this.str = StringUtil.randomString(20);
        this.file = null;
    }

    public String upload(UploadedFile foto) throws UploadException {
        try {

            String imgUrl = this.str + StringUtil.getArquivoSuffix(foto.getFileName());
            this.file = new File(DIR, imgUrl);
            foto.writeTo(file);
            return imgUrl;

        } catch (IOException e) {
            throw new UploadException("Falha ao realizar Upload.");
        }
    }
}
