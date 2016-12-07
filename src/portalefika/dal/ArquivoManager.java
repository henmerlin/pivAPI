/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.dal;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import portalefika.comunicao.entidades.Conteudo;

/**
 *
 * @author G0042204
 */
public class ArquivoManager {

    private File file;

    public ArquivoManager() {

    }

    public void upload(UploadedFile foto) throws Exception {
        file = new File("C:/UploadedFiles/portalefika", foto.getFileName());
        foto.writeTo(file);
    }

}
