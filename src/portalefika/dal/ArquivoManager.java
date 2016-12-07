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

    private final String str;

    private final File file;

    public ArquivoManager() {
        this.str = StringUtil.randomString(20);
        this.file = new File("C:/UploadedFiles/portalefika", str);
    }

    public String upload(UploadedFile foto) throws UploadException {
        try {
            foto.writeTo(file);
            return str;
        } catch (IOException e) {
            throw new UploadException("Falha ao realizar Upload.");
        }

    }

}
